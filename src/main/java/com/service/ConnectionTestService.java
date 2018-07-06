package com.service;


import com.mapper.ConnectionTestMapper;
import com.utils.DateTimeUtils;
import com.utils.constant.Exceptions;
import com.utils.constant.Messages;
import com.utils.response.JSONResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.service
 * @Author: longhai
 * @CreateDate: 2018/5/28 17:04
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class ConnectionTestService {
    @Resource
    private ConnectionTestMapper connectionTestMapper;

    public JSONResult<String> testConn() {
        JSONResult<String> result = new JSONResult<>();
        try {
            //连接数据库
            int row = connectionTestMapper.testConn();
            //取出数据封装
            result.setRow(row);
            result.setData(Messages.SUCCES);

        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(Exceptions.EXCEPTION_MSG_5000 + e.getMessage());
            result.setExpCode(Exceptions.EXCEPTION_CODE_5000);
        }
        return result;

    }

    public JSONResult<String> influnencedDate() {
        JSONResult<String> result = new JSONResult<>();
        Date date;
        try {

            date = new Date();
            result.setData(DateTimeUtils.formatDateStr(date));
        } catch (Exception e) {
            result.setCode(0);
            result.setExpMsg(Exceptions.EXCEPTION_MSG_5000 + e.getMessage());
            result.setExpCode(Exceptions.EXCEPTION_CODE_5000);
        }
        return result;
    }
}
