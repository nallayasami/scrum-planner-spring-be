package dev.nallai.repository;

import dev.nallai.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, UUID>
{
	List<Vote> findBySession_Passphrase(String passphrase);
}
