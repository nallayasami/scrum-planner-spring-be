package dev.nallai.controller;

import dev.nallai.model.Session;
import dev.nallai.model.User;
import dev.nallai.model.Vote;
import dev.nallai.repository.SessionRepository;
import dev.nallai.repository.UserRepository;
import dev.nallai.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class VoteController
{
	private final SessionRepository sessionRepo;

	private final UserRepository userRepo;

	private final VoteRepository voteRepo;

	@PostMapping("/{passphrase}/vote")
	public Vote submitVote(@PathVariable String passphrase, @RequestBody Map<String, String> body)
	{
		String username = body.get("userId");
		String value = body.get("voteValue");

		Session session = sessionRepo.findByPassphrase(passphrase)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		User user = userRepo.findByUsername(username)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		Vote vote = new Vote();
		vote.setSession(session);
		vote.setUser(user);
		vote.setVoteValue(value);
		return voteRepo.save(vote);
	}

	@GetMapping("/{passphrase}/votes")
	public List<Vote> getVotes(@PathVariable String passphrase)
	{
		return voteRepo.findBySession_Passphrase(passphrase);
	}
}
