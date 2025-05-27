package dev.nallai.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "votes")
public class Vote
{
	@Id @GeneratedValue
	private UUID id;

	@ManyToOne
	private Session session;

	@ManyToOne
	private User user;

	private String voteValue;

}
