package com.actionprac.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional // 롤백시키기 위한 어노테이션
class PostServiceTest {

	@Autowired
	PostRepository postRepository;

	// requestDto로 만든 Post의 값과 저장된 Post의 값이 일치하는지
	// 테스트 코드 작성

	@Test
	@DisplayName("createPost() 테스트")
	void createPost() {
		String content = "test_content";

		PostRequestDto requestDto = new PostRequestDto();
		requestDto.setContent(content);

		Post post = new Post(requestDto);

		// when
		postRepository.save(post);
		PostResponseDto responseDto = new PostResponseDto(post);

		// then
		assertNotNull(responseDto.getId());
		System.out.println("notnull 통과");

		assertEquals(content, responseDto.getContent());
		System.out.println("assertEquals 통과");
	}
}