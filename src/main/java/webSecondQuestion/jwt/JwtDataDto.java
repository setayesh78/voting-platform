package webSecondQuestion.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtDataDto implements Serializable {

    private String username;
    private List<String> rolesName;
    private String customerId;

    public String getUsername() {
        return username;
    }

    public List<String> getRolesName() {
        return rolesName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRolesName(List<String> rolesName) {
        this.rolesName = rolesName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}