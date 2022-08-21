package webSecondQuestion.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webSecondQuestion.model.db.Comment;
import webSecondQuestion.model.db.Movie;
import webSecondQuestion.mongodb.CommentRepository;
import webSecondQuestion.mongodb.MovieRepository;
import webSecondQuestion.request.CommentList;
import webSecondQuestion.request.CommentsArray;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublicServiceImpl implements PublicService {
    private final CommentRepository commentRepository;
    private final CommentList commentList;
    private final MovieRepository movieRepository;
    private final Movie movie;

    @Override
    public CommentList getComments(String movieName) {
        CommentsArray commentsArray = new CommentsArray();
        Optional<Comment> bymovieId = commentRepository.findBymovieId(movieName);
        if(bymovieId.isPresent()){
            commentList.setMovie(movieName);
            commentsArray.setId(bymovieId.get().getId());
            commentsArray.setAuthor(bymovieId.get().getUser().getUsername());
            commentsArray.setBody(bymovieId.get().getComment());
            commentList.setComments(commentsArray);
        }
        return commentList;
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(Integer id) {
        Optional<Movie> byId = movieRepository.findById(id);
        if(byId.isPresent()){
            movie.setComments(byId.get().getComments());
            movie.setDescription(byId.get().getDescription());
            movie.setId(id);
            movie.setName(byId.get().getName());
            movie.setRating(byId.get().getRating());
        }
        return movie;
    }



}
