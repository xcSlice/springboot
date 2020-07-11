package com.example.mybatistest.note.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: IntelliJ IDEA
 * @description: jwt创建令牌
 * @author: xusi
 * @create:2020-07-11 15:30
 **/
public class JwtUtils {
    public static final long EXPIRAT = 60 * 60 * 24 * 10;
    public static final String APP_SECRET = "FdsfaO15U4xcva210HFSDfa043";
    //拦截请求,验证token

    public static String getToken(String id, String name){
        String token = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .setSubject("note-login")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRAT))
                .claim("id",id)
                .claim("name",name)
                .signWith(SignatureAlgorithm.HS256,APP_SECRET)
                .compact();
        return token;
    }

//    从 String 中获得 token ,检测 token 是否正确
    public static boolean checkToken(String token){
        if(StringUtils.isEmpty(token)) return false;
        try{
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
//  从reques 中获取 token, check
    public static boolean checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
//            call checkToken(String token)
        return checkToken(token);

    }

//    获取 token 中的用户信息

    public static String getIdByJwtToken(HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return claims.get("id").toString();
    }
}
