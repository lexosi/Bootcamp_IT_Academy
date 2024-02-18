package com.juegodedados.service;

import com.juegodedados.exception.ResourceNotFoundException;
import com.juegodedados.model.Game;
import com.juegodedados.model.Player;
import com.juegodedados.repository.GameRepository;
import com.juegodedados.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Optional<Player> getPlayer(Long id) {
        return playerRepository.findById(id);
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        Player player = playerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Player not found for this id :: " + id));
    
        player.setName(playerDetails.getName());
        player.setRegistrationDate(playerDetails.getRegistrationDate());
        final Player updatedPlayer = playerRepository.save(player);
        return updatedPlayer;
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public double getSuccessRate(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        double totalGames = getTotalGames(id);
        double gamesWon = getGamesWon(id);

        if (totalGames == 0) {
            return 0;
        }

        return (gamesWon / totalGames) * 100;
    }

    public long getTotalGames(Long playerId) {
    return gameRepository.findByPlayerId(playerId).size();
}

public long getGamesWon(Long playerId) {
    return gameRepository.countByPlayerIdAndWin(playerId, true);
}
    public List<Game> getPlayerGames(Long playerId) {
        return gameRepository.findByPlayerId(playerId);
    }

    public void deletePlayerGames(Long playerId) {
        gameRepository.deleteByPlayerId(playerId);
    }
}