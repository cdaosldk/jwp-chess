package chess.entity;

import chess.dto.CreateGameDto;
import chess.dto.GameDto;
import chess.entity.piece.Pawn;
import chess.entity.piece.Piece;
//import chess.service.Color;
import chess.enums.Color;
import chess.enums.GameStatus;
import common.dto.CommonResponseDto;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private List<Player> players;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Piece> pieces = new ArrayList<>();

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChessBoard> chessBoards = new ArrayList<>();

    public void initializeBoard(CreateGameDto createGameDto) {
        chessBoards = new ArrayList<>();
        pieces = new ArrayList<>();
        initializePlayers(createGameDto);

        initializePawns(chessBoards, pieces);
//        initializeLooks(chessBoards);
//        initializeKnights(chessBoards);
//        initializeBishops(chessBoards);
//        initializeQueens(chessBoards);
//        initializeKings(chessBoards);
    }

    private void initializePlayers(CreateGameDto createGameDto) {
        Player player1 =
            new Player.Builder()
                    .id(createGameDto.getPlayer1Id())
                    .build();

        Player player2 =
            new Player.Builder()
                .id(createGameDto.getPlayer2Id())
                .build();

        players.add(player1);
        players.add(player2);
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }

    public void switchTurn() {
        if (currentTurn.equals("BLACK")) {
            currentTurn = "WHITE";
        } else {
            currentTurn = "BLACK";
        }
    }
//
//    public boolean isCheckmate() {
//        return isInCheck() && !hasValidMoves();
//    }

    public void endGame() {
        this.status = GameStatus.FINISHED;
    }

    private void initializePawns(List<ChessBoard> chessBoards, List<Piece> pieces) {
        for (int i = 0; i < 8; i++) {
        }
    }
}