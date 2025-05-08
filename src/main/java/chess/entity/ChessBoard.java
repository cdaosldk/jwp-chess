package chess.entity;

public class ChessBoard {
    private final int x;
    private final int y;
    private final boolean isOccupied;

    public ChessBoard(int x, int y, boolean isOccupied) {
        this.x = x;
        this.y = y;
        this.isOccupied = isOccupied;
    }
}
