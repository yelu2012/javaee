package com.uws.yl.messageConvert;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * @author yelu
 * @ClassName MyHttpMessageConvert
 * @ProjectName other
 * @Description: TODO
 * @date 2019/1/14 0014上午 10:09
 */
public class MyHttpMessageConvert implements HttpMessageConverter<Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyHttpMessageConvert.class);


    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        if (mediaType == null) {
            return true;
        }
        for (MediaType supportedMediaType : getSupportedMediaTypes()) {
            if (supportedMediaType.includes(mediaType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        if (mediaType == null || MediaType.ALL.equals(mediaType)) {
            return true;
        }
        for (MediaType supportedMediaType : getSupportedMediaTypes()) {
            if (supportedMediaType.isCompatibleWith(mediaType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return null;
    }

    @Override
    public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        LOGGER.info("转成对象");
        return JSON.parse(inputMessage.toString());
    }

    @Override
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        LOGGER.info("转成字符串");
        outputMessage.getBody().write(JSON.toJSONString(o).getBytes());
    }
}
