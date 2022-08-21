package webSecondQuestion.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import webSecondQuestion.request.MovieBody;
import webSecondQuestion.request.SubmitVote;

import java.io.Serializable;


@Document
@Data
@Accessors(chain = true)
public class Vote implements Serializable {
    @Id
    private Integer id;

    private User user;

    private Double rating;

    private Integer movieID;


    @JsonIgnore
    public void applyVote(SubmitVote submit) {
        movieID = submit.getMovieId();
        rating = (double)submit.getVote();
    }
}
