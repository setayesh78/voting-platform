package webSecondQuestion.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserBody {
    private Integer id;
    private String password;
    private String username;
    private Integer role;
}
