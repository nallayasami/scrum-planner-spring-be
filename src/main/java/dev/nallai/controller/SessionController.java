package dev.nallai.controller;

import dev.nallai.model.Session;
import dev.nallai.model.User;
import dev.nallai.repository.SessionRepository;
import dev.nallai.repository.UserRepository;
import dev.nallai.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class SessionController {
	private final SessionRepository sessionRepo;
	private final UserRepository userRepo;
	private final VoteRepository voteRepo;

	@GetMapping
	public List<Session> getSessions() {
		return sessionRepo.findAll();
	}

	@PostMapping
	public Session createSession(@RequestBody Map<String, String> body) {
		var session = new Session();
		session.setPassphrase(body.get("passphrase"));
		session.setName(body.get("name"));
		return sessionRepo.save(session);
	}

	@PostMapping("/join")
	public Session joinSession(@RequestBody Map<String, String> body) {
		String passphrase = body.get("passphrase");
		String username = body.get("username");

		Session session = sessionRepo.findByPassphrase(passphrase)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found"));

		userRepo.findByUsername(username).orElseGet(() -> {
			var user = new User();
			user.setUsername(username);
			return userRepo.save(user);
		});

		return session;
	}
}
