package common.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ResponseCode - HTTP 응답 코드 열거형")
class ResponseCodeTest {

    @Test
    @DisplayName("SUCCESS는 코드 200을 반환한다")
    void SUCCESS_코드는_200이다() {
        assertThat(ResponseCode.SUCCESS.getCode()).isEqualTo(200);
    }

    @Test
    @DisplayName("BAD_REQUEST는 코드 400을 반환한다")
    void BAD_REQUEST_코드는_400이다() {
        assertThat(ResponseCode.BAD_REQUEST.getCode()).isEqualTo(400);
    }

    @Test
    @DisplayName("UNAUTHORIZED는 코드 401을 반환한다")
    void UNAUTHORIZED_코드는_401이다() {
        assertThat(ResponseCode.UNAUTHORIZED.getCode()).isEqualTo(401);
    }

    @Test
    @DisplayName("FORBIDDEN은 코드 403을 반환한다")
    void FORBIDDEN_코드는_403이다() {
        assertThat(ResponseCode.FORBIDDEN.getCode()).isEqualTo(403);
    }

    @Test
    @DisplayName("NOT_FOUND는 코드 404를 반환한다")
    void NOT_FOUND_코드는_404이다() {
        assertThat(ResponseCode.NOT_FOUND.getCode()).isEqualTo(404);
    }

    @Test
    @DisplayName("INTERNAL_SERVER_ERROR는 코드 500을 반환한다")
    void INTERNAL_SERVER_ERROR_코드는_500이다() {
        assertThat(ResponseCode.INTERNAL_SERVER_ERROR.getCode()).isEqualTo(500);
    }

    @Test
    @DisplayName("SUCCESS는 성공 메시지를 반환한다")
    void SUCCESS_메시지를_반환한다() {
        assertThat(ResponseCode.SUCCESS.getMessage()).isEqualTo("요청이 성공적으로 처리되었습니다.");
    }

    @Test
    @DisplayName("NOT_FOUND는 리소스 없음 메시지를 반환한다")
    void NOT_FOUND_메시지를_반환한다() {
        assertThat(ResponseCode.NOT_FOUND.getMessage()).isEqualTo("리소스를 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("모든 응답 코드가 정의되어 있다")
    void 모든_응답_코드가_정의되어_있다() {
        assertThat(ResponseCode.values()).hasSize(6);
    }
}
