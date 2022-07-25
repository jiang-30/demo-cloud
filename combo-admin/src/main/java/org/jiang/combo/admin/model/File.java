package org.jiang.combo.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "上传文件对象", description = "上传文件对象")
@Data
public class File {

    @ApiModelProperty("路径")
    private String url;

    @ApiModelProperty("文件名")
    private String fileName;

    @ApiModelProperty("文件hash")
    private String eTag;

    @ApiModelProperty("原文件名")
    private String originName;

    @ApiModelProperty("文件扩展名")
    private String ext;

    @ApiModelProperty("文件大小")
    private long size;

    @ApiModelProperty("文件类型")
    private String contentType;

}
