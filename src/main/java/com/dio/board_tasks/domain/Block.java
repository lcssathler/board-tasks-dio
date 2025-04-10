package com.dio.board_tasks.domain;

import java.time.LocalDateTime;

public class Block {
    private Long id;
    private String causeBlock;
    private LocalDateTime blockAt;
    private String causeUnblock;
    private LocalDateTime unblockAt;
    private boolean isBlocked;
}
