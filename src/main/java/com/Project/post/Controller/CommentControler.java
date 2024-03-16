package com.Project.post.Controller;

import com.Project.post.Payload.CommentDto;
import com.Project.post.Service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentControler {

    private CommentService ser;

    public CommentControler(CommentService ser) {
        this.ser = ser;
    }

    @PostMapping("/{postId}")
    // http://localhost:8080/api/comments/1
    public ResponseEntity<CommentDto> saveComments(@RequestBody CommentDto commentDto,@PathVariable int postId){

        CommentDto dto = ser.saveComment(commentDto, postId);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PutMapping("/{postId}/post/{id}")
    //http://localhost:8080/api/comments/2/post/2
    public ResponseEntity<CommentDto> updateComment(@PathVariable int postId, @RequestBody CommentDto commentDto, @PathVariable int id){

        CommentDto dto = ser.updateCommnt(postId, commentDto, id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
