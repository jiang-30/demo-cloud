package org.jiang.combo.admin.controller;

import io.minio.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jiang.combo.admin.common.enums.ResultCode;
import org.jiang.combo.admin.common.utils.Result;
import org.jiang.combo.admin.model.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Api(tags = "文件管理")
@RequestMapping("/file")
@RestController
@Slf4j
@RequiredArgsConstructor
public class FileController {

    final private MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    @GetMapping("/test2")
    public void test2() {
        log.info("test2");
    }

    @ApiOperation(value = "查询文件列表（分页）")
    @GetMapping("/page")
    public Object page() {

        return "";
    }

    @ApiOperation(value = "查询文件详情")
    @GetMapping("/{id}")
    public Object detail(@PathVariable String id) {

        return Result.success(id);
    }

    @ApiOperation(value = "文件查看下载", notes = "通过文件名下载文件")
    @GetMapping("/download/{fileName}")
    public void download(HttpServletResponse response, @PathVariable("fileName") String fileName) throws IOException {

        InputStream inputStream = null;

        try {

            // 取出对象信息
            StatObjectResponse statObject = minioClient.statObject(
                    StatObjectArgs
                            .builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
            // 设置下载类型的响应信息
            response.setContentType(statObject.contentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Content-Length", String.valueOf(statObject.size()));

            // 从客户端获取输入流（获取对象响应）
            GetObjectResponse object = minioClient.getObject(
                    GetObjectArgs
                            .builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
            inputStream = object;

            // 输出文件
            IOUtils.copy(object, response.getOutputStream());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
    }

    @ApiOperation(value = "文件上传", notes = "notes")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件对象", required = true, dataType = "java.io.File")})
    @PostMapping("/upload")
    public Result upload(@RequestPart(value = "file") MultipartFile file, String inputfilename, HttpServletRequest request) throws IOException {

        log.info("charset: {}", request.getCharacterEncoding());
        log.info("name: {}", inputfilename.getBytes(StandardCharsets.UTF_8));
//        new String(inputfilename.getBytes("iso-8859-1"),"UTF-8")
        log.info("name: {}", inputfilename.getBytes(StandardCharsets.UTF_8));

        InputStream inputStream = null;
        try {
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            long size = file.getSize();

            inputStream = file.getInputStream();

//            Map<String, String> userMetadata = new HashMap<>();
//            userMetadata.put("My-Project", "Project One");

            final ObjectWriteResponse objectWriteResponse = minioClient.putObject(
                    PutObjectArgs
                            .builder()
                            .bucket(bucketName)
                            .object(filename)
                            .stream(inputStream, size, -1)
                            .contentType(contentType)
//                            .userMetadata(userMetadata)
                            .build()
            );

            String etag = objectWriteResponse.etag();
            File file1 = new File();
            file1.setFileName(filename);
            file1.setETag(etag);
            file1.setContentType(contentType);
            file1.setSize(size);
            file1.setUrl(filename);

            return Result.success(file1);

        } catch (Exception exception) {
            exception.printStackTrace();
            return Result.fail(ResultCode.SERVER_ERROR);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }

    }


    @ApiOperation(value = "通过id删除文件信息")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {

        return Result.success(id);
    }

}
