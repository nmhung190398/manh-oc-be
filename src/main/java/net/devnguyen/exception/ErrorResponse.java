package net.devnguyen.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represent http response body
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse<T> {
    private int code;
    private String message;
    private T data;

    private String error;

    @Builder
    public ErrorResponse(int code, String message, T data, String error) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.error = error;
    }
}
