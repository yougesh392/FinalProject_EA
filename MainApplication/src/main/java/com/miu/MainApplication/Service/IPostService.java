package com.miu.MainApplication.Service;

import com.miu.MainApplication.DTO.PostDTO;
import com.miu.MainApplication.DTO.PostSaveDTO;
import com.miu.MainApplication.model.Post;

import java.util.Collection;

public interface IPostService {


    PostDTO get(Long id);

    Collection<Post> getAll();

    void add(PostSaveDTO p);

    void update(PostSaveDTO p, Long id);

    void delete(Long id);

}
