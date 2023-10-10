package hr.algebra.e_learning.service;

import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.dto.security.AuthResponseDTO;
import hr.algebra.e_learning.dto.security.RefreshTokenRequestDTO;
import hr.algebra.e_learning.entity.RefreshToken;
import hr.algebra.e_learning.service.security.JwtGeneratorService;
import hr.algebra.e_learning.service.security.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtGeneratorService jwtGeneratorService;
    private final RefreshTokenService refreshTokenService;

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequest) {
        if (!Objects.equals(authRequest, new AuthRequestDTO("filip", "password"))) {
            throw new UsernameNotFoundException("User not found...");
        }
        final RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequest.username());
        return AuthResponseDTO.builder()
                .accessToken(jwtGeneratorService.generateToken(authRequest.username()))
                .refreshToken(refreshToken.getToken())
                .build();
    }

    @Override
    public AuthResponseDTO refreshToken(RefreshTokenRequestDTO request) {
        return refreshTokenService.findByToken(request.token())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUsername)
                .map(username -> {
                    final String accessToken = jwtGeneratorService.generateToken(username);
                    return AuthResponseDTO.builder()
                            .accessToken(accessToken)
                            .refreshToken(request.token())
                            .build();
                }).orElseThrow(() -> new RuntimeException("Refresh token doesn't exist..."));
    }
}
