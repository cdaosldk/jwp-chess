package chess.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CreateGameDto - 게임 생성 요청 DTO")
class CreateGameDtoTest {

    @Test
    @DisplayName("player1Id와 player2Id를 올바르게 반환한다")
    void player_id를_올바르게_반환한다() {
        CreateGameDto dto = new CreateGameDto(1L, 2L);

        assertThat(dto.getPlayer1Id()).isEqualTo(1L);
        assertThat(dto.getPlayer2Id()).isEqualTo(2L);
    }

    @Test
    @DisplayName("player1Id와 player2Id는 서로 다른 값을 가진다")
    void 두_플레이어_id는_다르다() {
        CreateGameDto dto = new CreateGameDto(10L, 20L);

        assertThat(dto.getPlayer1Id()).isNotEqualTo(dto.getPlayer2Id());
    }

    @Test
    @DisplayName("player id가 null인 경우에도 DTO 생성은 가능하다")
    void id가_null이어도_DTO를_생성한다() {
        CreateGameDto dto = new CreateGameDto(null, null);

        assertThat(dto.getPlayer1Id()).isNull();
        assertThat(dto.getPlayer2Id()).isNull();
    }
}
