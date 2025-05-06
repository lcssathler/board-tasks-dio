package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "board_columns")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "column_type")
public abstract class BoardColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(min = 5, max = 100)
    @Getter
    protected String name;

    protected int ordering;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "boardColumn", fetch = FetchType.EAGER)
    @Getter
    private List<Card> cards;

    public BoardColumn() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCard(Card card) {
        if (card != null) {
            this.cards.add(card);
        }
    }

}



