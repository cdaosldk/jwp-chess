package chess.entity.piece;

import chess.entity.Game;
import chess.service.Color;
import chess.service.Game;
import chess.service.InvalidMoveException;
import chess.service.InvalidPositionException;
import chess.service.Position;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Piece {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Embedded
    private Position position;

    abstract boolean canMove(Position target, Game game);

    public void moveTo(Position target) {
        this.position = target;
    }
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

    private void validatePosition(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new InvalidPositionException("Position out of board: " + x + "," + y);
        }
    }

    private void validateMove(Game game, MoveEvent moveEvent) {
        Position source = moveEvent.getSource();
        Position target = moveEvent.getTarget();

        if (!game.isValidMove(source, target)) {
            throw new InvalidMoveException("Invalid move from " + source + " to " + target);
        }
    }
}