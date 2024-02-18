package com.juegodedados.repository;

import com.juegodedados.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByPlayerId(Long playerId);
    long countByPlayerIdAndWin(Long playerId, boolean win);
void deleteByPlayerId(Long playerId);
}