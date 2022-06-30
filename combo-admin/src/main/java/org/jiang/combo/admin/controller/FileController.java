package org.jiang.combo.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Api(tags = "文件管理")
@RequestMapping("/file")
@RestController
@Slf4j
public class FileController {

    @ApiOperation(value = "文件上传", notes = "notes")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件对象", required = true, dataType = "java.io.File")
    })
    @PostMapping("/test")
    public String test(@RequestPart(value = "file") MultipartFile file) throws IOException {
//        log.info(username);
//        request.get
        if(!file.isEmpty()) {
            log.info("文件类型： {}", file.getContentType());
            log.info("文件大小： {}", file.getSize());
            log.info("文件名称： {}", file.getOriginalFilename());
        }
        return "fdf:" + file.getOriginalFilename();
    }
}
