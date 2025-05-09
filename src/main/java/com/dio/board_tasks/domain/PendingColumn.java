package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;

@Entity
@DiscriminatorValue("PENDING")
public class PendingColumn extends BoardColumn {
    @ManyToOne
    private Board board;

    @Getter
    @Transient
    public int orderNumber = 2;

    public PendingColumn() {
        super();
        super.ordering = orderNumber;
    }

}
