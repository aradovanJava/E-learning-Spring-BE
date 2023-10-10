package hr.algebra.e_learning.service;

import hr.algebra.e_learning.converter.StudentConverter;
import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.dto.security.AuthResponseDTO;
import hr.algebra.e_learning.dto.security.RefreshTokenRequestDTO;
import hr.algebra.e_learning.entity.RefreshToken;
import hr.algebra.e_learning.entity.Student;
import hr.algebra.e_learning.repository.StudentRepository;
import hr.algebra.e_learning.service.security.JwtGeneratorService;
import hr.algebra.e_learning.service.security.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository userRepository;
    private final JwtGeneratorService jwtGeneratorService;
    private final RefreshTokenService refreshTokenService;
    private final StudentConverter userConverter;

    @Override
    public AuthResponseDTO login(final AuthRequestDTO authRequest) {
        final Optional<Student> user = userRepository.findStudentByUsernameAndPassword(authRequest.username(), authRequest.password());

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found...");
        }

        return generateToken(authRequest);
    }

    @Override
    public AuthResponseDTO register(final AuthRequestDTO authRequest) {
        final Optional<Student> user = userRepository.findStudentByUsername(authRequest.username());
        if (user.isPresent()) {
            throw new RuntimeException("The user already exits...");
        }

        final Student newUser = userConverter.toEntity(authRequest);
        userRepository.save(newUser);

        return generateToken(authRequest);
    }

    @Override
    public AuthResponseDTO refreshToken(final RefreshTokenRequestDTO request) {
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

    private AuthResponseDTO generateToken(final AuthRequestDTO authRequest) {
        final RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequest.username());
        return AuthResponseDTO.builder()
                .accessToken(jwtGeneratorService.generateToken(authRequest.username()))
                .refreshToken(refreshToken.getToken())
                .build();
    }
}
