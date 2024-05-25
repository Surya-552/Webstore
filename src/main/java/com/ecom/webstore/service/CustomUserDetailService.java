package com.ecom.webstore.service;

import com.ecom.webstore.model.CustomUserDetail;
import com.ecom.webstore.model.User;
import com.ecom.webstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional <User> user=userRepository.findUserByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("User not find"));
        return user.map(CustomUserDetail::new).get();
    }
}
