package chess.service;

import chess.entity.*;
import chess.dto.*;
import chess.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChessService {

    private final GameRepository gameRepository;

    public ChessService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public CreateGameDto createGame() {
        Game game = new Game();
        game.initializeBoard();
        Game savedGame = gameRepository.save(game);
        return new CreateGameDto(savedGame.getId());
    }

    @Transactional(readOnly = true)
    public GameDto findGame(int id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Game not found with id: " + id));

        return GameDto.from(game);
    }

    public void playGame(int id, MoveEvent moveEvent) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Game not found with id: " + id));

        validateMove(game, moveEvent);
        game.move(moveEvent.getSource(), moveEvent.getTarget());

        if (game.isCheckmate()) {
            game.endGame();
        }

        gameRepository.save(game);
    }
}

enum GameStatus {
    IN_PROGRESS, FINISHED
}

enum Color {
    WHITE, BLACK
}
