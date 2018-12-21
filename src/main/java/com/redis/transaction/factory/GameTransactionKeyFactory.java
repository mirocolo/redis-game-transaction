package com.redis.transaction.factory;

import com.redis.config.GlobalConstants;
import com.redis.transaction.enums.GameTransactionEntityCause;

/**
 * Created by jiangwenping on 16/12/6.
 */
public class GameTransactionKeyFactory {

	public static String getCommonTransactionEntityKey(GameTransactionEntityCause cause, String RedisKey, String union) {
		return RedisKey + cause.getCause() + GlobalConstants.Strings.commonSplitString + union;
	}
}
