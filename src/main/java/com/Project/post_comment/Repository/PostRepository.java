package com.Project.post_comment.Repository;

import com.Project.post_comment.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByEmail(String email);
    Post findPostById(int id);
}
