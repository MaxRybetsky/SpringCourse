package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());
        System.out.println("beforeAddLoggingAdvice: логируем получение книги/журнала.");
        if ("addBook".equals(methodSignature.getName())) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book book = (Book) obj;
                    System.out.println("Информация о книге: ");
                    System.out.println("название - " + book.getName());
                    System.out.println("автор - " + book.getAuthor());
                    System.out.println("год издания - " + book.getYear());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }
        System.out.println("-------------------------------");
    }


//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary() {
//    }
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary() {
//    }
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineFromUniLibrary() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineFromUniLibrary: write in Log #10");
//    }


//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethods() {
//    }
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethods() {
//    }
//
//    @Pointcut("allGetMethods() || allReturnMethods()")
//    private void allGetAndReturnMethods() {
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: write Log #1");
//    }
//
//    @Before("allReturnMethods()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: write Log #2");
//    }
//
//    @Before("allGetAndReturnMethods()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: write Log #3");
//    }
}
