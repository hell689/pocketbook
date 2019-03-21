package com.example.pocketbook.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class Advicer  {

    @Pointcut("execution(* controller.*.*(..))")
    public void serviceMethodExecution(){
    }

    @Around("serviceMethodExecution()")
    public Object aroundAdviceRefBookController(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(
                "Before execution: " + pjp.getSignature().getDeclaringTypeName() + "  "
                + pjp.getSignature().getName()
        );
        Object retVal = pjp.proceed();
        System.out.println(
                "After execution: " + pjp.getSignature().getDeclaringTypeName() + "  "
                        + pjp.getSignature().getName()
        );
        return retVal;
    }
}
