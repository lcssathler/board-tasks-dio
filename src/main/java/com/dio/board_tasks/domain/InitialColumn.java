package com.dio.board_tasks.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INITIAL")
public class InitialColumn extends BoardColumn {

    public InitialColumn() {
        super();
        super.ordering = 1;
    }
}