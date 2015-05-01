package br.com.sce.dao;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.ThrowsAdvice;

@Aspect
public class DaoProxy implements ThrowsAdvice {

	@AfterThrowing(pointcut="execution(* br.com.sce.dao.* ")
	public void afterException(Exception e){
		System.out.println(e);
	}
	
}
