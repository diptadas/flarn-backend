package edu.baylor.flarn.services;

import edu.baylor.flarn.models.ProblemSet;
import edu.baylor.flarn.models.User;
import edu.baylor.flarn.repositories.ProblemSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AddProblemSetService {
    private final ProblemSetRepository problemSetRepository;

    public AddProblemSetService(ProblemSetRepository problemSetRepository) {
        this.problemSetRepository = problemSetRepository;
    }

    public ProblemSet createProblemSet(ProblemSet problemSet, User user) {
        problemSet.setModerator(user);
        return problemSetRepository.save(problemSet);
    }

    public List<ProblemSet> getAllProblemSets() {
        return problemSetRepository.findAll();
    }

    public ProblemSet getProblemSetById(long id) {
        Optional<ProblemSet> problemSet = problemSetRepository.findById(id);
        return problemSet.orElse(null);
    }
}