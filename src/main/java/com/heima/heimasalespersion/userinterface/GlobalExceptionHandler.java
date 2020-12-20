package com.heima.heimasalespersion.userinterface;

import com.heima.heimasalespersion.model.exceptions.ThirdException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value= ThirdException.class)
    @ResponseBody
    public Error exceptionHandler(ThirdException e, HttpServletResponse response) {
        response.setStatus(500);
        response.setContentType("application/json;charset=UTF-8");
        return new Error() {{
            setMessage(e.getMessage());
        }};
    }

    public static class Error{
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
