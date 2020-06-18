package com.web;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Author: lixianchun
 * Date: 2019/3/5
 * Description:
 */
@Slf4j
@Controller
@ResponseBody
public class ApiControlTest {

    @ApiOperation(value = "")
    @RequestMapping(value = "/api/open/terminal/b2b/syncHeDongLi11")
    public Map<String, Object> syncHeDongLi11(HttpServletRequest request) throws UnsupportedEncodingException {
        for (Map.Entry entry : request.getParameterMap().entrySet()){
            log.info("k-v {}:{}",entry.getKey(),entry.getValue());
        }
        log.info("query :{}",request.getQueryString());
        log.info("mydata:{}",request.getParameter("mydata"));
        log.info("request:{}",vo(request));
        return null;
    }

    @ApiOperation(value = "")
    @RequestMapping(value = "/api/open/terminal/b2b/syncHeDongLi22")
    public  Map<String, Object> syncHeDongLi22(HttpServletRequest request) throws UnsupportedEncodingException {

        log.info("request:{}",vo(request));
        for (Map.Entry entry : request.getParameterMap().entrySet()){
            log.info("k-v {}:{}",entry.getKey(),entry.getValue());
        }
        log.info("mydata:{}",request.getParameter("mydata"));

        log.info("query :{}",request.getQueryString());

        return null;
    }


    @ApiOperation(value = "")
    @RequestMapping(value = "/api/open/terminal/b2b/syncHeDongLi33")
    public  Map<String, Object> syncHeDongLi22(@RequestBody String a, @RequestParam("mydata") String b) throws UnsupportedEncodingException {

        log.info("a:{}",a);

        log.info("b:{}",b);

        return null;
    }

    private String vo(HttpServletRequest request){
        String result = "";

        try {
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            Throwable var3 = null;

            try {
                InputStream inStream = request.getInputStream();
                byte[] buffer = new byte[1024];
                boolean var6 = false;

                int len;
                while((len = inStream.read(buffer)) != -1) {
                    outSteam.write(buffer, 0, len);
                }

                result = new String(outSteam.toByteArray(), "utf-8");
            } catch (Throwable var15) {
                var3 = var15;
                throw var15;
            } finally {
                if (outSteam != null) {
                    if (var3 != null) {
                        try {
                            outSteam.close();
                        } catch (Throwable var14) {
                            var3.addSuppressed(var14);
                        }
                    } else {
                        outSteam.close();
                    }
                }

            }
        } catch (IOException var17) {
            log.error(var17.getMessage(), var17);
        }

        return result;
    }

}
