package edu.inconcept.netflix.service.security;

import edu.inconcept.netflix.entity.SystemUser;
import edu.inconcept.netflix.repository.SystemUserRepository;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private SystemUserRepository systemUserRepository;

    public CustomUserDetailService() {
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<SystemUser> optionalUser = this.systemUserRepository.findByName(userName);
        optionalUser.orElseThrow(() -> {
            return new UsernameNotFoundException("UserName not found");
        });
        return (UserDetails)optionalUser.map(CustomUserDetails::new).get();
    }
}
