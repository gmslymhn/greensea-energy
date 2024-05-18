package greensea.energy.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: BaseException
 * @Description: 基础异常
 * @Author: gmslymhn
 * @CreateTime: 2024-05-18 12:13
 * @Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private Integer responseCode;

    public BaseException(Integer responseCode, String message) {
        super(message);

        setResponseCode(responseCode);
    }

}
