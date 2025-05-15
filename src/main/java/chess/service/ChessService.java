package chess.service;

import chess.dto.CreateGameDto;
import chess.dto.GameDto;
import chess.entity.Game;
import chess.repository.GameRepository;
import common.constants.ResponseCode;
import common.dto.CommonResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ChessService {

    @Resource
    private ChessService thisChessService;

    private final GameRepository gameRepository;

    public ChessService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public CommonResponseDto<GameDto> createGame(CreateGameDto createGameDto) {
        Game game = new Game();
        game.initializeBoard(createGameDto);
//        Game savedGame = gameRepository.save(game);

        return null;
//        return new CommonResponseDto.Builder().status(ResponseCode.SUCCESS.getCode()).message(ResponseCode.SUCCESS.getMessage()).data(new Object()).build();
    }

    @Transactional(readOnly = true)
    public GameDto findGame(int id) {
//        Game game = gameRepository.findById(id)
//                .orElseThrow(() -> new GameNotFoundException("Game not found with id: " + id));

//        return GameDto.from(game);
        return null;
    }

//    public void playGame(int id, MoveEvent moveEvent) {
//        Game game = gameRepository.findById(id)
//                .orElseThrow(() -> new GameNotFoundException("Game not found with id: " + id));
//
//        validateMove(game, moveEvent);
//        game.move(moveEvent.getSource(), moveEvent.getTarget());
//
//        if (game.isCheckmate()) {
//            game.endGame();
//        }
//        CreateGameDto(gameRepository.save(game).getId());
}
