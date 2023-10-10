package hr.algebra.e_learning.service.security;

import hr.algebra.e_learning.entity.Student;
import hr.algebra.e_learning.repository.StudentRepository;
import hr.algebra.e_learning.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StudentRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<Student> user = userRepository.findStudentByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found...");
        }

        final PasswordEncoder encoder = new BCryptPasswordEncoder();
        return new UserDetailsImpl(
                username,
                encoder.encode(user.get().getPassword()),
                List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
    }
}
