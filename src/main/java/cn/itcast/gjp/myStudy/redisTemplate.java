/*package cn.itcast.gjp.myStudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;*/

/*
public class redisTemplate {

    @Autowired
    RedisTemplate redisTemplate;

   */
/* @Autowired
    StringRedisTemplat stringRedisTemplat;*//*


    public void insertRedis(String key,String value){
        redisTemplate.opsForHash().put("myHash","k1","v1");

    }

}
*/
