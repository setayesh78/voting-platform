package webSecondQuestion.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import webSecondQuestion.common.BusinessExceptionCode;
import webSecondQuestion.common.SecurityConfigurationException;
import webSecondQuestion.model.RegisterToken;

import java.text.ParseException;
import java.util.*;


@Component
@Slf4j
public class JWTUtil implements InitializingBean {

    private final static String TOKEN_PREFIX = "Bearer ";

    @Value("${jwtKey}")
    private String secret;

    @Value("${jwtExpiration}")
    private Long expiration;

    public String getUsernameFromToken(String token) {
        final Claims claims = getClaimsFromToken(token);
        if (claims == null)
            throw new RuntimeException("Invalid token Exception");
        return claims.getSubject();
    }

    public Date getCreatedDateFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return new Date((Long) claims.get(Claims.ISSUED_AT));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(BusinessExceptionCode.JWT_PARSE_EXCEPTION.name(), e);
        }
    }

    public Date getExpirationDateFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return claims.getExpiration();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(BusinessExceptionCode.JWT_PARSE_EXCEPTION.name(), e);
        }
    }

    private Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(extractTokenData(token))
                    .getBody();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
//            throw new BusinessExceptionCode.JWT_PARSE_EXCEPTION;
        }
        return null;
    }


    private List<String> convertCommaSeparatedToList(String str) {
        String parts[] = StringUtils.commaDelimitedListToStringArray(str);
        if (parts == null || parts.length == 0) {
            return null;
        } else {
            return new ArrayList<>(Arrays.asList(parts));
        }
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private Date generateAdvocateExpirationDate() {

        return new Date(System.currentTimeMillis() + 12000000);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public RegisterToken getRegisterTokenObjectFromRegisterTokenString(String token) throws ParseException {

        if (token.startsWith(TOKEN_PREFIX)) {
            token = token.substring(7, token.length());
        }
        Claims claims = getClaimsFromToken(token);
        RegisterToken model = new RegisterToken();
        model.setUsername(claims.get(CustomClaims.USERNAME).toString());
        model.setExpirationDate(new Date(Long.parseLong(claims.get(Claims.EXPIRATION).toString())));
//        model.setCreateDate(new Date(Long.parseLong(claims.get(Claims.ISSUED_AT).toString())));
        return model;

    }


    public String generateGeneralModelToken(GeneralTokenModel model) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(GeneralTokenModel.USERNAME, model.getUsername());
        claims.put(GeneralTokenModel.STEP, model.getStep());
        claims.put(GeneralTokenModel.ISSUED_AT, model.getIssuedAt());
        claims.put(GeneralTokenModel.EXPIRES_AT, model.getExpiresAt());
        claims.put(GeneralTokenModel.PASSWORD, model.getPassword());
        return generateToken(claims);
    }


    public String generateToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return TOKEN_PREFIX + token;
    }

    public String generateRegisterToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return TOKEN_PREFIX + token;
    }

    private String generateIamToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateAdvocateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return TOKEN_PREFIX + token;
    }

    public String refreshToken(String token) {
        if (token.startsWith(TOKEN_PREFIX)) {
            token = token.substring(7, token.length());
        }
        String refreshedToken;
        final Claims claims = getClaimsFromToken(token);
        claims.put(Claims.EXPIRATION, generateExpirationDate());
        refreshedToken = generateToken(claims);

        return refreshedToken;
    }

    @Override
    public void afterPropertiesSet() {
        if (org.apache.commons.lang3.StringUtils.isBlank(secret) || secret.length() < 10) {
            throw new SecurityConfigurationException("jwtkey is blank or shorter than 10 characters");
        }
        if (expiration == null || expiration < 60) {
            throw new SecurityConfigurationException("jwtExpiration is null or less than 60 seconds");
        }
    }

    private String extractTokenData(String token) {
        if (token.startsWith(TOKEN_PREFIX)) {
            token = token.substring(TOKEN_PREFIX.length());
        }
        return token;
    }
}
