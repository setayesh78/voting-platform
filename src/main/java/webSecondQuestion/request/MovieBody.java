package webSecondQuestion.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class MovieBody implements Serializable {

        @NotBlank
        private String name;

        @NotBlank
        private String description;

        private Double rating;

        private List<CommentList> comments;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Double getRating() {
                return rating;
        }

        public void setRating(Double rating) {
                this.rating = rating;
        }

        public List<CommentList> getComments() {
                return comments;
        }

        public void setComments(List<CommentList> comments) {
                this.comments = comments;
        }




}
