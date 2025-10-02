package com.shoes.backend.Service.UserService;

import com.shoes.backend.Entity.User;
import com.shoes.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
//    @Transactional(rollbackOn = UsernameNotFoundException.class)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findUserByEmail(username);
        if(user == null)
            throw new UsernameNotFoundException(username);

        return new UserDetailPrincipalService(user);
    }
}
