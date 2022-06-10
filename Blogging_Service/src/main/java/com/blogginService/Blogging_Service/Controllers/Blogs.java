package com.blogginService.Blogging_Service.Controllers;

import com.blogginService.Blogging_Service.Model.Blogging;

import java.util.Collection;

public class Blogs {
    private Collection<Blogging> blogs;

    public Blogs(Collection<Blogging> blogs) {
        this.blogs = blogs;
    }

    public Collection<Blogging> getBlogs() {
        return blogs;
    }

    public void setBlogs(Collection<Blogging> blogs) {
        this.blogs = blogs;
    }
}
