package com.juegodedados.controller;

import com.juegodedados.model.Game;
import com.juegodedados.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players/{id}/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<Game> rollDice(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.rollDice(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteGames(@PathVariable Long id) {
        gameService.deleteGamesByPlayerId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Game>> getGamesByPlayerId(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.getGamesByPlayerId(id));
    }
}