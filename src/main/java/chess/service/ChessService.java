package chess.service;

import chess.dto.CreateGameDto;
import chess.dto.GameDto;
import chess.entity.Game;
import chess.repository.GameRepository;
import chess.repository.PieceRepository;
import common.constants.ResponseCode;
import common.dto.CommonResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChessService {

    private final GameRepository gameRepository;
    private final PieceRepository pieceRepository;

    public ChessService(GameRepository gameRepository, PieceRepository pieceRepository) {
        this.gameRepository = gameRepository;
        this.pieceRepository = pieceRepository;
    }

    @Transactional
    public CommonResponseDto<GameDto> createGame(CreateGameDto createGameDto) {
        Game game = new Game();
        game.initializeBoard(createGameDto);
        // TODO: gameRepository.save(game) 후 GameDto 변환하여 반환
        return new CommonResponseDto.Builder<GameDto>()
                .status(ResponseCode.SUCCESS.getCode())
                .message(ResponseCode.SUCCESS.getMessage())
                .data(null)
                .build();
    }

    @Transactional(readOnly = true)
    public GameDto findGame(int id) {
        // TODO: GameNotFoundException 처리 포함하여 구현
        // Game game = gameRepository.findById((long) id)
        //         .orElseThrow(() -> new GameNotFoundException("Game not found with id: " + id));
        // return GameDto.from(game);
        return null;
    }

    public void playPiece(int id) {
        // TODO: MoveEvent 정의 후 구현
    }
}
