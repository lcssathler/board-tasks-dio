package com.dio.board_tasks.services;

import com.dio.board_tasks.domain.Board;
import com.dio.board_tasks.domain.Card;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CardService {
    public Scanner scanner = new Scanner(System.in);

    public void createCard(Board board) {
        Card card = new Card();

        System.out.print("Type the card name: ");
        String cardName = scanner.nextLine();
        card.setTitle(cardName);

        System.out.print("Type the card description: ");
        String cardDescription = scanner.nextLine();
        card.setDescription(cardDescription);

        card.setBoardColumn(board.getInitialColumn());
        board.getInitialColumn().addCard(card);
    }

    public void viewCards(Board board) {
    }
}
