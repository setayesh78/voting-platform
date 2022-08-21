package webSecondQuestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webSecondQuestion.jwt.RegisterTokenUtil;
import webSecondQuestion.request.SubmitComment;
import webSecondQuestion.request.SubmitVote;
import webSecondQuestion.services.UserService;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;


    @PostMapping("/vote")
    public ResponseEntity<String> submitVote(@RequestHeader("TOKEN") String token,
                                           @RequestBody @Valid SubmitVote requestBody) {
        String userId = RegisterTokenUtil.getCustomerIdFromRegisterToken(token);
        if (userId.equals("user")) {
            userService.submitOrEditVote(requestBody);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return new ResponseEntity<>("only admin can access!", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/comment")
    public ResponseEntity<String> submitComment(@RequestHeader("TOKEN") String token,
                                           @RequestBody @Valid SubmitComment requestBody) {
        String userId = RegisterTokenUtil.getCustomerIdFromRegisterToken(token);
        if (userId.equals("user")) {
            userService.submitOrEditComment(requestBody);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>("only admin can access!", HttpStatus.BAD_REQUEST);
        }
    }

}
