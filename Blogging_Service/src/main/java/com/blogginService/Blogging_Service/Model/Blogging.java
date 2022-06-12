package com.blogginService.Blogging_Service.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Blogging {
    @Id
    @GeneratedValue
    private Long id;
    private String blogTitle;
    private String blogData;

    public Blogging(String blogTitle, String blogData) {
        this.blogTitle = blogTitle;
        this.blogData = blogData;
    }
}
