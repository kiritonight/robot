package com.wzw.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 17:212020/4/23/023
 * @Modified By:
 */
public class RegexUtil {
    public static final String REGEXEMAIL="[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
    public static final String REGEXPHONE="^1[3|4|5|7|8][0-9]\\d{4,8}$";
    public Boolean regexEmail(String content)
    {
            Pattern pattern=Pattern.compile(REGEXEMAIL);
            Matcher matcher=pattern.matcher(content);
            if(matcher.find())
            {
                return true;
            }else{
                return false;
            }
    }
    public Boolean regexPhone(String content)
    {
        Pattern pattern=Pattern.compile(REGEXPHONE);
        Matcher matcher=pattern.matcher(content);
        if(matcher.find())
        {
            return true;
        }else{
            return false;
        }

    }

}
