package com.shoes.backend.Service.UserService;

import com.shoes.backend.DTO.UserDTO.CodeActivateDTO;
import com.shoes.backend.DTO.UserDTO.UserLoginDTO;
import com.shoes.backend.DTO.UserDTO.UserRegisterDTO;
import com.shoes.backend.Entity.User;
import com.shoes.backend.Helper.Email;
import com.shoes.backend.Repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Email email;

    private final AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public UserService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Async
    @Transactional(rollbackOn = Throwable.class)
    public CompletableFuture<ResponseEntity<Object>> login(UserLoginDTO userDTO) throws Exception {
        System.out.println("user");

        User user = this.userRepository.findUserByEmail(userDTO.getEmail());

        if (user == null)
            throw new RuntimeException("user not found");

        try {

            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));

            String token = this.jwtService.generateToken(user);

            if(token.isEmpty())
                throw new RuntimeException("you need to login");
            System.out.println(token);
            return CompletableFuture.completedFuture(ResponseEntity.ok().body(token));


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("password invalid");
        }


    }

    @Async
    @Transactional(rollbackOn = Throwable.class)
    public CompletableFuture<ResponseEntity<String>> register(UserRegisterDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(this.bCryptPasswordEncoder.encode(userDTO.getPassword()));


        Random random = new Random();
        int firstCode = random.nextInt(9) + 1;
        int code = random.nextInt(1000) + 1;
        String activationCode = firstCode + String.format("%03d", code);

        user.setCodeActivation(Integer.parseInt(activationCode));

        this.userRepository.save(user);

        this.email.sendEmail(user.getEmail(), "activate account", user.getCodeActivation().toString());


        return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.CREATED).body("your account was created, we send the code activation in your email."));

    }

    @Async
    @Transactional(rollbackOn = Throwable.class)
    public CompletableFuture<ResponseEntity<String>> activateAccount(@Valid CodeActivateDTO codeActivate, String email) {

        User user = this.userRepository.findUserByEmail(email);

        if (user.getId() == null)
            throw new RuntimeException("user not exist");

        if (codeActivate.getCode_activation().equals(user.getCodeActivation())) {
            user.setActivateAccount(true);
            user.setCodeActivation(null);
        } else
            throw new RuntimeException("invalid code");

        return null;

    }
}
