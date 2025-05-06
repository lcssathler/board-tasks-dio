package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    @Setter
    @Getter
    private String title;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 500)
    @Getter
    @Setter
    private String description;

    private LocalDateTime dateCreation;

    @ManyToOne
    @JoinColumn(name = "board_column_id")
    @Getter
    @Setter
    private BoardColumn boardColumn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private List<Block> blocksInfo;

    @PrePersist
    public void prePersist() {
        this.dateCreation = LocalDateTime.now();
    }
}
