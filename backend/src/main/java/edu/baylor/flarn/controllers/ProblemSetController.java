package edu.baylor.flarn.controllers;

import edu.baylor.flarn.models.ProblemSet;
import edu.baylor.flarn.resources.ProblemSetSearchRequest;
import edu.baylor.flarn.models.User;
import edu.baylor.flarn.services.AddProblemSetService;
import edu.baylor.flarn.services.RandomProblemSetService;
import edu.baylor.flarn.services.SearchProblemSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problemsets")
public class ProblemSetController {

    private final AddProblemSetService addProblemSetService;
    private final SearchProblemSetService searchProblemSetService;
    private final RandomProblemSetService randomProblemSetService;

    @Autowired
    public ProblemSetController(AddProblemSetService addProblemSetService,
                                SearchProblemSetService searchProblemSetService,
                                RandomProblemSetService randomProblemSetService) {
        this.addProblemSetService = addProblemSetService;
        this.searchProblemSetService = searchProblemSetService;
        this.randomProblemSetService = randomProblemSetService;
    }

    @GetMapping
    public List<ProblemSet> getProblemSets() {
        return addProblemSetService.getAllProblemSets();
    }

    @GetMapping("{id}")
    public ProblemSet getProblemSetById(@PathVariable long id) {
        return addProblemSetService.getProblemSetById(id);
    }

    @PostMapping
    public ProblemSet createProblemSet(@RequestBody ProblemSet problemSet, @AuthenticationPrincipal User user) {
        // TODO: check moderator
        return addProblemSetService.createProblemSet(problemSet, user);
    }

    @PostMapping("/search")
    public List<ProblemSet> searchProblemSets(@RequestBody ProblemSetSearchRequest problemSetSearchRequest) {
        return searchProblemSetService.searchProblemSet(problemSetSearchRequest);
    }

    @GetMapping("/random")
    public ProblemSet getRandomProblemSet() {
        return randomProblemSetService.getRandomProblemSet();
    }
}