package webSecondQuestion.jwt;

import com.auth0.jwt.exceptions.TokenExpiredException;
import webSecondQuestion.common.BusinessExceptionCode;
import webSecondQuestion.common.GeneralMicroserviceException;
import webSecondQuestion.utils.ContextUtil;

import java.text.ParseException;
import java.util.Date;

public class RegisterTokenUtil {
    public static String getCustomerIdFromRegisterToken(String registerToken) {
        try {
            return ContextUtil.getContext().getBean(JWTUtil.class).getRegisterTokenObjectFromRegisterTokenString(registerToken).getUsername();
        } catch (TokenExpiredException | ParseException e) {
            throw new GeneralMicroserviceException("webSecondQuestion", BusinessExceptionCode.INVALID_REGISTER_TOKEN.getValue(), e.getMessage());
        }
    }


    public static Date getExDateFromRegisterToken(String registerToken) {
        try {
            return ContextUtil.getContext().getBean(JWTUtil.class).getRegisterTokenObjectFromRegisterTokenString(registerToken).getExpirationDate();
        } catch (TokenExpiredException | ParseException e) {
            throw new GeneralMicroserviceException("webSecondQuestion", BusinessExceptionCode.INVALID_REGISTER_TOKEN.getValue(), e.getMessage());
        }
    }
}
