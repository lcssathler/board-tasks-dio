package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "board_columns")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "column_type")
public abstract class BoardColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 5, max = 100)
    protected String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "boardColumn")
    private List<Card> cards;

    public void setName(String name) {
        this.name = name;
    }
}



