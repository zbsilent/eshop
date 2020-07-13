package com.yonyou.yapi.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zbsilent
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * 设置默认名称保存在redis的缓存时间
     * 设置详细的名称的缓存保存在redis的缓存时间
     * @param redisConnectionFactory
     * @return
     */
        @Bean
        public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
            CacheManager cacheManager = new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                    this.getRedisCacheConfigurationWithTtl(30*60),
                    this.getRedisCacheConfigurationMap());
            return cacheManager;
        }

    /**
     * SsoCache和BasicDataCache进行过期时间配置
     * @return
     */
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
            Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
            redisCacheConfigurationMap.put("SsoCache", this.getRedisCacheConfigurationWithTtl(24*60*60));
            redisCacheConfigurationMap.put("BasicDataCache", this.getRedisCacheConfigurationWithTtl(30*60));
            return redisCacheConfigurationMap;
        }

        @SuppressWarnings("unchecked")
        private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
            Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);

            RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
            redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                    RedisSerializationContext
                            .SerializationPair
                            .fromSerializer(jackson2JsonRedisSerializer)
            ).entryTtl(Duration.ofSeconds(seconds));

            return redisCacheConfiguration;
        }
    
}