package webSecondQuestion.services;

import webSecondQuestion.model.db.Movie;
import webSecondQuestion.request.CommentList;

import java.util.List;

public interface PublicService {

    CommentList getComments(String movieName);

    List<Movie> getMovies();

    Movie getMovie(Integer id);
}
