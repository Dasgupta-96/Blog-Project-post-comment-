package com.Project.post_comment.Controller;

import com.Project.post_comment.Payload.CommentDto;
import com.Project.post_comment.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService ser;

    @PostMapping
    // http://localhost:8081/api/comments?id=1
    public ResponseEntity<?> saveComments(@RequestParam("id") int id, @RequestBody CommentDto dto){

        CommentDto dto1 = ser.saveComments(id, dto);

        return new ResponseEntity<>(dto1, HttpStatus.CREATED);
    }
    @GetMapping
    // http://localhost:8081/api/comments
    public ResponseEntity<?> getPosts(){

        List<CommentDto> dto = ser.getAllComments();

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @PutMapping("/{postId}/comments/{commentId}")
    // http://localhost:8081/api/comments/postId/comments/commentId
    public ResponseEntity<CommentDto> updateComments(@PathVariable int postId, @PathVariable int commentId, @RequestBody CommentDto commentDto){

        CommentDto dto = ser.updateComment(postId, commentId, commentDto);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

}
