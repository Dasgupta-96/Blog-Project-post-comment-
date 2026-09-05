package com.Project.post_comment.Controller;

import com.Project.post_comment.Payload.PostDto;
import com.Project.post_comment.Service.EmailService;
import com.Project.post_comment.Service.Post_Service;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class Post_Controller {

    private Post_Service ser;

    public Post_Controller(Post_Service ser) {
        this.ser = ser;
    }
    @Autowired
    private EmailService emailService;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    // http://localhost:8081/api/posts
    public ResponseEntity<PostDto> savePost(@Valid @RequestBody PostDto postDto){

        PostDto dto = ser.savePosts(postDto);
//emailService.sendEmail(postDto.getEmail());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Cacheable(cacheNames = "posts", key = "#id")
    @GetMapping("/particular")
    // http://localhost:8080/api/posts/particular?id=5
    public ResponseEntity<PostDto>getPostById(@RequestParam("id") int id) {

        PostDto data = ser.getPostById(id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping
    // http://localhost:8080/api/posts
    public ResponseEntity< List<PostDto>> getALlPosts(){
        List<PostDto> data = ser.findALlPosts();
return new ResponseEntity<>(data,HttpStatus.OK);

    }
    @GetMapping("/pagination")
  // http://localhost:8081/api/posts/pagination?pageNo=0&pageSize=2&sortBy={title}
    public ResponseEntity<?> pagination(

@RequestParam(name ="pageNo",required = false,defaultValue = "0") int pageNo,
@RequestParam(name ="pageSize",required = false,defaultValue = "2") int pageSize,
@RequestParam(name ="sortBy",required = false,defaultValue = "id") String sortBy
    ){

        List<PostDto> data = ser.pagination(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    // http://localhost:8081/api/posts/5
public ResponseEntity<?> deletePosts(@PathVariable int id){

        ser.deleteData(id);

        return new ResponseEntity<>("Post is deleted in this id "+id, HttpStatus.OK);
}
@PutMapping
// http://localhost:8081/api/posts?id=4
public ResponseEntity<PostDto> updatePost(@RequestParam("id") int id, @RequestBody PostDto postDto){

    PostDto dto = ser.updatePost(id, postDto);
return new ResponseEntity<>(dto,HttpStatus.OK);
}
@PatchMapping("/partialUpdate/{id}")
// http://localhost:8081/api/posts/partialUpdate/1
public ResponseEntity<PostDto> updatePartially(@PathVariable int id, @RequestBody Map<String, Object> updates){
    return ResponseEntity.ok(ser.updatePartially(id, updates));
}
}
