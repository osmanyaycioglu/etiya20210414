package com.training.micro.validation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.micro.validation.security.user.UserObject;
import com.training.micro.validation.security.user.service.UserManager;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserManager um;

    @Override
    public UserDetails loadUserByUsername(final String usernameParam) throws UsernameNotFoundException {
        UserObject userLoc = this.um.getUser(usernameParam);
        if (userLoc == null) {
            throw new UsernameNotFoundException("Böyle bir user yok");
        }

        return User.builder()
                   .password(userLoc.getPassword())
                   .username(usernameParam)
                   .roles(userLoc.getRole())
                   .build();
    }

}
