package com.dio.board_tasks.domain;

import io.micrometer.common.lang.NonNullFields;

import java.util.List;


public class Board {
    private Long id;
    private String name;
    private InitialColumn initialColumn;
    private FinalColumn finalColumn;
    private CancellationColumn cancellationColumn;
    private List<PendingColumn> pendingColumnList;

}
