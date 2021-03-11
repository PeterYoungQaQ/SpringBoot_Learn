package net.peter.ssm;

import io.jsonwebtoken.Claims;
import net.peter.ssm.model.entity.User;
import net.peter.ssm.utils.CommonUtils;
import net.peter.ssm.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SsmApplicationTests {

    @Test
    public void testGeneJwt(){

        User user = new User();
        user.setId(75);
        user.setHeadImg("https://www.keaidian.com/uploads/allimg/190108/co1Z10Q32551-0-8.jpg");
        user.setName("Peter");
        user.setPhone("8330608");
        user.setPwd(CommonUtils.MD5("123456ok"));

        String token = JWTUtils.geneJsonWebToken(user);
        System.out.println(token);

        Claims claims = JWTUtils.checkJWT(token);

        assert claims != null;
        System.out.println(claims.get("name"));

//        Assert.isTrue();
    }


}
