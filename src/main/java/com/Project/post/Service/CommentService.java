package com.Project.post.Service;

import com.Project.post.Entity.Comment;
import com.Project.post.Entity.Post;
import com.Project.post.Exception.ResourceNotFoundException;
import com.Project.post.Payload.CommentDto;
import com.Project.post.Repository.CommentRepository;
import com.Project.post.Repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository=postRepository;
    }

    public CommentDto saveComment( CommentDto commentDto, int postId){

        Post post = postRepository.findById(postId).orElseThrow(

                () -> new ResourceNotFoundException("Post is not present in this id " + postId)
        );
        Comment comment = mapToentity(commentDto);
//        Comment comment = new Comment();
//        comment.setId(commentDto.getId());
//        comment.setEmail(commentDto.getEmail());
//        comment.setBody(commentDto.getBody());
        comment.setPosts(post);

        Comment save = commentRepository.save(comment);
        CommentDto dto = mapTodto(save);
//        CommentDto dto = new CommentDto();
//       dto.setId(save.getId());
//       dto.setEmail(save.getEmail());
//       dto.setBody(save.getBody());

       return dto;
    }
  Comment mapToentity(CommentDto commentDto){

      Comment comment = new Comment();
      comment.setId(commentDto.getId());
      comment.setEmail(commentDto.getEmail());
      comment.setBody(commentDto.getBody());

      return comment;
    }

    CommentDto mapTodto(Comment comment){

        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());

        return dto;
    }

    public CommentDto updateCommnt(int postId, CommentDto commentDto, int id) {

        Post post = postRepository.findById(postId).orElseThrow(

                () -> new ResourceNotFoundException("post is  not present in this id " + postId)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(

                () -> new ResourceNotFoundException("Comment is not present in this id " + id)
        );
        Comment c1 = mapToentity(commentDto);
        c1.setId(comment.getId());
        c1.setPosts(post);

        Comment save = commentRepository.save(c1);
        CommentDto dto = mapTodto(save);

        return dto;
    }
}
