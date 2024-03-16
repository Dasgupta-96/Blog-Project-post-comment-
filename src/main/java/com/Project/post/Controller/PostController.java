package com.Project.post.Controller;

import com.Project.post.Payload.PostDto;
import com.Project.post.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService ser;

    public PostController(PostService ser) {
        this.ser = ser;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    // http://localhost:8080/api/posts
public ResponseEntity<PostDto> savePost(@Valid @RequestBody PostDto postDto){

        PostDto dto = ser.savePost(postDto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/particular")
    // http://localhost:8080/api/posts/particular?id=1

    public ResponseEntity<PostDto> getPost(@RequestParam("id") int id){

        PostDto dto = ser.getData(id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping
    // http://localhost:8080/api/posts
    public ResponseEntity<List<PostDto>> getAllPosts(){

        List<PostDto> dto = ser.getAllPosts();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    // http://localhost:8080/api/posts/5
    public ResponseEntity<?> deletePost(@PathVariable int id){

        ser.deleteData(id);

        return new ResponseEntity<>("The post is deleted!!",HttpStatus.OK);
    }

    @GetMapping("/pagination")
    // http://localhost:8080/api/posts/pagination?pageNo=0&pageSize=2&sortBy={title}
    public ResponseEntity< List<PostDto>> pagination(

  @RequestParam(name="pageNo",required = false,defaultValue = "0") int pageNo,
  @RequestParam(name="pageSize",required = false,defaultValue = "2") int pageSize,
  @RequestParam(name="sortBy",required = false,defaultValue = "id") String sortBy
    ){

        List<PostDto> dto = ser.pagination(pageNo, pageSize,sortBy);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PutMapping
    // http://localhost:8080/api/posts?id=2
    public ResponseEntity<PostDto> updatePost(@RequestParam("id") int id, @RequestBody PostDto postDto){

        PostDto dto = ser.updatePost(id, postDto);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
