package com.dio.board_tasks.domain;

import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Table(name = "blocks")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String causeBlock;

    @Setter
    private LocalDateTime blockAt;

    @Length(min = 3)
    @Setter
    private String causeUnblock;

    @Setter
    private LocalDateTime unblockAt;

    @ManyToOne
    @JoinColumn(name = "card_id")
    @Setter
    private Card card;
}
