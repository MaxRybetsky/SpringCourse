package hibernate_one_to_many_bi.practise.actions.aspects;

import hibernate_one_to_many_bi.practise.actions.AbstractAction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeActionAspect {
    @Before("hibernate_one_to_many_bi.practise.actions.aspects.MyPointcut.allActionMethodsInActionPackage()")
    public void beginTransaction(JoinPoint joinPoint) {
        System.out.println("Start transaction");
        Object obj = joinPoint.getTarget();
        if (obj instanceof AbstractAction) {
            AbstractAction action = (AbstractAction) obj;
            action.startTransaction();
        }
    }
}
