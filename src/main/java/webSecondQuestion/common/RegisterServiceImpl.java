package webSecondQuestion.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webSecondQuestion.jwt.GeneralTokenModel;
import webSecondQuestion.jwt.JWTUtil;

import java.util.Calendar;
import java.util.Date;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    private final JWTUtil jwtUtil;

    public RegisterServiceImpl(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String generateRegistrationOtpToken(String username, String password) {
            GeneralTokenModel model1 = new GeneralTokenModel();
            model1.setUsername(username);
            model1.setStep("STEP_VERIFY_OTP");
            Date issuedAtDate = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(issuedAtDate);
            c.add(Calendar.MINUTE, 3);
            model1.setIssuedAt(issuedAtDate);
            model1.setExpiresAt(c.getTime());
            model1.setPassword(password);
            return jwtUtil.generateGeneralModelToken(model1);
    }


}
