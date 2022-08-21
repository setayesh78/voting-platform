package webSecondQuestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webSecondQuestion.model.db.Movie;
import webSecondQuestion.request.CommentList;
import webSecondQuestion.services.PublicService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("public")
public class PublicController {
    private final PublicService publicService;

    @GetMapping("/comments")
    public ResponseEntity<CommentList> getComments(@RequestParam(value = "movieName", required = true) String movieName) {
        return ResponseEntity.ok(publicService.getComments(movieName));
    }


    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(publicService.getMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable(value = "id",required = true) Integer id) {
        return ResponseEntity.ok(publicService.getMovie(id));
    }

}

