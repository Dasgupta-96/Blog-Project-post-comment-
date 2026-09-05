package com.Project.post_comment.Service;

import com.Project.post_comment.Entity.Comment;
import com.Project.post_comment.Entity.Post;
import com.Project.post_comment.Exception.ResourceNotFoundException;
import com.Project.post_comment.Payload.CommentDto;
import com.Project.post_comment.Repository.CommentRepository;
import com.Project.post_comment.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private PostRepository postRepository;

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public CommentDto saveComments(int id, CommentDto commentDto){

        Post post = postRepository.findById(id).orElseThrow(

                () -> new ResourceNotFoundException("Post is not present in this id " + id)
        );
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setPosts(post);

        Comment save = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(save.getId());
        dto.setBody(save.getBody());
        dto.setEmail(save.getEmail());
        return dto;
    }

    public List<CommentDto> getAllComments() {

        List<Comment> data = commentRepository.findAll();
        List<CommentDto> result = data.stream().map(e -> mapTodto(e)).collect(Collectors.toList());
        return result;
    }
   CommentDto mapTodto(Comment comment){

        CommentDto dto= new CommentDto();
        dto.setId(comment.getId());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());

        return dto;

    }
    Comment mapToentity(CommentDto commentDto){

        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        return comment;

    }
public CommentDto updateComment(int postId,int commentId, CommentDto dto){

    Post post = postRepository.findById(postId).orElseThrow(

            () -> new ResourceNotFoundException("post is not present in this id " + postId)
    );
    Comment c = commentRepository.findById(commentId).orElseThrow(

            () -> new ResourceNotFoundException("Comment is not present in this id " + commentId)
    );

    Comment comment = mapToentity(dto);
   comment.setId(c.getId());
   comment.setPosts(post);

    Comment data = commentRepository.save(comment);

    CommentDto dto1 = mapTodto(data);
    return dto1;
}
}
