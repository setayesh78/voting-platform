package webSecondQuestion.jwt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CustomerDto implements Serializable {

    private String id;
    private String username;
    private String mobile;
    private Date birthDate;
    private Date shahkarVerifyDate;
    private Date shahkarRejectDate;
    private Date registrationDate;
    private Boolean customerIsActive;
    private String tokenValidate;

}
