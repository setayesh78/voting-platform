package webSecondQuestion.model.db;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document
@Data
@Accessors(chain = true)
public class User implements Serializable {
    @Id
    private Integer id;

    private Integer role;

    private String username;

    @Value("${cipher.encryption.key}")
    private String password;

}
