package common.dto;

public class CommonResponseDto<C> {

    private int status;
    private String message;
    private Object data;

    CommonResponseDto(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public class Builder {
        private int status;
        private String message;
        private Object data;

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public CommonResponseDto<C> build() {
            return new CommonResponseDto<C>(status, message, data);
        }
    }
}