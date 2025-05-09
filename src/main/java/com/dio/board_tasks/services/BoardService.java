package com.dio.board_tasks.services;

import com.dio.board_tasks.domain.*;
import com.dio.board_tasks.menus.BoardMenu;
import com.dio.board_tasks.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardMenu boardMenu;

    private final Scanner scanner = new Scanner(System.in);

    public void createBoard() {
        Board board = new Board();
        System.out.println("Creating a new board...");
        System.out.print("Type board name:");
        String boardName = scanner.nextLine();
        board.setName(boardName);

        System.out.print("Type the initial board column name:");
        String initialColumnName = scanner.nextLine();
        InitialColumn initialColumn = (InitialColumn) createColumn(initialColumnName, board, new InitialColumn());
        board.setInitialColumn(initialColumn);

        System.out.print("Type the final board column name:");
        String finalColumnName = scanner.nextLine();
        FinalColumn finalColumn = (FinalColumn) createColumn(finalColumnName, board, new FinalColumn());
        board.setFinalColumn(finalColumn);


        System.out.print("Type the cancelled board column name:");
        String cancellationColumnName = scanner.nextLine();
        CancellationColumn cancellationColumn = (CancellationColumn) createColumn(cancellationColumnName, board, new CancellationColumn());
        board.setCancellationColumn(cancellationColumn);

        System.out.print("How many additional columns do you want to create? If you don't, type 0:");
        int additionalColumns = scanner.nextInt();
        List<PendingColumn> pendingColumnList = new ArrayList<>();
        if (additionalColumns > 0) {
            for (int i = 1; i <= additionalColumns; i++) {
                System.out.print("Type the pending board column name:");
                String pendingColumnName = scanner.next();
                PendingColumn pendingColumn = (PendingColumn) createColumn(pendingColumnName, board, new PendingColumn());
                pendingColumnList.add(pendingColumn);
            }
        }
        board.setPendingColumnList(pendingColumnList);
        boardRepository.save(board);
    }

    public void deleteBoard() {
        System.out.println("Deleting board...");
        System.out.print("Which board do you want to delete?: \n");
        List<Board> boardList = showBoards();
        if (boardList == null) return;

        System.out.print("Your option [only numbers]: ");
        int option = scanner.nextInt();
        Board boardToDelete = boardList.get(option - 1);
        boardRepository.delete(boardToDelete);
        System.out.printf("'%s' was deleted successfully \n", boardToDelete.getName());
    }

    public void selectBoard() {
        System.out.println("\n Selecting card...");
        System.out.print("Which board do you want to select?: \n");
        List<Board> boardList = showBoards();
        System.out.print("Your option [only numbers]: ");
        int option = scanner.nextInt();
        Board boardSelected = boardList.get(option - 1);
        Board boardFromRepository = boardRepository.findById(boardSelected.getId()).orElseThrow(() -> new RuntimeException("Board not found"));
        boardMenu.menu(boardFromRepository);
    }


    private BoardColumn createColumn(String columnName, Board board, BoardColumn column) {
        column.setName(columnName);
        column.setBoard(board);
        return column;
    }

    public List<Board> showBoards() {
        List<Board> boardList = boardRepository.findAll();
        if (boardList.isEmpty()) {
            System.out.println("Couldn't find any board. Please, create a new board first.");
            return null;
        }

        for (int i = 0; i < boardList.size(); i++) {
            System.out.printf("%d - %s \n", i + 1, boardList.get(i).getName());
        }

        return boardList;
    }
}
