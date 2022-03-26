package io.github.sangwoo1248.board.repository;

import io.github.sangwoo1248.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Boardrepository extends JpaRepository<Board, Integer> {



}
