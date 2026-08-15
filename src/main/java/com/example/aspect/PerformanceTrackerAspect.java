package com.example.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // Marks this class as an infrastructure aspect
@Component
public class PerformanceTrackerAspect {

    //Intercepts any method inside com.example.service package, regardless of arguments
    @Around("execution(* com.example.service.*.*(..))")
    public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println(" [AOP Before] Starting execution of: " + joinPoint.getSignature().getName());

        // Let the actual business method run
        Object result = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        System.out.println(" [AOP After] "+ joinPoint.getSignature().getName() + " Completed in: " + executionTime + " ms");

        return result;
    }
}
