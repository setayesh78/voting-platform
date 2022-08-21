package webSecondQuestion.services;


import webSecondQuestion.request.ApprovedOrNot;
import webSecondQuestion.request.MovieBody;

public interface AdminService {

    void save(MovieBody movieBody);

    void update(Integer id, MovieBody movieBody);

    void updateComment(Integer id, ApprovedOrNot isApproved);

//    List<FavMenu> list(String userId);
//
    void delete(Integer id);
}
