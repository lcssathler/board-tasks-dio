package com.dio.board_tasks;

import com.dio.board_tasks.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    private BoardService boardService;

    public void init() {
        while (true) {
            System.out.println("*-".repeat(5) + " BOARD MANAGEMENT " + "*-".repeat(5));
            System.out.println("""
                    1- Create new board
                    2- Select an existing board
                    3- Delete board
                    4- Exit""");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    boardService.createBoard();
                    break;
                case 2:
                    boardService.selectBoard();
                    break;
                case 3:
                    boardService.deleteBoard();
                    break;
                case 4:
                    System.exit(0);
                default:
            }
        }
    }
}
