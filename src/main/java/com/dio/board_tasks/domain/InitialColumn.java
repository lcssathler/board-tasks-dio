package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("INITIAL")
public class InitialColumn extends BoardColumn {
    @OneToOne
    @JoinColumn(name = "board_id", unique = true)
    private Board board;
    private final int ordering = 1;

    public InitialColumn(Board board) {
        this.board = board;
    }
}