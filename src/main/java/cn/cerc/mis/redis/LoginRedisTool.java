package cn.cerc.mis.redis;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.cerc.db.redis.JedisFactory;
import redis.clients.jedis.Jedis;

public class LoginRedisTool {

    private static final Logger log = LoggerFactory.getLogger(LoginRedisTool.class);

    public static final String s_current_users = "s_current_users";

    public static final int viability_default = 300;

    public void set(String key, double viability, String token) {
        try (Jedis redis = JedisFactory.getJedis()) {
            redis.zadd(key, viability, token);
        }
    }

    public Set<String> getUserTokens(String key, double min, double max) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.zrangeByScore(key, min, max);
        }
    }

    public double getViability(String key, String token) {
        try (Jedis redis = JedisFactory.getJedis()) {
            return redis.zscore(key, token);
        }
    }

    public void remove(String key, String token) {
        try (Jedis redis = JedisFactory.getJedis()) {
            redis.zrem(key, token);
        }
    }

    public static void main(String[] args) {
        LoginRedisTool obj = new LoginRedisTool();
        obj.set(s_current_users, 300, "t1");
        obj.set(s_current_users, 300, "t2");
        obj.set(s_current_users, 300, "t3");

        // 获取活着的用户
        Set<String> tokens = obj.getUserTokens(s_current_users, 1, 300);
        for (String token : tokens) {
            double value = obj.getViability(s_current_users, token);
            obj.set(s_current_users, value - 10, token);
        }

        obj.remove(s_current_users, "t1");

        tokens = obj.getUserTokens(s_current_users, 1, 300);
        for (String token : tokens) {
            log.info("{} {}", token, obj.getViability(s_current_users, token));
        }
    }

}
