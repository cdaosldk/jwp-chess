package chess.entity;

import chess.service.Color;
import chess.service.GameStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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
        initializeRooks();
        initializeKnights();
        initializeBishops();
        initializeQueens();
        initializeKings();
    }

    public boolean isValidMove(Position source, Position target) {
        Piece piece = findPieceAt(source);
        if (piece == null || piece.getColor() != currentTurn) {
            return false;
        }

        return piece.canMove(target, this) && !moveCreatesCheck(source, target);
    }

    public void move(Position source, Position target) {
        Piece piece = findPieceAt(source);
        Piece targetPiece = findPieceAt(target);

        if (targetPiece != null) {
            pieces.remove(targetPiece);
        }

        piece.moveTo(target);
        switchTurn();
    }

    private void switchTurn() {
        currentTurn = currentTurn == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public boolean isCheckmate() {
        return isInCheck() && !hasValidMoves();
    }

    public void endGame() {
        this.status = GameStatus.FINISHED;
    }

    // Additional helper methods...
}