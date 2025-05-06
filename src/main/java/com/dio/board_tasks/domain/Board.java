package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    private String name;

    @Getter
    @Setter
    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "initialColumn_id", unique = true)
    private InitialColumn initialColumn;

    @Getter
    @Setter
    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "finalColumn_id", unique = true)
    private FinalColumn finalColumn;


    @Getter
    @Setter
    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cancellationColumn_id", unique = true)
    private CancellationColumn cancellationColumn;

    @Getter
    @Setter
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PendingColumn> pendingColumnList;
}
