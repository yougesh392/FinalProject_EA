package com.blogginService.Blogging_Service.Controllers;

import com.blogginService.Blogging_Service.Model.Blogging;

import java.util.Collection;
import java.util.List;

public class Blogs {
    private List<Blogging> blogs;

    public Blogs(List<Blogging> blogs) {
        this.blogs = blogs;
    }

    public Collection<Blogging> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blogging> blogs) {
        this.blogs = blogs;
    }
}
