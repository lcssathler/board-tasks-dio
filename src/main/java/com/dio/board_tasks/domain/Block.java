package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Table(name = "blocks")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 3)
    private String causeBlock;

    @NotNull
    private LocalDateTime blockAt;

    @NotNull
    @Length(min = 3)
    private String causeUnblock;

    @NotNull
    private LocalDateTime unblockAt;


    private boolean isBlocked = false;
}
