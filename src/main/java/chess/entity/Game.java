package chess.entity;

import chess.dto.CreateGameDto;
import chess.enums.Color;
import chess.enums.GameStatus;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Color color;

    private String currentTurn;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChessBoard> chessBoards = new ArrayList<>();

    public void initializeBoard(CreateGameDto createGameDto) {
        chessBoards = new ArrayList<>();
        initializePlayers(createGameDto);
        // TODO: initializePawns, initializeLooks, initializeKnights, initializeBishops, initializeQueens, initializeKings
    }

    private void initializePlayers(CreateGameDto createGameDto) {
        Player player1 = new Player.Builder()
                .id(createGameDto.getPlayer1Id())
                .build();

        Player player2 = new Player.Builder()
                .id(createGameDto.getPlayer2Id())
                .build();

        players.add(player1);
        players.add(player2);
    }

    private void switchTurn() {
        if ("BLACK".equals(currentTurn)) {
            currentTurn = "WHITE";
        } else {
            currentTurn = "BLACK";
        }
    }

    public void endGame() {
        this.status = GameStatus.FINISHED;
    }

    public int getId() {
        return id;
    }

    public GameStatus getStatus() {
        return status;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
