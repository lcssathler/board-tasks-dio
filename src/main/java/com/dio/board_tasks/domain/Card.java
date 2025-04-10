package com.dio.board_tasks.domain;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public class Card {
    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    private LocalDateTime dateCreation;

    private Block blockInfo;
}
