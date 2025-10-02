package com.shoes.backend.Entity;

import com.shoes.backend.Entity.Base.Base;
import com.shoes.backend.Enum.Gender;
import com.shoes.backend.Enum.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Data
public class User extends Base {
    private String firstName;
    private String middleName;
    private String lastName;
    private String profile = "profile.png";

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(10)
    @Max(10)
    private Integer phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(4)
    @Max(4)
    private Integer pin;

    @Enumerated(EnumType.STRING)
    private Role role = Role.CLIENT;
    private boolean isActivateAccount = false;

    @Digits(fraction = 0, integer = 4)
    private Integer codeActivation;

    private LocalDateTime lastLogin;
}
