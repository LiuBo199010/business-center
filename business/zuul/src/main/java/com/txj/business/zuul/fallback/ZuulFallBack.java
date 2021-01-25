package com.txj.business.zuul.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 降级处理
 *
 * @author lenovo
 */
@Component
public class ZuulFallBack implements FallbackProvider {

    /**
     *  指定服务出问题，问题隔离，避免用户感受到后台服务变化。
     *
     * @param cause
     * @return ClientHttpResponse
     */
    @Override
    public org.springframework.http.client.ClientHttpResponse fallbackResponse(Throwable cause) {
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public org.springframework.http.client.ClientHttpResponse fallbackResponse() {
        return null;
    }

    /**
     * 返回一个ClientHttpResponse对象并实现其中的方法
     * 回退逻辑在下述方法中
     *
     * @param status
     * @return
     */
    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {

            /**
             * 返回一个HttpStatus对象 这个对象是个枚举对象， 里面包含了一个status code 和reasonPhrase信息
             *
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            /**
             * 返回status的code  比如 404，500等
             *
             * @return
             * @throws IOException
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            /**
             * 返回一个HttpStatus对象的reasonPhrase信息
             *
             * @return
             * @throws IOException
             */
            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            /**
             * 降级信息全部响应完了之后调用的方法
             */
            @Override
            public void close() {
                System.out.println("close调用");
            }

            /**
             * 设置降级：消息体
             *
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("系统繁忙,请稍后再试".getBytes());
            }

            /**
             * 设置响应头
             *
             * @return
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
