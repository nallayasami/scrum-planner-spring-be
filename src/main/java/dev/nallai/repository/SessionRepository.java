package dev.nallai.repository;

import dev.nallai.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID>
{
	Optional<Session> findByPassphrase(String passphrase);
}
