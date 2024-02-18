package com.juegodedados.controller;

import com.juegodedados.model.Game;
import com.juegodedados.model.Player;
import com.juegodedados.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.createPlayer(player));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayer(id, player));
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<List<Game>> getPlayerGames(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayerGames(id));
    }

    @DeleteMapping("/{id}/games")
    public ResponseEntity<Void> deletePlayerGames(@PathVariable Long id) {
        playerService.deletePlayerGames(id);
        return ResponseEntity.noContent().build();
    }
}