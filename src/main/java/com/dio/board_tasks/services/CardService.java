package com.dio.board_tasks.services;

import com.dio.board_tasks.domain.Board;
import com.dio.board_tasks.domain.BoardColumn;
import com.dio.board_tasks.domain.Card;
import com.dio.board_tasks.domain.InitialColumn;
import com.dio.board_tasks.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
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
        cardRepository.save(card);
    }

    public void viewCards(Board board) {
        System.out.println("All cards:");
        List<BoardColumn> allBoardColumns = List.of(board.getInitialColumn(), board.getFinalColumn(), board.getCancellationColumn());
        allBoardColumns.forEach(CardService::cardPrinter);
    }

    private static void cardPrinter(BoardColumn boardColumn) {
        List<Card> cards = boardColumn.getCards();
        Collections.sort(cards, (Card card1, Card card2) -> sortById(card1, card2));
        cards.forEach(card -> {
            System.out.printf("%d- %s [%s] \n", card.getId(), card.getTitle(), card.getBoardColumn().getName().toUpperCase());
        });
    }

    private static int sortById(Card card1, Card card2) {
        return card1.getId().compareTo(card2.getId());
    }

}
