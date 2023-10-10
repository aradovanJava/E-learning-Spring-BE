package hr.algebra.e_learning.service;

import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.dto.security.AuthResponseDTO;
import hr.algebra.e_learning.dto.security.RefreshTokenRequestDTO;

public interface AuthService {
    AuthResponseDTO login(AuthRequestDTO authRequest);

    AuthResponseDTO refreshToken(RefreshTokenRequestDTO request);
}
