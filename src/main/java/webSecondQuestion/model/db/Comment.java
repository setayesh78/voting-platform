package webSecondQuestion.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import webSecondQuestion.request.SubmitComment;
import webSecondQuestion.request.SubmitVote;
import webSecondQuestion.request.UserBody;

import java.io.Serializable;
import java.util.Date;


@Document
@Data
@Accessors(chain = true)
public class Comment implements Serializable {
    @Id
    private Integer id;

    private UserBody user;
    private String comment;
    private Boolean approved;
    private Date createdAt = new Date();
    private String movieID;

    @JsonIgnore
    public void applyComment(SubmitComment submit) {
        movieID = submit.getMovie_id().toString();
        comment = submit.getComment_body();
    }
}
