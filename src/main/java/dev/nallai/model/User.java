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
@Table(name = "users") // ✅ explicitly set table name
public class User
{
	@Id
	@GeneratedValue
	private UUID id;

	@Column(unique = true)
	private String username;
}
