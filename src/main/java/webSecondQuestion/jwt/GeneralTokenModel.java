package webSecondQuestion.jwt;

import java.util.Calendar;
import java.util.Date;

public class GeneralTokenModel {
    public static final String USERNAME = "USERNAME";
    public static final String STEP = "STEP";
    public static final String PASSWORD = "PASSWORD";
    public static final String ISSUED_AT = "ISSUED_AT";
    public static final String EXPIRES_AT = "EXPIRES_AT";
    private String username;
    private String step;
    private Date issuedAt;
    private Date expiresAt;
    private String password;
    private String tokenValidate;

    public GeneralTokenModel() {
    }

    public static String getMOBILE() {
        return USERNAME;
    }


    public static String getSTEP() {
        return STEP;
    }

    public static String getDATA() {
        return PASSWORD;
    }


    public GeneralTokenModel(String username, String step, Integer expirationSeconds, String password) {
        this.issuedAt = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.issuedAt);
        calendar.add(13, expirationSeconds);
        this.expiresAt = calendar.getTime();
        this.username = username;
        this.step = step;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }


    public String getStep() {
        return this.step;
    }

    public Date getIssuedAt() {
        return this.issuedAt;
    }

    public Date getExpiresAt() {
        return this.expiresAt;
    }

    public String getPassword() {
        return this.password;
    }


    public String getTokenValidate() {
        return this.tokenValidate;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setStep(String step) {
        this.step = step;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setTokenValidate(String tokenValidate) {
        this.tokenValidate = tokenValidate;
    }
}
