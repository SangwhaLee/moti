package com.main.feed.model.entity;

import com.main.user.model.entity.User;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity(name = "likes")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Like {

	@Id
	@GeneratedValue
	private Long likeId;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "feedId")
	private Feed feed;

}
