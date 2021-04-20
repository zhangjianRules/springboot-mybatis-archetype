package com.rules.vueshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.rules.vueshop.common.Result;
import com.rules.vueshop.common.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@Api(tags = "mock数据相关接口", value = "mock数据相关接口")
@RestController
@RequestMapping("/v1/mock")
public class MockController {

    @ApiOperation(value = "菜单权限")
    @GetMapping(value = "menu")
    public Result<JSONObject> menu() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 101);
        jsonObject.put("authName", "商品管理");
        jsonObject.put("path", null);
        JSONObject children = new JSONObject();
        children.put("id", 104);
        children.put("authName", "商品列表");
        children.put("path", null);
        children.put("children", Collections.emptyList());
        jsonObject.put("children", Collections.singletonList(children));
        return ResultGenerator.genSuccessResult(jsonObject);
    }

}
