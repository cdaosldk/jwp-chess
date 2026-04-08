package chess.entity.piece;

import chess.enums.Color;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Piece extends Position {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Color color;

    public Piece() {
    }

    public Piece(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
