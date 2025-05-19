package chess.entity.piece;

import chess.entity.Game;
import chess.enums.Color;
import chess.exception.InvalidMoveException;
import chess.exception.InvalidPositionException;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Piece extends Position {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Embedded
    private Position position;
}
    @Embeddable
    class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        validatePosition(x, y);
        this.x = x;
        this.y = y;
    }

    public Position() {

    }

    private void validatePosition(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new InvalidPositionException("Position out of board: " + x + "," + y);
        }
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
    }
}