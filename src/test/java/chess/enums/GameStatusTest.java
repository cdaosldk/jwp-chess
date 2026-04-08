package chess.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameStatus - 게임 상태")
class GameStatusTest {

    @Test
    @DisplayName("CREATED, IN_PROGRESS, FINISHED 세 가지 상태가 존재한다")
    void 세_가지_상태가_존재한다() {
        assertThat(GameStatus.values())
                .containsExactlyInAnyOrder(GameStatus.CREATED, GameStatus.IN_PROGRESS, GameStatus.FINISHED);
    }

    @Test
    @DisplayName("게임 생성 시 CREATED 상태다")
    void CREATED_상태가_존재한다() {
        assertThat(GameStatus.valueOf("CREATED")).isEqualTo(GameStatus.CREATED);
    }

    @Test
    @DisplayName("게임 진행 중 IN_PROGRESS 상태다")
    void IN_PROGRESS_상태가_존재한다() {
        assertThat(GameStatus.valueOf("IN_PROGRESS")).isEqualTo(GameStatus.IN_PROGRESS);
    }

    @Test
    @DisplayName("게임 종료 시 FINISHED 상태다")
    void FINISHED_상태가_존재한다() {
        assertThat(GameStatus.valueOf("FINISHED")).isEqualTo(GameStatus.FINISHED);
    }
}
