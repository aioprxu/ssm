package com.aiopr.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

public class RedisTest {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }


    public static boolean tryReleaseLock(Jedis jedis,String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
            if(LOCK_SUCCESS.equals(jedis.del(lockKey)))
                return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(tryGetDistributedLock(new RedisUtil().getJedis(),
                new String("mykey"),new String("hhhh"),50));
    }
}
