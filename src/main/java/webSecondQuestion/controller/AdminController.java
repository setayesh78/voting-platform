package webSecondQuestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webSecondQuestion.jwt.RegisterTokenUtil;
import webSecondQuestion.request.ApprovedOrNot;
import webSecondQuestion.request.CommentList;
import webSecondQuestion.request.MovieBody;
import webSecondQuestion.services.AdminService;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {
    private final AdminService adminService;


    @PostMapping("/movie")
    public ResponseEntity<String> addMovie(@RequestHeader("TOKEN") String token,
                                           @RequestBody @Valid MovieBody requestBody) {
        String userId = RegisterTokenUtil.getCustomerIdFromRegisterToken(token);
        if (userId.equals("admin")) {
            adminService.save(requestBody);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return new ResponseEntity<>("only admin can access!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<String> updateMovie(@RequestHeader("TOKEN") String token,
                                           @PathVariable(value = "id",required = true) Integer id,
                                           @RequestBody @Valid MovieBody requestBody) {
        String userId = RegisterTokenUtil.getCustomerIdFromRegisterToken(token);
        if (userId.equals("admin")) {
            adminService.update(id, requestBody);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return new ResponseEntity<>("only admin can access!", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/movie/{id}")
    public ResponseEntity<String> deleteMovie(@RequestHeader("TOKEN") String token,
                                            @PathVariable(value = "id",required = true) Integer id) {

        String userId = RegisterTokenUtil.getCustomerIdFromRegisterToken(token);
        if (userId.equals("admin")) {
            adminService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return new ResponseEntity<>("only admin can access!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<String> updateComment(@RequestHeader("TOKEN") String token,
                                              @PathVariable(value = "id",required = true) Integer commentId,
                                              @RequestBody @Valid ApprovedOrNot requestBody) {
        String userId = RegisterTokenUtil.getCustomerIdFromRegisterToken(token);
        if (userId.equals("admin")) {
            adminService.updateComment(commentId, requestBody);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return new ResponseEntity<>("only admin can access!", HttpStatus.BAD_REQUEST);
        }
    }


}
