package common.dto;

public class CommonResponseDto<T> {

    private int status;
    private String message;
    private T data;

    CommonResponseDto(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static class Builder<T> {
        private int status;
        private String message;
        private T data;

        public Builder<T> status(int status) {
            this.status = status;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public CommonResponseDto<T> build() {
            return new CommonResponseDto<>(status, message, data);
        }
    }
}