package com.heima.heimasalespersion.userinterface;

import com.heima.heimasalespersion.model.exceptions.EntityNotfoundException;
import com.heima.heimasalespersion.model.exceptions.ParamsErrorException;
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
    @ExceptionHandler(value= EntityNotfoundException.class)
    @ResponseBody
    public Error exceptionHandler(EntityNotfoundException e, HttpServletResponse response) {
        response.setStatus(404);
        response.setContentType("application/json;charset=UTF-8");
        return new Error() {{
            setMessage(e.getMessage());
        }};
    }
    @ExceptionHandler(value= ParamsErrorException.class)
    @ResponseBody
    public Error exceptionHandler(ParamsErrorException e, HttpServletResponse response) {
        response.setStatus(400);
        response.setContentType("application/json;charset=UTF-8");
        return new Error() {{
            setMessage(e.getMessage());
        }};
    }
    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    public Error exceptionHandler(Exception e, HttpServletResponse response) {
        response.setStatus(500);
        response.setContentType("application/json;charset=UTF-8");
        return new Error() {{
            setMessage("服务器发生异常");
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
