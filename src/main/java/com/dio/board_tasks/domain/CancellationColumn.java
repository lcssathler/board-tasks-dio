package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("CANCELLATION")
public class CancellationColumn extends BoardColumn {
    @OneToOne
    @JoinColumn(name = "board_id", unique = true)
    private Board board;
    private final int ordering = 3;

    public CancellationColumn(Board board) {
        this.board = board;
    }
}