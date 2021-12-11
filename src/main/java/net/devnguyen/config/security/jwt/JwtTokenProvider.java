package net.devnguyen.config.security.jwt;

public interface JwtTokenProvider<Playload> {

    Playload parseToken(String token);

    JWTToken generateToken(Playload playload);
}
