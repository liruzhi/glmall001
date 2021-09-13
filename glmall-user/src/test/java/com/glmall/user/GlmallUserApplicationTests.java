package com.glmall.user;

import com.glmall.user.mapper.UserMapper;
import com.glmall.user.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlmallUserApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testRedis() {
        //key会乱码
        //127.0.0.1:6379> keys *
        //1) "\xac\xed\x00\x05t\x00\x06hello1"
        redisTemplate.opsForValue().set("hello1", 666);
        System.out.println(redisTemplate.opsForValue().get("hello1"));
    }


}
