package com.Project.post_comment.Service;

import com.Project.post_comment.Controller.Post_Controller;
import com.Project.post_comment.Entity.Post;
import com.Project.post_comment.Exception.EmptyResultDataAccessException;
import com.Project.post_comment.Exception.ResourceNotFoundException;
import com.Project.post_comment.Payload.PostDto;
import com.Project.post_comment.Repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Post_Service {

    private PostRepository postRepository;

    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(Post_Service.class);

    public Post_Service(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper=modelMapper;
    }

    public PostDto savePosts(PostDto postDto){

        logger.trace("Attempting to fetch client data based on emailId {}", postDto.getEmail());
List<Post> clientExists = postRepository.findByEmail(postDto.getEmail());
        if(!clientExists.isEmpty()){
            logger.error("Client is there with this email id {} ",postDto.getEmail());
    throw new ResourceNotFoundException("Client already exists with this email id "+postDto.getEmail()) ;
}

        Post post = mapToentity(postDto);
//        Post post = new Post();
//        post.setId(postDto.getId());
//        post.setName(postDto.getName());
//        post.setCity(postDto.getCity());
//        post.setEmail(postDto.getEmail());
//        post.setMobile(postDto.getMobile());

        Post save = postRepository.save(post);

        PostDto dto = mapTodto(save);
//        PostDto dto = new PostDto();
//        dto.setId(save.getId());
//        dto.setName(save.getName());
//        dto.setCity(save.getCity());
//        dto.setEmail(save.getEmail());
//        dto.setMobile(save.getMobile());
logger.info("Succesfully fetched the cleint data from database {}",postDto.getEmail());
        return dto;
    }

    public PostDto getPostById(int id){
        logger.trace("Attempting to fetch client data based on id {} ",id);

        Post post = postRepository.findById(id)
                .orElseThrow(()->{
                    logger.error("Unable to fetch the datails of client based on id {}", id);
           return new ResourceNotFoundException("post is not present in this id " +id);
        });
        PostDto dto = mapTodto(post);
        logger.info("Succesfully fetched the cleint data from database {}");
        return dto;
    }

    Post mapToentity(PostDto postDto){

        Post post = modelMapper.map(postDto, Post.class);
//        Post post = new Post();
//        post.setId(postDto.getId());
//        post.setName(postDto.getName());
//        post.setCity(postDto.getCity());
//        post.setEmail(postDto.getEmail());
//        post.setMobile(postDto.getMobile());

        return post;
    }
   PostDto mapTodto(Post post){

       PostDto dto = modelMapper.map(post, PostDto.class);
//       PostDto dto = new PostDto();
//       dto.setId(post.getId());
//       dto.setName(post.getName());
//       dto.setCity(post.getCity());
//       dto.setEmail(post.getEmail());
//       dto.setMobile(post.getMobile());

       return dto;
    }

    public List<PostDto> findALlPosts() {
//        logger.trace("Attempting to retrieve all the posts : {}");
        List<Post> data = postRepository.findAll();

        List<PostDto> result = data.stream().map(e -> mapTodto(e)).collect(Collectors.toList());
//        List<PostDto> collect = data.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
//        logger.info("Seccessfully fetched all the posts : {}");
        return result;
    }

    public void deleteData(int id) {

        Optional<Post> data = postRepository.findById(id);

        if(data.isPresent()){

            postRepository.deleteById(id);
        }
     else{
//            logger.error("Error while fetching the post by id : {}" +id);
         throw new EmptyResultDataAccessException("Post is already deleted in this id "+id);
        }
    }

    public List<PostDto> pagination(int pageNo, int pageSize, String sortBy){

        PageRequest pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Post> pages = postRepository.findAll(pageable);
        List<Post> data = pages.getContent();
        List<PostDto> result = data.stream().map(e -> mapTodto(e)).collect(Collectors.toList());

        return result;
    }

    public PostDto updatePost(int id, PostDto postDto){

        Post post = postRepository.findById(id).get();
       post.setId(postDto.getId());
       post.setName(postDto.getName());
       post.setCity(postDto.getCity());
       post.setEmail(postDto.getEmail());
       post.setMobile(postDto.getMobile());

        Post save = postRepository.save(post);
        PostDto dto = mapTodto(save);
        return dto;
    }
public Post ifExistsPost(int id){
      return postRepository.findPostById(id);
}

  public PostDto updatePartially(int id, Map<String, Object> updates) {
    Post post = ifExistsPost(id);
    if(post != null){
      updates.forEach((field,value)->{
        Field fieldTOBeUpdated = ReflectionUtils.findField(Post.class, field);
        assert fieldTOBeUpdated != null;
        fieldTOBeUpdated.setAccessible(true);
        ReflectionUtils.setField(fieldTOBeUpdated,post,value);
      });
      return  modelMapper.map(postRepository.save(post), PostDto.class);
    }else {
      throw new RuntimeException("Post not present in this id");
    }


  }
}
