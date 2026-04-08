package chess.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Color - 체스 기물 색상")
class ColorTest {

    @Test
    @DisplayName("WHITE와 BLACK 두 가지 색상이 존재한다")
    void 두_가지_색상이_존재한다() {
        assertThat(Color.values()).containsExactlyInAnyOrder(Color.WHITE, Color.BLACK);
    }

    @Test
    @DisplayName("WHITE 색상의 이름은 WHITE이다")
    void WHITE_색상_이름을_반환한다() {
        assertThat(Color.WHITE.name()).isEqualTo("WHITE");
    }

    @Test
    @DisplayName("BLACK 색상의 이름은 BLACK이다")
    void BLACK_색상_이름을_반환한다() {
        assertThat(Color.BLACK.name()).isEqualTo("BLACK");
    }

    @Test
    @DisplayName("WHITE와 BLACK은 서로 다른 색상이다")
    void WHITE와_BLACK은_다른_색상이다() {
        assertThat(Color.WHITE).isNotEqualTo(Color.BLACK);
    }

    @Test
    @DisplayName("문자열로 Color를 조회할 수 있다")
    void 문자열로_Color를_조회한다() {
        assertThat(Color.valueOf("WHITE")).isEqualTo(Color.WHITE);
        assertThat(Color.valueOf("BLACK")).isEqualTo(Color.BLACK);
    }
}
