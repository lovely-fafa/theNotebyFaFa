package com.itheima;

import com.itheima.service.DeptService;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Autowired
    private DeptService deptService;

    // @Test
    void TestUuid() {
        for (int i = 0; i < 100; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    void testGetJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("name", "fafa");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "fafa")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }


    public void testParseJWT() {
//        Claims claims = Jwts.parser()
//                .setSigningKey("123456")
//                .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySWQiOjE0NzE0Njc4OTIyNzE3Njc1NTQsImFjY291bnQiOiIyMDIwMjE2MDI4IiwidXVpZCI6IjZiODhjNzhkLWVmMTItNDA5ZS05MTM5LTE1N2YyN2JiNmRjNCIsInN1YiI6IjE0NzE0Njc4OTIyNzE3Njc1NTQiLCJpYXQiOjE2ODEwMjc0OTAsImV4cCI6MTY4MTExMzg5MH0.U2-99Bj8l4bS-plV61CvV_6xqrzxIVMEYvtsh5Oj2qPD4btFRcdD_Uu_iOfTIlSa8qq2_EC5q236qp0kGoK2Ig")
//                .getBody();
//        System.out.println(claims);

        JwtUtils.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi6YeR5bq4IiwiaWQiOjEsInVzZXJuYW1lIjoiamlueW9uZyIsImV4cCI6MTY4MTA4MDIwOX0.dpOT_of2qg1K7f3-_HrNPHnzgWzh9iKEuBrc7oKag6o");

    }

    @Test
    public void testAopDelete() {
        deptService.delete(10);
    }



}
