package webSecondQuestion.services;


import webSecondQuestion.request.SubmitComment;
import webSecondQuestion.request.SubmitVote;

public interface UserService {

    void submitOrEditVote(SubmitVote submit);

    void submitOrEditComment(SubmitComment submitComment);

}
