package com.dio.board_tasks.repositories;

import com.dio.board_tasks.domain.Board;
import com.dio.board_tasks.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("SELECT c FROM Card c WHERE c.boardColumn.board = :board")
    List<Card> findByBoard(@Param("board") Board board);
}
