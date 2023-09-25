package ibm.fscc.login.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details from your data source based on the provided username
        // You can use a repository or service to fetch the user details
        // Construct and return an instance of UserDetails (e.g., using User class)
        return User.builder()
            .username(username)
            .password("password") // Replace with actual password retrieval logic
            .roles("USER") // Replace with actual user roles/authorities retrieval logic
            .build();
    }
}