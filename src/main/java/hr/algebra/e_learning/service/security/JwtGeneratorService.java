package hr.algebra.e_learning.service.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JwtGeneratorService {
    String extractUsername(String token);

    Date extractExpiration(String token);

    String generateToken(final String username);

    Boolean validateToken(String token, UserDetails userDetails);
}
