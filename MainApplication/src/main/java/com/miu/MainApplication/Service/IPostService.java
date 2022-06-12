package com.miu.MainApplication.Service;

import com.miu.MainApplication.DTO.PostDTO;
import com.miu.MainApplication.model.Post;

import java.util.List;

public interface IPostService {


    public PostDTO get(Long id);

    public List<Post> getAll();

    public void add(PostDTO p);

    public void update(PostDTO p, Long id);

    public void delete(Long id);

}
