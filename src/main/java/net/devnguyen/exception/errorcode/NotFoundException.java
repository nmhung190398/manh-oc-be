package net.devnguyen.exception.errorcode;

import lombok.Getter;
import net.devnguyen.exception.ResponseError;

/**
 * @author nmhung-evotek on 6/28/2021
 */
@Getter
public enum NotFoundException implements ResponseError {
    SCOPE_NOT_FOUND(404001, "SCOPE_NOT_FOUND"),
    USER_NOT_FOUND(404002, "USER_NOT_FOUND"),
    DATA_NOT_FOUND(404003, "DATA_NOT_FOUND"),
    ;

    private final String message;
    private final int code;

    NotFoundException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getStatus() {
        return 400;
    }

    public Integer getCode() {
        return code;
    }
}
