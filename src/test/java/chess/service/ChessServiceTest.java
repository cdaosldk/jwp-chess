package chess.service;

import chess.dto.CreateGameDto;
import chess.dto.GameDto;
import chess.repository.GameRepository;
import chess.repository.PieceRepository;
import common.constants.ResponseCode;
import common.dto.CommonResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
@DisplayName("ChessService - 체스 서비스 비즈니스 로직")
class ChessServiceTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private PieceRepository pieceRepository;

    private ChessService chessService;

    @BeforeEach
    void setUp() {
        chessService = new ChessService(gameRepository, pieceRepository);
    }

    @Test
    @DisplayName("createGame() 호출 시 예외 없이 응답 객체를 반환한다")
    void createGame_호출시_응답객체를_반환한다() {
        CreateGameDto dto = new CreateGameDto(1L, 2L);

        CommonResponseDto<GameDto> response = chessService.createGame(dto);

        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("createGame() 응답의 status는 200 SUCCESS이다")
    void createGame_응답_status는_200이다() {
        CreateGameDto dto = new CreateGameDto(1L, 2L);

        CommonResponseDto<GameDto> response = chessService.createGame(dto);

        assertThat(response.getStatus()).isEqualTo(ResponseCode.SUCCESS.getCode());
    }

    @Test
    @DisplayName("createGame() 응답의 message는 SUCCESS 메시지이다")
    void createGame_응답_message는_성공메시지이다() {
        CreateGameDto dto = new CreateGameDto(1L, 2L);

        CommonResponseDto<GameDto> response = chessService.createGame(dto);

        assertThat(response.getMessage()).isEqualTo(ResponseCode.SUCCESS.getMessage());
    }

    @Test
    @DisplayName("findGame()은 현재 미구현으로 null을 반환한다")
    void findGame_미구현_null_반환() {
        // TODO: 구현 완료 시 실제 게임 데이터 반환을 검증하도록 수정
        GameDto result = chessService.findGame(1);

        assertThat(result).isNull();
    }

    @Test
    @DisplayName("playPiece() 호출 시 예외 없이 실행된다")
    void playPiece_호출시_예외없이_실행된다() {
        assertDoesNotThrow(() -> chessService.playPiece(1));
    }
}
