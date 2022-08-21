package webSecondQuestion.request;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class CommentList {

    private String movie;
    private CommentsArray comments;

}
