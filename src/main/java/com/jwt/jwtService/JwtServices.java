package com.jwt.jwtService;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;

import com.jwt.configuration.KeyConfiguration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtServices {

    KeyConfiguration secretKey;

    public String extractUsername(String token) {
        return null;

    }
    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claim = extractAllclaims(token);
        return claimsResolver.apply(claim);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token)); 

    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    

    

    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails);

    }

    private SecretKey setSignInkey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey.getSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
        
    }

    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {

        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(setSignInkey())
                .compact();
    }

    private Claims extractAllclaims(String token) {
        Jws<Claims> signedClaims = Jwts.parser().verifyWith(setSignInkey()).build().parseSignedClaims(token);
        return signedClaims.getPayload();
    }

}
