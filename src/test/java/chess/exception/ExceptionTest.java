package chess.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("커스텀 예외 - 메시지 전달 및 상속 구조 검증")
class ExceptionTest {

    @Test
    @DisplayName("GameNotFoundException은 전달된 메시지를 반환한다")
    void GameNotFoundException_메시지를_반환한다() {
        String message = "Game not found with id: 99";
        GameNotFoundException exception = new GameNotFoundException(message);

        assertThat(exception.getMessage()).isEqualTo(message);
    }

    @Test
    @DisplayName("GameNotFoundException은 RuntimeException을 상속한다")
    void GameNotFoundException은_RuntimeException이다() {
        GameNotFoundException exception = new GameNotFoundException("test");

        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("InvalidMoveException은 전달된 메시지를 반환한다")
    void InvalidMoveException_메시지를_반환한다() {
        String message = "이동할 수 없는 위치입니다.";
        InvalidMoveException exception = new InvalidMoveException(message);

        assertThat(exception.getMessage()).isEqualTo(message);
    }

    @Test
    @DisplayName("InvalidMoveException은 RuntimeException을 상속한다")
    void InvalidMoveException은_RuntimeException이다() {
        InvalidMoveException exception = new InvalidMoveException("test");

        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("InvalidPositionException은 전달된 메시지를 반환한다")
    void InvalidPositionException_메시지를_반환한다() {
        String message = "Position out of board: -1,0";
        InvalidPositionException exception = new InvalidPositionException(message);

        assertThat(exception.getMessage()).isEqualTo(message);
    }

    @Test
    @DisplayName("InvalidPositionException은 RuntimeException을 상속한다")
    void InvalidPositionException은_RuntimeException이다() {
        InvalidPositionException exception = new InvalidPositionException("test");

        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("잘못된 위치에서 Position 생성 시 InvalidPositionException이 던져진다")
    void 잘못된_위치에서_예외가_던져진다() {
        assertThatThrownBy(() -> {
            throw new InvalidPositionException("Position out of board: 9,9");
        }).isInstanceOf(InvalidPositionException.class)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("9,9");
    }
}
