package org.example.springbootlearn;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logtime(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();

        try{
            //execute at join point
            joinPoint.proceed();

        }catch (Throwable e){
            System.out.println("Time Monitor Error");
        }
        finally {
            long endTime = System.currentTimeMillis();

            long totalTime = endTime - startTime;

            System.out.println("Total time in milliseconds: " + totalTime+"ms..");

        }



    }

}
