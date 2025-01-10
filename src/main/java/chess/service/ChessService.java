package chess.service;

import chess.dto.CreateGameDto;
import chess.entity.Game;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChessService {

    private final GameRepository gameRepository;

    public ChessService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    CreateGameDto createGameDto() {
        Game game = new Game();

        game.initializeBoard();

        return new CreateGameDto(gameRepository.save(game).getId());
    }


}
