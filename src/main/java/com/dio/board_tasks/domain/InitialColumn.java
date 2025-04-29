package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("INITIAL")
public class InitialColumn extends BoardColumn {

    public InitialColumn() {
        super();
        super.ordering = 1;
    }
}