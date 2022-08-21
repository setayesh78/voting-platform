package webSecondQuestion.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webSecondQuestion.model.db.Comment;
import webSecondQuestion.model.db.Vote;

import java.util.Optional;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {

    Optional<Vote> findBymovieId(Integer id);


}
