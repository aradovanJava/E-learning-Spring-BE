package hr.algebra.e_learning.dto.security;

import lombok.Builder;

@Builder
public record AuthRequestDTO(String username, String password) {
}
