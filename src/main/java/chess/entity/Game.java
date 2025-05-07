package chess.entity;

import chess.entity.piece.Piece;
//import chess.service.Color;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Piece> pieces = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private GameStatus status = GameStatus.IN_PROGRESS;

    @Enumerated(EnumType.STRING)
    private Color currentTurn = Color.WHITE;

    public void initializeBoard() {
        // Initialize chess pieces in their starting positions
        initializePawns();
//        initializeLooks();
//        initializeKnights();
//        initializeBishops();
//        initializeQueens();
//        initializeKings();
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

    private void initializePawns() {

    }
}