package chess.service;

import chess.dto.CreateGameDto;
import chess.dto.GameDto;
import chess.entity.Game;
import chess.entity.piece.Piece;
import chess.exception.NotExistGameComponentException;
import chess.repository.GameRepository;
import chess.repository.PieceRepository;
import common.constants.ResponseCode;
import common.dto.CommonResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
@Transactional
public class ChessService {

    @Resource
    private ChessService thisChessService;

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

    public void playPiece(Long id) {
        Piece piece = pieceRepository.findById(id)
        .orElseThrow(() -> new NotExistGameComponentException("Piece not found with id: " + id));

        piece.move(Game game);
        game.move(moveEvent.getSource(), moveEvent.getTarget());

        if (game.isCheckmate()) {
            game.endGame();
        }
    }

}
