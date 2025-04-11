package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public abstract class BoardColumn {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 5, max = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "boardColumn")
    private List<Card> cards;

    @NotNull
    @Valid
    private Board board;
}

class InitialColumn extends BoardColumn {
    private final int order = 1;
}

class FinalColumn extends BoardColumn {
    private final int order = 2;
}

class CancellationColumn extends BoardColumn {
    private final int order = 3;
}

class PendingColumn extends BoardColumn{

}

