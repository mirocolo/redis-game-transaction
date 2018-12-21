package com.redis.transaction.read;

import com.redis.transaction.GameTransactionCauseImpl;
import com.redis.transaction.GameTransactionEntityCauseImpl;
import com.redis.transaction.GameTransactionEntityFactoryImpl;
import com.redis.transaction.RedisKey;
import com.redis.transaction.entity.CommonReadTransactionEntity;
import com.redis.transaction.enums.GameTransactionCommitResult;
import com.redis.transaction.service.RGTConfigService;
import com.redis.transaction.service.RGTRedisService;
import com.redis.transaction.service.TransactionService;
import com.redis.transaction.service.TransactionServiceImpl;

/**
 * Created by jiangwenping on 16/12/7.
 */
public class TestReadTransaction {
    public static void main(String[] args) throws Exception {
        RGTConfigService RGTConfigService = new RGTConfigService();
        RGTRedisService RGTRedisService = new RGTRedisService();
        RGTRedisService.setJedisPool(RGTConfigService.initRedis(RGTConfigService.initRediPoolConfig()));

        TransactionService transactionService = new TransactionServiceImpl();
        String union = "union";
        CommonReadTransactionEntity commonReadTransactionEntity = GameTransactionEntityFactoryImpl.createNormalCommonReadTransactionEnity(GameTransactionEntityCauseImpl.read, RGTRedisService, RedisKey.common, union);
        GameTransactionCommitResult commitResult = transactionService.commitTransaction(GameTransactionCauseImpl.read, commonReadTransactionEntity);
        System.out.println(commitResult.getReuslt());

        CommonReadTransactionEntity commonRejectReadTransactionEnity = GameTransactionEntityFactoryImpl.createCommonReadRejectTransactionEnity(GameTransactionEntityCauseImpl.read, RGTRedisService, RedisKey.common, union);
        commitResult = transactionService.commitTransaction(GameTransactionCauseImpl.read, commonRejectReadTransactionEnity);
        System.out.println(commitResult.getReuslt());
    }
}
