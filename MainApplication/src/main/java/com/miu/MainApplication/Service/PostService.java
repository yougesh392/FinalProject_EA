package com.miu.MainApplication.Service;

import com.miu.MainApplication.DTO.PostDTO;
import com.miu.MainApplication.DTO.PostSaveDTO;
import com.miu.MainApplication.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Service
public class PostService implements IPostService {
    @Autowired
    private RestTemplate restTemplate;
    private final String postUrl = "http://localhost:8090/posts/{id}";
    private final String ptsUrl = "http://localhost:8090/posts";

    @Override
    public PostDTO get(Long id) {
        return restTemplate.getForObject(postUrl, PostDTO.class, id);
    }

    @Override
    public Collection<Post> getAll() {
        ResponseEntity<Collection<Post>> response = restTemplate.exchange(ptsUrl,  HttpMethod.GET, null,
                                                                    new ParameterizedTypeReference<>() {});
        return response.getBody();

    }

    @Override
    public void add(PostSaveDTO p) {
        String postMsgUrl = ptsUrl + "/add";
        restTemplate.postForLocation(postMsgUrl, p);
    }

    @Override
    public void update(PostDTO p,Long id) {
        restTemplate.put(postUrl, p, id);
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(postUrl, id);
    }
}
