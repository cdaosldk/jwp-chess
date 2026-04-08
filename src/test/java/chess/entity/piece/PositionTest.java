package chess.entity.piece;

import chess.exception.InvalidPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Position - 체스판 좌표 유효성 검증")
class PositionTest {

    @Test
    @DisplayName("유효한 좌표로 Position 생성 성공")
    void 유효한_좌표로_생성한다() {
        Position position = new Position(3, 4);

        assertThat(position.getX()).isEqualTo(3);
        assertThat(position.getY()).isEqualTo(4);
    }

    @ParameterizedTest(name = "경계값 ({0},{1}) 생성 성공")
    @DisplayName("경계값 좌표 생성 성공")
    @CsvSource({"0,0", "7,7", "0,7", "7,0"})
    void 경계값_좌표로_생성한다(int x, int y) {
        Position position = new Position(x, y);

        assertThat(position.getX()).isEqualTo(x);
        assertThat(position.getY()).isEqualTo(y);
    }

    @Test
    @DisplayName("x가 음수이면 InvalidPositionException 발생")
    void x가_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(-1, 3))
                .isInstanceOf(InvalidPositionException.class)
                .hasMessageContaining("-1");
    }

    @Test
    @DisplayName("x가 7 초과이면 InvalidPositionException 발생")
    void x가_7초과이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(8, 3))
                .isInstanceOf(InvalidPositionException.class)
                .hasMessageContaining("8");
    }

    @Test
    @DisplayName("y가 음수이면 InvalidPositionException 발생")
    void y가_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(3, -1))
                .isInstanceOf(InvalidPositionException.class)
                .hasMessageContaining("-1");
    }

    @Test
    @DisplayName("y가 7 초과이면 InvalidPositionException 발생")
    void y가_7초과이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(3, 8))
                .isInstanceOf(InvalidPositionException.class)
                .hasMessageContaining("8");
    }

    @ParameterizedTest(name = "범위 초과 좌표 ({0},{1}) 예외 발생")
    @DisplayName("범위를 벗어난 좌표는 모두 예외 발생")
    @CsvSource({"-1,-1", "8,8", "-1,8", "8,-1"})
    void 범위_초과_좌표는_예외가_발생한다(int x, int y) {
        assertThatThrownBy(() -> new Position(x, y))
                .isInstanceOf(InvalidPositionException.class);
    }

    @Test
    @DisplayName("기본 생성자로 Position 생성 가능")
    void 기본_생성자로_생성한다() {
        Position position = new Position();

        assertThat(position.getX()).isEqualTo(0);
        assertThat(position.getY()).isEqualTo(0);
    }
}
