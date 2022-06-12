package com.miu.MainApplication.Service;

import com.miu.MainApplication.DTO.CommentDTO;
import com.miu.MainApplication.DTO.CommentSaveDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    private final RestTemplate restTemplate;

    private final String commentURL = "http://localhost:8088/comments";

    public CommentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void save(CommentSaveDTO commentSaveDTO) {
        restTemplate.postForLocation(commentURL,commentSaveDTO);
    }

    @Override
    public List<CommentDTO> findAll() {
        ResponseEntity<List<CommentDTO>> entity = restTemplate.exchange(commentURL, HttpMethod.GET, null, new ParameterizedTypeReference<>(){});
        return entity.getBody();
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(commentURL + "/" + id);
    }

    @Override
    public void update(Long id, CommentDTO commentDTO) {
        restTemplate.put(commentURL+ "/" + id, commentDTO);
    }

    @Override
    public CommentDTO getById(Long id) {
        return restTemplate.getForObject(commentURL+ "/" + id, CommentDTO.class);
    }

    @Override
    public List<CommentDTO> findAllByPostId(Long postId) {
        ResponseEntity<List<CommentDTO>> entity = restTemplate.exchange(commentURL + "/get-by-post-id/" + postId, HttpMethod.GET, null, new ParameterizedTypeReference<>(){});
        return entity.getBody();
    }
}
