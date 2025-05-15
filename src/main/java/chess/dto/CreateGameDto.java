package chess.dto;

public class CreateGameDto {
    private final Long player1Id;
    private final Long player2Id;

    public CreateGameDto(Long player1Id, Long player2Id) {
        this.player1Id = player1Id;
        this.player2Id = player2Id;
    }

    public Long getPlayer2Id() {
        return player2Id;
    }

    public Long getPlayer1Id() {
        return player1Id;
    }
}
