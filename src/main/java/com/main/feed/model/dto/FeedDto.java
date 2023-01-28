package com.main.feed.model.dto;

import com.main.feed.model.entity.Feed;
import com.main.playlist.model.dto.PlaylistDto;
import com.main.playlist.model.dto.UserPlaylistDto;
import com.main.user.model.dto.UserDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FeedDto {
	
	private Long feedId; // AI
	private UserDto userDto; //
	private UserPlaylistDto userPlaylistDto; // 맏냐?
	private String missionName;
	private String content;
	private LocalDateTime createdDate;
	private List<CommentDto> comments;
	private List<FileDto> files;
	// 프론트에서 원소 갯수랑 내가 좋아요 눌렀는지 여부 검사해야 함
	private List<LikeDto> likes;
	
	public static FeedDto toDto(Feed feed) {
	
		List<CommentDto> comments = new ArrayList<>();
		feed.getComments().forEach(x -> comments.add(CommentDto.toDto(x)));
		
//		List<FileDto> files = new ArrayList<>();
//		feed.getFiles().forEach(x -> files.add(FileDto.toDto(x)));
		
		List<LikeDto> likes = new ArrayList<>();
		feed.getLikes().forEach(x -> likes.add(LikeDto.toDto(x)));
		
		return new FeedDto (
				feed.getFeedId(),
				UserDto.toDto(feed.getUser()),
				UserPlaylistDto.toDto((feed.getUserPlaylist())),
				feed.getMission().getMissionName(),
				feed.getContent(),
				feed.getCreatedDate(),
				comments,
//				files,
				null,
				likes
		);
		
	}
	
	public Feed toEntity() {
		return new Feed(null, null, null, null, content, createdDate, null, null, null, null);
	}
	
}
