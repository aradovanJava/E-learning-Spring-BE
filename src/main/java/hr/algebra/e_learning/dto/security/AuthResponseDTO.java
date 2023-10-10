package hr.algebra.e_learning.dto.security;

import lombok.Builder;

@Builder
public record AuthResponseDTO(String accessToken, String refreshToken) {
}
