package com.dio.board_tasks.domain;

import java.util.List;

public abstract class BoardColumn {
    private Long id;
    private String name;
    private List<Card> cards;
    private Board board;
}

class InitialColumn extends BoardColumn {
    private final int order = 1;
}

class FinalColumn extends BoardColumn {
    private final int order = 2;
}

class CancellationColumn extends BoardColumn {
    private final int order = 3;
}

class PendingColumn extends BoardColumn{

}

