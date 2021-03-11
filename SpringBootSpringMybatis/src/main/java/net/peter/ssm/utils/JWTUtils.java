package net.peter.ssm.utils;
/*
 * @Author: Haoran
 * @Date: 2021/3/11 15:28
 * @Description: JWT工具类
 */


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.peter.ssm.domain.User;

import java.util.Date;

/**
 * 注意点：
 * 1. 生成的token，是可以通过base64解密出明文信息的
 * 2. base64进行解密出明文信息，再进行修改和编码，则会解密失败
 * 3. 无法作废已经颁布的令牌，除非修改密钥
 */
public class JWTUtils {

    /**
     * 过期时间，总共一周
     */
    static final long EXPIRE = 60000 * 60 * 24 * 7;

    /**
     * 密钥信息
     */
    private static final String SERECT = "peteryoung";


    /**
     * token前缀信息
     */
    private static final String TOKEN_PREFIX = "helloworld";

    /**
     * 主题颁布者
     */
    private static final String SUBJECT = "YHR";

    /**
     * 根据用户信息生成token令牌
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("phone", user.getPhone())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SERECT).compact();

        token = TOKEN_PREFIX + token;

        return token;
    }

    /**
     * 对token令牌信息进行校验
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try{
            final Claims claims = Jwts.parser().setSigningKey(SERECT)
                    .parseClaimsJwt(token.replace(TOKEN_PREFIX,""))
                    .getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}
