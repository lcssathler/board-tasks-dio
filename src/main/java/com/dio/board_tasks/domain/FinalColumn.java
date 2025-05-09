package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("FINAL")
public class FinalColumn extends BoardColumn {

    public FinalColumn() {
        super();
        super.ordering = 3;
    }
}
