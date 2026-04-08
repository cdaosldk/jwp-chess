package chess.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Player - 플레이어 생성")
class PlayerTest {

    @Test
    @DisplayName("Builder로 Player를 생성한다")
    void Builder로_Player를_생성한다() {
        Player player = new Player.Builder()
                .id(1L)
                .build();

        assertThat(player).isNotNull();
        assertThat(player.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("생성자로 Player를 생성한다")
    void 생성자로_Player를_생성한다() {
        Player player = new Player(42L);

        assertThat(player.getId()).isEqualTo(42L);
    }

    @Test
    @DisplayName("서로 다른 id를 가진 두 Player를 생성한다")
    void 두_플레이어는_다른_id를_갖는다() {
        Player player1 = new Player.Builder().id(1L).build();
        Player player2 = new Player.Builder().id(2L).build();

        assertThat(player1.getId()).isNotEqualTo(player2.getId());
    }
}
