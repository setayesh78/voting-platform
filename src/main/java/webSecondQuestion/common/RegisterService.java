package webSecondQuestion.common;

import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    String generateRegistrationOtpToken(String mobileNo, String nationalCode);
}
