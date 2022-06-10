package com.blogginService.Blogging_Service.DAO;

import com.blogginService.Blogging_Service.Model.Blogging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogDAO extends JpaRepository<Blogging,Long> {

    @Query("SELECT b FROM Blogging b WHERE b.blogTitle = ?1" )
    Blogging findByTitle(String title);

}
