package org.jiang.combo.admin.biz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "biz")
@RestController
@RequestMapping
public class NewsController {

    @ApiOperation(value = "test22", notes = "djfj")
    @GetMapping("/afd")
    public void tset11() {

    }
}
