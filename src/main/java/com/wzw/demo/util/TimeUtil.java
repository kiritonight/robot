package com.wzw.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 11:192020/4/27/027
 * @Modified By:
 */
public class TimeUtil {

    public String GetCurrentTime(Date d)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(d);// new Date()为获取当前系统时间
    }
}
