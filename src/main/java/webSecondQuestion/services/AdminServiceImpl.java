package webSecondQuestion.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webSecondQuestion.model.db.Movie;
import webSecondQuestion.mongodb.CommentRepository;
import webSecondQuestion.mongodb.MovieRepository;
import webSecondQuestion.request.ApprovedOrNot;
import webSecondQuestion.request.MovieBody;

import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final MovieRepository movieRepository;

    private final CommentRepository commentRepository;

    @Override
    public void save(MovieBody movieBody) {
        int id = (int) movieRepository.count();
        id++;
        movieRepository.save(
                new Movie()
                        .setId(id)
                        .setName(movieBody.getName())
                        .setDescription(movieBody.getDescription())
                        .setRating(movieBody.getRating())
                        .setComments(movieBody.getComments())

        );
    }

    @Override
    public void update(Integer id, MovieBody movieBody) {

        movieRepository.save(
                movieRepository.findById(id)
                        .map(movie -> {
                            movie.applyMovie(movieBody);
                            return movie;
                        }).orElse(
                        new Movie().setId(id)
                                .setName(movieBody.getName())
                                .setDescription(movieBody.getDescription())
                                .setRating(movieBody.getRating())
                                .setComments(movieBody.getComments())
                )
        );

    }


    @Override
    public void delete(Integer id) {
        Optional<Movie> byId = movieRepository.findById(id);
        byId.ifPresent(movieRepository::delete);
    }


    @Override
    public void updateComment(Integer commentId, ApprovedOrNot isApproved) {
        commentRepository.findById(commentId).map(comment -> {
            comment.setApproved(isApproved.getApproved());
            return comment;
        });
    }


//    @Override
//    public List<FavMenu> list(String userId) {
//        return userCustomizationRepository.findByUserId(userId).map(userCustomization ->
//                userCustomization.getFavMenuList().stream().sorted().collect(Collectors.toList())
//        ).orElse(provideDefaultFavMenuList());
//    }
//
//    private List<FavMenu> provideDefaultFavMenuList() {
//        try {
//            if (CollectionUtils.isEmpty(defaultFavMenuList)) {
//                File file = resourceLoader.getResource("classpath:default-favorite-menu.json").getFile();
//                defaultFavMenuList = JsonUtil.parseJsonOfList(file, FavMenu.class);
//            }
//            return defaultFavMenuList;
//        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
//        }
//        return new ArrayList<>();
//    }
//



}
