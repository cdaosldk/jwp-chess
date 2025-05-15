package chess.entity;

import chess.dto.CreateGameDto;
import chess.dto.GameDto;
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

@Entity
public class Game {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Color color;

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
        initializePlayers(createGameDto);

        initializePawns(chessBoards);
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

//    public boolean isValidMove(Position source, Position target) {
//        Piece piece = findPieceAt(source);
//        if (piece == null || piece.getColor() != currentTurn) {
//            return false;
//        }
//
//        return piece.canMove(target, this) && !moveCreatesCheck(source, target);
//    }

//    public void move(Position source, Position target) {
//        Piece piece = findPieceAt(source);
//        Piece targetPiece = findPieceAt(target);
//
//        if (targetPiece != null) {
//            pieces.remove(targetPiece);
//        }
//
//        piece.moveTo(target);
//        switchTurn();
//    }
//
//    private void switchTurn() {
//        currentTurn = currentTurn == Color.WHITE ? Color.BLACK : Color.WHITE;
//    }
//
//    public boolean isCheckmate() {
//        return isInCheck() && !hasValidMoves();
//    }

    public void endGame() {
        this.status = GameStatus.FINISHED;
    }

    private void initializePawns(List<ChessBoard> chessBoards) {
    }
}