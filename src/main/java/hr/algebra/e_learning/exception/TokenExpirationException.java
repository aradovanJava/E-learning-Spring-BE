package hr.algebra.e_learning.exception;

import lombok.Getter;

@Getter
public class TokenExpirationException extends RuntimeException {
    private final String errorMessage;

    public TokenExpirationException(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
