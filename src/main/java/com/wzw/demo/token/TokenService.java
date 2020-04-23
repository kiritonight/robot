package com.wzw.demo.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wzw.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 11:162020/4/23/023
 * @Modified By:
 */
@Service
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId()+"").sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
