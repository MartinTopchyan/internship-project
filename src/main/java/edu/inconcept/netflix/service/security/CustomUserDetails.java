package edu.inconcept.netflix.service.security;
import edu.inconcept.netflix.entity.SystemUser;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends SystemUser implements UserDetails {
    public CustomUserDetails(SystemUser user) {
        super(user);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection)this.getRoles().stream().map((role) -> {
            return new SimpleGrantedAuthority("ROLE_" + role.getRole());
        }).collect(Collectors.toList());
    }

    public String getPassword() {
        return super.getPassword();
    }

    public String getUsername() {
        return super.getName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
