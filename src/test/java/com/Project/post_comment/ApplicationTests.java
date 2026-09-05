package com.Project.post_comment;

import com.Project.post_comment.Payload.PostDto;
import com.Project.post_comment.Service.Post_Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PrivateKey;
import java.util.List;

@SpringBootTest
class ApplicationTests {

@Autowired
	public Post_Service ser;
	@Test
	void fetchPostById() {
		PostDto dto = ser.getPostById(30);
		System.out.println(dto);
	}
	@Test
	void findAllPosts(){

		List<PostDto> dto = ser.findALlPosts();
		System.out.println(dto);
	}

}
