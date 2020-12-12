package com.yh.controller;

import com.github.pagehelper.PageInfo;
import com.yh.pojo.User;
import com.yh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Api(value = "用户所有接口",tags = "用户接口")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/findAllUser")
    @ResponseBody
    @ApiOperation(value = "查询所有用户的接口",tags = "查询所有用户的接口")
    public List<User> findAllUser() {
        return userService.findAll();
    }

    @GetMapping("/findUserByPage/{pageIndex}/{pageSize}")
    @ResponseBody
    @ApiOperation(value = "分页查询用户的接口", tags = "分页查询用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex",value = "当前页码",required = true,example = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",required = true,example = "1"),
    })
    public PageInfo<User> findUserByPage(@PathVariable("pageIndex") Integer pageIndex,
                                         @PathVariable("pageSize") Integer pageSize) {
        return userService.findUserByPage(pageIndex,pageSize);
    }

    @GetMapping("/transfer/{sourceId}/{targetId}/{money}")
    @ResponseBody
    @ApiOperation(value = "转账接口",tags = "转账接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sourceId",value = "转账人id",required = true,example = "1"),
            @ApiImplicitParam(name = "targetId",value = "收账人id",required = true,example = "2"),
            @ApiImplicitParam(name = "money",value = "转账金额",required = true,example = "100")
    })
    public String transfer(@PathVariable("sourceId") Integer sourceId,
                           @PathVariable("targetId") Integer targetId,
                           @PathVariable("money") Integer money) {
        try {
            userService.transfer(sourceId, targetId, money);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
