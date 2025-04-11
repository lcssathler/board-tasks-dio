package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    private String title;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 500)
    private String description;

    private LocalDateTime dateCreation;

    @ManyToOne
    @JoinColumn(name = "boardColumn_id", nullable = false)
    private BoardColumn boardColumn;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Block> blocksInfo;
}
