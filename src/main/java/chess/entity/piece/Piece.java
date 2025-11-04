package chess.entity.piece;

import chess.entity.Game;
import chess.enums.Color;
import chess.exception.InvalidPositionException;
import org.hibernate.annotations.Entity;
import org.hibernate.type.EnumType;
import org.springframework.data.annotation.Id;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Piece extends Position {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.TYPE)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public Color getColor() {
        return color;
    }

    public void move(Game game) throws InvalidPositionException {
//        List<Piece> pieceList = ga

        Piece piece = findPieceWithGame();
        Piece targetPiece = findPieceWithGame();

        if (targetPiece != null) {
            pieceList.remove(targetPiece);
        }

        piece.moveTo(target);
    }

    public Piece findPieceWithGame() {

    }

    private boolean isValidMove(Position target) {
        Position source = new Position(x, y);

        Piece piece = findPieceWithGame(source);
        if (piece == null || piece.getColor() != currentTurn) {
            return false;
        }

    return true;
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

    public Position() {}

    private void validatePosition(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new InvalidPositionException("Position out of board: " + x + "," + y);
        }
    }
}