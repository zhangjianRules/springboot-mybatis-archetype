package com.rules.vueshop.controller;


import com.rules.vueshop.common.Result;
import com.rules.vueshop.common.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Api(tags = "health")
public class HealthController {
    @GetMapping(path = "/health")
    @ApiOperation("用于判断服务是否正常")
    public Result<String> health() {
        return ResultGenerator.genSuccessResult("server ok");
    }
}