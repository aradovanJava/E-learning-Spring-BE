package hr.algebra.e_learning.controller;

import hr.algebra.e_learning.dto.security.AuthRequestDTO;
import hr.algebra.e_learning.dto.security.AuthResponseDTO;
import hr.algebra.e_learning.dto.security.RefreshTokenRequestDTO;
import hr.algebra.e_learning.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDTO authenticate(@RequestBody final AuthRequestDTO authRequest) {
        return authService.login(authRequest);
    }

    @PostMapping("/refreshToken")
    public AuthResponseDTO refreshToken(@RequestBody final RefreshTokenRequestDTO refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }
}
