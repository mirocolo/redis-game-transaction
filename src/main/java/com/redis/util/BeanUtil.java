package com.redis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by jiangwenping on 17/3/19.
 */
public class BeanUtil implements ApplicationContextAware {
	private static ApplicationContext ctx;

	public static Object getBean(String beanName) {
		if (ctx == null) {
			throw new NullPointerException();
		}
		return ctx.getBean(beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		ctx = arg0;
	}

}