package webSecondQuestion.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webSecondQuestion.common.RegisterService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
@Slf4j
public class RegisterController {

    private final RegisterService registerService;


    @PostMapping(path = "/{username}/{password}")
    public ResponseEntity<Void> sendOtp(@PathVariable("username") String username,
                                        @PathVariable("password") String password){

        String token = registerService.generateRegistrationOtpToken(username, password);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("TOKEN", token);
        return ResponseEntity.ok().headers(responseHeaders).body(null);
    }
}