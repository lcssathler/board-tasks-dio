package com.dio.board_tasks.services;

import com.dio.board_tasks.domain.*;
import com.dio.board_tasks.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    private Scanner scanner = new Scanner(System.in);

    public void createBoard() {
        Board board = new Board();
        System.out.println("Creating a new board...");
        System.out.print("Type board name: ");
        String boardName = scanner.nextLine();
        board.setName(boardName);

        System.out.print("Type the initial board column name:");
        String initialColumnName = scanner.nextLine();
        InitialColumn initialColumn = (InitialColumn) createColumn(initialColumnName, new InitialColumn(board));
        board.setInitialColumn(initialColumn);

        System.out.print("Type the final board column name:");
        String finalColumnName = scanner.next();
        FinalColumn finalColumn = (FinalColumn) createColumn(finalColumnName, new FinalColumn(board));
        board.setFinalColumn(finalColumn);


        System.out.print("Type the cancelled board column name:");
        String cancellationColumnName = scanner.next();
        CancellationColumn cancellationColumn = (CancellationColumn) createColumn(cancellationColumnName, new CancellationColumn(board));
        board.setCancellationColumn(cancellationColumn);

        System.out.print("How many additional columns do you want do create? If you don't, type 0: ");
        int additionalColumns = scanner.nextInt();
        List<PendingColumn> pendingColumnList = new ArrayList<>();
        if (additionalColumns > 0) {
            for (int i = 0; i < additionalColumns; i++) {
                System.out.print("Type the pending board column name:");
                String pendingColumnName = scanner.next();
                PendingColumn pendingColumn = (PendingColumn) createColumn(pendingColumnName, new PendingColumn(board));
                pendingColumn.setOrdering(pendingColumn.getOrdering() + i);
                pendingColumnList.add(pendingColumn);
            }
        }
        board.setPendingColumnList(pendingColumnList);
    }


    public BoardColumn createColumn(String columnName, BoardColumn column) {
        column.setName(columnName);
        return column;
    }
}
