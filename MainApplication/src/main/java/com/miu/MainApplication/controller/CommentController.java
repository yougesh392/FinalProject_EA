package com.miu.MainApplication.controller;

import com.miu.MainApplication.model.Comment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class CommentController {
    private final RestTemplate restTemplate;

    public CommentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/comments/all")
    public String getAllComments() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Comment> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://localhost:8088/comments", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/comments/save", method = RequestMethod.POST)
    public String saveComments(@RequestBody Comment comment) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Comment> entity = new HttpEntity<Comment>(comment,headers);

        return restTemplate.exchange("http://localhost:8088/comments", HttpMethod.POST, entity, String.class).getBody();
    }
}
