package org.jiang.combo.admin.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jiang.combo.common.response.R;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {
    public static void out(HttpServletResponse response, R r) {
        ObjectMapper objectMapper = new ObjectMapper();

        response.setStatus(HttpStatus.OK.value());
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        try {
            objectMapper.writeValue(response.getWriter(), r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
