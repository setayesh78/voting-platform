package webSecondQuestion.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@AllArgsConstructor
@Data
public class RegisterToken {
    private String sendOTPId;

    public RegisterToken() {

    }

    public String getSendOTPId() {
        return sendOTPId;
    }

    public void setSendOTPId(String sendOTPId) {
        this.sendOTPId = sendOTPId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTokenValidate() {
        return tokenValidate;
    }

    public void setTokenValidate(String tokenValidate) {
        this.tokenValidate = tokenValidate;
    }


    private Date createDate;
    private Date expirationDate;
    private String username;
    private String deviceId;
    private String version;
    private String tokenValidate;

    public RegisterToken(String sendOTPId, String sentOtp, String username) {
        this.sendOTPId = sendOTPId;
        this.username = username;
    }

    public RegisterToken(String id, String username, String deviceId, String version, String tokenValidate) {
        this.username = username;
        this.deviceId = deviceId;
        this.version = version;
        this.tokenValidate=tokenValidate;
    }
}
