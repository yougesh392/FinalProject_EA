package com.blogginService.Blogging_Service.Controllers;

import org.springframework.util.MultiValueMap;

public class BlogErrorType{
    private String errorMessage;
    public BlogErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
}
