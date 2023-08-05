package com.actionprac.post;

public class PostResponseDto {
	private Long id;
	private String content;

	public PostResponseDto(Post post) {
		this.id = post.getId();
		this.content = post.getContent();
	}
}
