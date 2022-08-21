package webSecondQuestion.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import webSecondQuestion.request.CommentList;
import webSecondQuestion.request.MovieBody;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@Accessors(chain = true)
public class Movie implements Serializable {
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private Double rating;

    private List<CommentList> comments = new ArrayList<>();


    @JsonIgnore
    public void applyMovie(MovieBody movieBody) {
        name = movieBody.getName();
        description = movieBody.getDescription();
        rating = movieBody.getRating();
    }

}
