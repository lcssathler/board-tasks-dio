package com.dio.board_tasks.menus;

import com.dio.board_tasks.services.BoardService;

import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);
    private BoardService boardService = new BoardService();

    public void init() {
        while (true) {
            System.out.println("*-".repeat(5) + "Board Management" + "*-".repeat(5));
            System.out.println("""
                    1- Create new board
                    2- Select a existing board
                    3- Delete board
                    4- Exit""");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    boardService.createBoard();
                case 2:
                case 3:
                case 4:
                    System.exit(0);
                default:
            }
        }
    }
}
