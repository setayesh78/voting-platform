package webSecondQuestion.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webSecondQuestion.model.db.Comment;
import webSecondQuestion.request.CommentList;

import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    Optional<Comment> findBymovieId(String movieName);

    Optional<Comment> findById(Integer id);


}
