package chess.entity.piece;

import chess.exception.InvalidPositionException;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Position {
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
