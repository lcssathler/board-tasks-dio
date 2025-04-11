package com.dio.board_tasks.domain;

import io.micrometer.common.lang.NonNullFields;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    private String name;

    @NotNull
    @NotEmpty
    private InitialColumn initialColumn;

    @NotNull
    @NotEmpty
    private FinalColumn finalColumn;


    @NotNull
    @NotEmpty
    private CancellationColumn cancellationColumn;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PendingColumn> pendingColumnList = new ArrayList<>();

}
