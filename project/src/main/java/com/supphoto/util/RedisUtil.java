package com.supphoto.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
    
    // ✅ 1. Redis 연결 풀 선언
    private static JedisPool jedisPool;

    // ✅ 2. static 초기화 블록
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20); // 최대 연결 수
        config.setMaxIdle(10);  // 유휴 상태 유지 연결 수
        config.setMinIdle(2);   // 최소 유휴 연결 수

        jedisPool = new JedisPool(config, "localhost", 6379);
    }

    // ✅ 3. key-value 저장 (TTL 초 단위)
    public static void set(String key, String value, int seconds) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.setex(key, seconds, value);
        }
    }

    // ✅ 4. key 값 조회
    public static String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }

    // ✅ 5. key 삭제
    public static void del(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(key);
        }
    }

    // ✅ 6. key 존재 여부 확인
    public static boolean exists(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(key);
        }
    }

    // ✅ 7. 전체 Redis 데이터 삭제 (필요시)
    public static void flushAll() {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.flushAll();
        }
    }
}
