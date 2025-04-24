package com.dio.board_tasks.domain;

import io.micrometer.common.lang.NonNullFields;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    private String name;

    @Setter
    @NotNull
    @NotEmpty
    @OneToOne(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private InitialColumn initialColumn;

    @Setter
    @NotNull
    @NotEmpty
    @OneToOne(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private FinalColumn finalColumn;


    @Setter
    @NotNull
    @NotEmpty
    @OneToOne(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private CancellationColumn cancellationColumn;

    @Setter
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PendingColumn> pendingColumnList;
}
