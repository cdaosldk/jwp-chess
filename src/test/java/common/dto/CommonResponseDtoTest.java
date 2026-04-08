package common.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CommonResponseDto - 공통 응답 래퍼")
class CommonResponseDtoTest {

    @Test
    @DisplayName("Builder로 status, message, data를 설정하여 응답을 생성한다")
    void Builder로_응답을_생성한다() {
        CommonResponseDto<String> response = new CommonResponseDto.Builder<String>()
                .status(200)
                .message("성공")
                .data("결과 데이터")
                .build();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getMessage()).isEqualTo("성공");
        assertThat(response.getData()).isEqualTo("결과 데이터");
    }

    @Test
    @DisplayName("data가 null인 응답을 생성할 수 있다")
    void data가_null인_응답을_생성한다() {
        CommonResponseDto<String> response = new CommonResponseDto.Builder<String>()
                .status(404)
                .message("Not Found")
                .data(null)
                .build();

        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getData()).isNull();
    }

    @Test
    @DisplayName("Integer 타입의 data를 담을 수 있다")
    void Integer_타입의_data를_담는다() {
        CommonResponseDto<Integer> response = new CommonResponseDto.Builder<Integer>()
                .status(200)
                .message("성공")
                .data(42)
                .build();

        assertThat(response.getData()).isEqualTo(42);
    }

    @Test
    @DisplayName("status 코드만 설정해도 빌드 가능하다")
    void status만_설정하여_빌드한다() {
        CommonResponseDto<Void> response = new CommonResponseDto.Builder<Void>()
                .status(500)
                .build();

        assertThat(response.getStatus()).isEqualTo(500);
        assertThat(response.getMessage()).isNull();
        assertThat(response.getData()).isNull();
    }
}
