package com.juegodedados.service;

import com.juegodedados.model.Game;
import com.juegodedados.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game rollDice(Long playerId) {
        Random rand = new Random();
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        boolean win = (dice1 + dice2) == 7;

        Game game = new Game();
        game.setPlayerId(playerId);
        game.setDice1(dice1);
        game.setDice2(dice2);
        game.setWin(win);

        return gameRepository.save(game);
    }

    public List<Game> getGamesByPlayerId(Long playerId) {
        return gameRepository.findByPlayerId(playerId);
    }

    public void deleteGamesByPlayerId(Long playerId) {
        gameRepository.deleteByPlayerId(playerId);
    }
}