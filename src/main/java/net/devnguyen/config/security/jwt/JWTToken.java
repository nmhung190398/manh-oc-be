package net.devnguyen.config.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class JWTToken {
    private String accessToken;

    private String refreshToken;

    private String type;
}
