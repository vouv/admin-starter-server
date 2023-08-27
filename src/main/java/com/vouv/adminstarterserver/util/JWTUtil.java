package com.vouv.adminstarterserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
    private static final Algorithm ALGORITHM = Algorithm.HMAC512("admin-starter-server");
    public static final String ISSUER = "admin-starter-server";
    public static String encode(Long userId) {
        return JWT.create()
                .withIssuer(ISSUER)
                .withClaim("user_id", userId)
                .sign(ALGORITHM);

    }

    public static DecodedJWT decode(String token) {
        JWTVerifier verifier = JWT.require(ALGORITHM)
                .withIssuer(ISSUER)
                .build();

        return verifier.verify(token);
    }
}
