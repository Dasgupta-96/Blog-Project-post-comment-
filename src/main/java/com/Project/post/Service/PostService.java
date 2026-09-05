package com.Project.post.Service;

import com.Project.post.Entity.Post;
import com.Project.post.Exception.EmptyResultDataAccessException;
import com.Project.post.Exception.ResourceNotFoundException;
import com.Project.post.Payload.PostDto;
import com.Project.post.Repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostService(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper=modelMapper;
    }

    public PostDto savePost(PostDto postDto){

        Post post = mapToentity(postDto);
//        Post post = new Post();
//        post.setId(postDto.getId());
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        post.setDescription(postDto.getDescription());

        Post save = postRepository.save(post);

        PostDto dto = mapTodto(save);
//        PostDto dto = new PostDto();
//        dto.setId(save.getId());
//        dto.setTitle(save.getTitle());
//        dto.setContent(save.getContent());
//        dto.setDescription(save.getDescription());

        return dto;
    }
public PostDto getData(int id){

    Post post = postRepository.findById(id).orElseThrow(

            () -> new ResourceNotFoundException("The post is not present in this id " + id)
    );
    PostDto dto = mapTodto(post);
//    PostDto dto = new PostDto();
//    dto.setId(post.getId());
//    dto.setTitle(post.getTitle());
//    dto.setContent(post.getContent());
//    dto.setDescription(post.getDescription());

    return dto;

}

public  List<PostDto>  getAllPosts(){

    List<Post> data = postRepository.findAll();

    List<PostDto> dto = data.stream().map(d -> mapTodto(d)).collect(Collectors.toList());

    return dto;
}

public void deleteData(int id){

    Optional<Post> post = postRepository.findById(id);
    if(post.isPresent()){

        postRepository.deleteById(id);
    }
    else{

        throw new EmptyResultDataAccessException("Post is already deleted in this id "+id);
    }
}

public List<PostDto> pagination(int pageNo, int pageSize, String sortBy){

    PageRequest pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
    Page<Post> pages = postRepository.findAll(pageable);
    List<Post> data = pages.getContent();
    List<PostDto> dto = data.stream().map(d -> mapTodto(d)).collect(Collectors.toList());

    return dto;
}

public PostDto updatePost(int id, PostDto postDto){

    Post p1 = postRepository.findById(id).get();
    p1.setId(postDto.getId());
    p1.setTitle(postDto.getTitle());
    p1.setContent(postDto.getContent());
    p1.setDescription(postDto.getDescription());

    Post updtPost = postRepository.save(p1);
    PostDto dto = mapTodto(updtPost);

    return dto;
}
Post mapToentity(PostDto postDto){

    Post post = modelMapper.map(postDto, Post.class);
//    Post post = new Post();
//    post.setId(postDto.getId());
//    post.setTitle(postDto.getTitle());
//    post.setContent(postDto.getContent());
//    post.setDescription(postDto.getDescription());

    return post;
}

PostDto mapTodto(Post post){

    PostDto dto = modelMapper.map(post, PostDto.class);
//    PostDto dto = new PostDto();
//    dto.setId(post.getId());
//    dto.setTitle(post.getTitle());
//    dto.setContent(post.getContent());
//    dto.setDescription(post.getDescription());

    return dto;
}
}
