package chess.entity.piece;

import chess.entity.Game;
import chess.enums.Color;
import chess.exception.InvalidMoveException;
import chess.exception.InvalidPositionException;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "piece_type")
public abstract class Piece {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Color color;

    private int x;
    private int y;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    protected Piece() {}

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int targetX, int targetY) {
        validatePosition(targetX, targetY);

        if (!game.getCurrentTurn().equals(color.name())) {
            throw new InvalidMoveException("It's not your turn");
        }
        if (!canMoveTo(targetX, targetY)) {
            throw new InvalidMoveException("Invalid move for " + getClass().getSimpleName());
        }

        Piece captured = findPieceAt(targetX, targetY);
        if (captured != null) {
            if (captured.getColor() == this.color) {
                throw new InvalidMoveException("Cannot capture your own piece");
            }
            game.removePiece(captured);
        }

        this.x = targetX;
        this.y = targetY;
        game.switchTurn();
    }

    private Piece findPieceAt(int targetX, int targetY) {
        return game.getPieces().stream()
                .filter(p -> p != this && p.x == targetX && p.y == targetY)
                .findFirst()
                .orElse(null);
    }

    private void validatePosition(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new InvalidPositionException("Position out of board: " + x + "," + y);
        }
    }

    protected abstract boolean canMoveTo(int targetX, int targetY);
}
