package com.redis.transaction.factory;

import com.redis.transaction.entity.CommonReadTransactionEntity;
import com.redis.transaction.enums.GameTransactionEntityCause;
import com.redis.transaction.service.IRGTRedisService;

/**
 * Created by jiangwenping on 16/12/6.
 */
public class GameTransactionEntityFactory {

	/**
	 * 获取通用读锁实体 默认不能读取到
	 */
	public static CommonReadTransactionEntity createCommonReadRejectTransactionEnity(
			GameTransactionEntityCause cause, IRGTRedisService redisService,
			String redisKey, String unionKey) {
		CommonReadTransactionEntity commonReadTransactionEntity = createNormalCommonReadTransactionEnity(cause, redisService, redisKey, unionKey);
		commonReadTransactionEntity.setRejectFlag(true);
		return commonReadTransactionEntity;
	}

	/**
	 * 获取通用读锁实体 默认需要读取到
	 */
	public static CommonReadTransactionEntity createNormalCommonReadTransactionEnity(
			GameTransactionEntityCause cause, IRGTRedisService redisService, String redisKey,
			String unionKey) {
		String key = GameTransactionKeyFactory.getCommonTransactionEntityKey(
				cause, redisKey, unionKey);
		return new CommonReadTransactionEntity(cause, key, redisService);
	}
}
