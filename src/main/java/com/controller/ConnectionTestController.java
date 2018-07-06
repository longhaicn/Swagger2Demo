package com.controller;

import com.service.ConnectionTestService;
import com.utils.annotation.IgnoreAuth;
import com.utils.response.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.api
 * @Author: longhai
 * @CreateDate: 2018/5/28 17:02
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Api(value = "连接测试接口", description = "Connection Test Controller", basePath = "api", tags = "Connection Test APIS")
@RestController
public class ConnectionTestController {
    @Resource
    private ConnectionTestService connectionTestService;

    @IgnoreAuth
    @ApiOperation(value = "测试连接数据")
    @RequestMapping(method = RequestMethod.GET, value = "/testConn")
    public JSONResult<String> testConn(HttpServletRequest request) {

        return connectionTestService.testConn();
    }

    @IgnoreAuth
    @ApiOperation(value = "获取上次同步时间戳")
    @RequestMapping(method = RequestMethod.GET, value = "/influnencedDate")
    public JSONResult<String> influnencedDate(HttpServletRequest request) {

        return connectionTestService.influnencedDate();
    }


}
