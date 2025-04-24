package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("PENDING")
public class PendingColumn extends BoardColumn {
    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Getter
    @Setter
    public int ordering = 4;

    public PendingColumn(Board board) {
        this.board = board;
    }
}
