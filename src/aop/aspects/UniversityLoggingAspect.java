package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: log before getting list of students.");
    }

    @AfterReturning(pointcut = "execution(* getStudents())",
    returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        Student first = students.get(0);
        first.setName("Mr. " + first.getName());
        System.out.println("afterReturningGetStudentsLoggingAdvice: log after getting " +
                "list of students.");
    }

}
