package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "board_columns")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "column_type")
public abstract class BoardColumn {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 5, max = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "boardColumn")
    private List<Card> cards;
}

@Entity
@DiscriminatorValue("INITIAL")
class InitialColumn extends BoardColumn {
    @OneToOne
    @JoinColumn(name = "board_id", unique = true)
    private Board board;
    private final int order = 1;
}

@Entity
@DiscriminatorValue("FINAL")
class FinalColumn extends BoardColumn {
    @OneToOne
    @JoinColumn(name = "board_id", unique = true)
    private Board board;
    private final int order = 2;
}

@Entity
@DiscriminatorValue("CANCELLATION")
class CancellationColumn extends BoardColumn {
    @OneToOne
    @JoinColumn(name = "board_id", unique = true)
    private Board board;
    private final int order = 3;
}

@Entity
@DiscriminatorValue("PENDING")
class PendingColumn extends BoardColumn{
    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
}

