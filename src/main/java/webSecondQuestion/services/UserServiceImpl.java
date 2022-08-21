package webSecondQuestion.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webSecondQuestion.model.db.Comment;
import webSecondQuestion.model.db.Vote;
import webSecondQuestion.mongodb.CommentRepository;
import webSecondQuestion.mongodb.VoteRepository;
import webSecondQuestion.request.SubmitComment;
import webSecondQuestion.request.SubmitVote;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final VoteRepository voteRepository;
    private final CommentRepository commentRepository;

    @Override
    public void submitOrEditVote(SubmitVote submit) {
        voteRepository.save(
                voteRepository.findBymovieId(submit.getMovieId())
                        .map(vote -> {
                            vote.applyVote(submit);
                            return vote;
                        }).orElse(
                        new Vote().setMovieID(submit.getMovieId())
                                .setRating((double) submit.getVote()))
        );

    }

    @Override
    public void submitOrEditComment(SubmitComment submitComment) {
        commentRepository.save(
                commentRepository.findBymovieId(submitComment.getMovie_id().toString())
                        .map(comment -> {
                            comment.applyComment(submitComment);
                            return comment;
                        }).orElse(
                        new Comment().setMovieID(submitComment.getMovie_id().toString())
                                .setComment(submitComment.getComment_body()))
        );
    }
}
