package edu.baylor.flarn.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String content;

    @ElementCollection
    private List<String> options = new ArrayList<>();

    private int answer;

    @ManyToOne
    private ProblemSet problemSet;
}