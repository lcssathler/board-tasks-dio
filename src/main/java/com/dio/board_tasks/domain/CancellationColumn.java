package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("CANCELLATION")
public class CancellationColumn extends BoardColumn {

    public CancellationColumn() {
        super();
        super.ordering = 3;
    }
}