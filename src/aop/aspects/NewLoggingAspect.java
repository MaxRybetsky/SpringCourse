package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(* returnBook())")
    public Object aroundReturnBookAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookAdvice: пытаемся вернуть книгу");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookAdvice: было поймано исключение " + e);
            throw e;
        }
        System.out.println("aroundReturnBookAdvice: успешно вернули книгу");
        return result;
    }
}
