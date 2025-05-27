package dev.nallai.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sessions") // ✅ explicitly set table name
public class Session
{
	@Id
	@GeneratedValue
	private UUID id;

	@Column(unique = true)
	private String name;

	private String passphrase;

	private boolean active = true;

	private LocalDateTime createdAt = LocalDateTime.now();
}
