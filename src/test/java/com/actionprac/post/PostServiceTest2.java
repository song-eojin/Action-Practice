package com.actionprac.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional // 롤백시키기 위한 어노테이션
class PostServiceTest2 {

	@Autowired
	PostRepository postRepository;
	@Autowired
	PostService postService;

	// requestDto로 만든 Post의 값과 저장된 Post의 값이 일치하는지
	// 테스트 코드 작성
	@Test
	@DisplayName("createPost() 테스트")
	void createPost() {
		// given
		String content = "test_content";

		PostRequestDto requestDto = new PostRequestDto();
		requestDto.setContent(content);

		Post post = new Post(requestDto);

		// when
		PostResponseDto responseDto = postService.createPost(requestDto);

		// then
		assertEquals(responseDto.getContent(),content);
		assertNotNull(responseDto.getId());

	}
}