package com.dio.board_tasks.services;

import com.dio.board_tasks.domain.Board;
import com.dio.board_tasks.domain.BoardColumn;
import com.dio.board_tasks.domain.Card;
import com.dio.board_tasks.repositories.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Transactional
    public void deleteCard(Board board) {
        Card card = selectCard(board);
        try {
            card.getBoardColumn().getCards().remove(card);
            System.out.println("Card removed successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void moveCard(Board board) {
        Card card = selectCard(board);
        if (card.getBoardColumn().getOrdering() == 3) {
            System.out.println("You can't move a finished card.");
            return;
        }

        List<BoardColumn> columnsAvailableToMove = getColumnsAvailableToMove(card);
        BoardColumn columnToMove = displayColumnsToMove(columnsAvailableToMove);

        try {
            card.setBoardColumn(columnToMove);
            System.out.println("Card moved successfully");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void showAllCards(Board board) {
        displayCards(cardRepository.findByBoard(board));
    }

    @Transactional
    private Card selectCard(Board board) {
        System.out.println("Select a card");
        List<Card> cards = displayCards(cardRepository.findByBoard(board));

        System.out.print("\nYour option [only numbers]: ");
        int option = scanner.nextInt();
        return cards.get(option - 1);
    }

    private BoardColumn displayColumnsToMove(List<BoardColumn> columnsAvailableToMove) {
        System.out.println("For which column do you want to move to? ");
        for (int i = 0; i < columnsAvailableToMove.size(); i++) {
            System.out.printf("\n%d- %s", i + 1, columnsAvailableToMove.get(i).getName());
        }
        System.out.print("Your option [only numbers]: ");
        int optionColumn = scanner.nextInt();
        return columnsAvailableToMove.get(optionColumn - 1);
    }

    private List<BoardColumn> getColumnsAvailableToMove(Card card) {
        Board board = card.getBoardColumn().getBoard();
        List<BoardColumn> columns = new ArrayList<>();

        columns.add(board.getInitialColumn());
        columns.addAll(board.getPendingColumnList());
        columns.add(board.getFinalColumn());
        columns.add(board.getCancellationColumn());

        List<BoardColumn> columnsAvailableToMove = new ArrayList<>();
        for (BoardColumn column : columns) {
            if (column.getOrdering() == card.getBoardColumn().getOrdering() + 1) {
                columnsAvailableToMove.add(column);
            }
        }
        columnsAvailableToMove.add(board.getCancellationColumn());
        return columnsAvailableToMove;
    }

    private List<Card> displayCards(List<Card> cards) {
        Collections.sort(cards, (Card card1, Card card2) -> sortByOrdering(card1, card2));
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            System.out.printf("\n%d- %s [%s]", i + 1, card.getTitle(), card.getBoardColumn().getName());
        }

        return cards;
    }

    private static int sortByOrdering(Card card1, Card card2) {
        return Integer.compare(card1.getBoardColumn().getOrdering(), card2.getBoardColumn().getOrdering());
    }
}
