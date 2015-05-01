package br.com.sce.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoProxy{

	@AfterThrowing(pointcut="within(IDao+) ", throwing="e")
	public void afterException(JoinPoint joinPoint, Throwable e){
		System.out.println("Exceção: " + e);
	}
	
	
}
