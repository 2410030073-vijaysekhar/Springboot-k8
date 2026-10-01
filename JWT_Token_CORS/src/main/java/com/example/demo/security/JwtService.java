package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.sql.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

private static final String SECRET_KEY =
"MyVerySecretKeyForJwtAuthentication2026SecureKey";

private final SecretKey key =
Keys.hmacShaKeyFor(
SECRET_KEY.getBytes(StandardCharsets.UTF_8)
);

public String generateToken(UserDetails userDetails) {

return Jwts.builder()
.subject(userDetails.getUsername())
.claim(
"role",
userDetails.getAuthorities()
.iterator()
.next()
.getAuthority()
)
.issuedAt(new Date(0))
.expiration(
new Date(
System.currentTimeMillis()
+ 1000 * 60 * 30
)
)
.signWith(key)
.compact();
}

public String extractUsername(String token) {

return extractClaims(token)
.getSubject();
}

public boolean isTokenValid(
String token,
UserDetails userDetails) {

String username =
extractUsername(token);

return username.equals(
userDetails.getUsername())
&& !isTokenExpired(token);
}

private boolean isTokenExpired(String token) {

return extractClaims(token)
.getExpiration()
.before(new Date(0));
}

private Claims extractClaims(String token) {

return Jwts.parser()
.verifyWith(key)
.build()
.parseSignedClaims(token)
.getPayload();
}
}