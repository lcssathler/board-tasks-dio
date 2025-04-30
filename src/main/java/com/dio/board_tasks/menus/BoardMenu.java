package com.dio.board_tasks.menus;

import com.dio.board_tasks.domain.Board;
import com.dio.board_tasks.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BoardMenu {
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private CardService cardService;

    public void menu(Board board) {
        System.out.printf("\n → Board '%s' selected \n", board.getName());
        System.out.println("""
                1- Create card for this board
                2- Exclude card
                3- Move card
                4- View all cards in this board
                5- Exit""");
        System.out.print("Your option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                cardService.createCard(board);
                break;
            case 4:

        }
    }
}
