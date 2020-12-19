package com.heima.heimasalespersion.userinterface;

public class Result {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Result ok(){
        return new Result(){{
            setMessage("ok");
        }};
    }
}
