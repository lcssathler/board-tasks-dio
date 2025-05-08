package com.dio.board_tasks.services;

import com.dio.board_tasks.domain.Board;
import com.dio.board_tasks.domain.Card;
import com.dio.board_tasks.repositories.CardRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public List<Card> viewCards(Board board) {
        List<Card> cards = cardRepository.findByBoard(board);
        Collections.sort(cards, (Card card1, Card card2) -> sortById(card1, card2));
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            System.out.printf("\n%d- %s [%s]", i + 1, card.getTitle(), card.getBoardColumn().getName());
        }
        return cards;
    }

    @Transactional
    public void deleteCard(Board board) {
        System.out.println("Which card do you want to delete?");
        List<Card> cards = viewCards(board);
        System.out.print("\nYour option [only numbers]: ");
        int option = scanner.nextInt();
        Card card = cards.get(option - 1);
        try {
            card.getBoardColumn().getCards().remove(card);
            System.out.println("Card removed successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int sortById(Card card1, Card card2) {
        return card1.getId().compareTo(card2.getId());
    }

}
