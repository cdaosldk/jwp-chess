package chess.entity;

import chess.dto.CreateGameDto;
import chess.enums.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Game - 게임 엔티티 도메인 로직")
class GameTest {

    @Test
    @DisplayName("새로 생성된 Game의 상태는 null이다")
    void 새_게임의_초기_상태는_null이다() {
        Game game = new Game();

        assertThat(game.getStatus()).isNull();
    }

    @Test
    @DisplayName("endGame() 호출 시 게임 상태가 FINISHED로 변경된다")
    void endGame_호출시_상태가_FINISHED로_변경된다() {
        Game game = new Game();
        game.endGame();

        assertThat(game.getStatus()).isEqualTo(GameStatus.FINISHED);
    }

    @Test
    @DisplayName("initializeBoard() 호출 시 2명의 플레이어가 등록된다")
    void initializeBoard_호출시_플레이어_2명이_등록된다() {
        Game game = new Game();
        CreateGameDto dto = new CreateGameDto(1L, 2L);

        game.initializeBoard(dto);

        assertThat(game.getPlayers()).hasSize(2);
    }

    @Test
    @DisplayName("initializeBoard() 후 플레이어 id가 DTO 값과 일치한다")
    void initializeBoard_후_플레이어_id가_일치한다() {
        Game game = new Game();
        CreateGameDto dto = new CreateGameDto(10L, 20L);

        game.initializeBoard(dto);

        assertThat(game.getPlayers())
                .extracting(Player::getId)
                .containsExactlyInAnyOrder(10L, 20L);
    }

    @Test
    @DisplayName("endGame()을 두 번 호출해도 FINISHED 상태를 유지한다")
    void endGame을_두번_호출해도_FINISHED_유지() {
        Game game = new Game();
        game.endGame();
        game.endGame();

        assertThat(game.getStatus()).isEqualTo(GameStatus.FINISHED);
    }
}
