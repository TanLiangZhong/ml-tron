package com.ml.tron.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页控制器
 *
 * @author liangzhong
 * @date 2019/3/16 17:33
 */
@Slf4j
@RestController
@RequestMapping("/index")
@Api(description = "主页控制器")
public class IndexController {

    @ApiOperation("Hello")
    @GetMapping("hello/{name}")
    public String helloWorld(@ApiParam("名称") @PathVariable String name) {
        log.info(" Tron Service , Hello {}", name);
        return "Hello " + name;
    }

}
