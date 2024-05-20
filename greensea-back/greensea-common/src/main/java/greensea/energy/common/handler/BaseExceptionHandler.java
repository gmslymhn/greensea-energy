package greensea.energy.common.handler;

import greensea.energy.common.domain.R;
import greensea.energy.common.domain.ResponseCode;
import greensea.energy.common.exception.BaseException;
import greensea.energy.common.exception.ServiceException;
import greensea.energy.common.utils.ObjectUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

/**
 * @ClassName: BaseExceptionHandler
 * @Description: 全局异常处理
 * @Author: gmslymhn
 * @CreateTime: 2024-05-18 12:15
 * @Version: 1.0
 **/
@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    /**
     * 处理BaseException
     *
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public R handlerGlobalException(HttpServletResponse response, BaseException e, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        log.error(url+"请求异常(BaseException)：", e);
        response.setStatus(e.getResponseCode());

        return R.error(e.getResponseCode(), e);
    }

    /**
     * 处理BindException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R handlerBindException(BindException e,HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        log.error(url+"请求异常(BindException)：", e);
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        assert fieldError != null;
        String defaultMessage = fieldError.getDefaultMessage();

        return R.error(ResponseCode.Bad_Request, defaultMessage);
    }

    /**
     * 处理Exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handlerException(Exception e,HttpServletRequest request) {
        String url = request.getRequestURL().toString();

        log.error(url+"请求异常(Exception)：", e);

        return R.error(ResponseCode.ERROR, e);
    }

    /**
     * 实体类校验
     * @param methodArgumentNotValidException
     * @param request
     * @return
     */

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R throwCustomException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request){

        String url = request.getRequestURL().toString();

        log.error(url+"[ @Vaild异常捕获 ] " + methodArgumentNotValidException.getMessage());

        String e = methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage();

        return R.error(ResponseCode.ERROR, e);
    }
    @ResponseBody
    @ExceptionHandler(HandlerMethodValidationException.class)
    public R handlerMethodValidationException(HandlerMethodValidationException handlerMethodValidationException, HttpServletRequest request){

        String url = request.getRequestURL().toString();

        log.error(url+"[ @Vaild异常捕获 ] " + handlerMethodValidationException.getMessage());

        String e = handlerMethodValidationException.getLocalizedMessage();

        return R.error(ResponseCode.ERROR, e);
    }

    /**
     * 业务异常
     */
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public R handleServiceException(ServiceException e) {
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        return ObjectUtils.isNotNull(code) ? R.error(code,e.getMessage()) : R.error(e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        log.error(url+"请求异常(Exception)：", e);
        return R.error(e.getMessage());
    }
}