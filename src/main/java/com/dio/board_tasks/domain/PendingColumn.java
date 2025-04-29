package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("PENDING")
public class PendingColumn extends BoardColumn {
    @ManyToOne
    private Board board;

    @Getter
    @Setter
    public int orderNumber= 4;

    public PendingColumn() {
        super();
        super.ordering = orderNumber;
    }

}
