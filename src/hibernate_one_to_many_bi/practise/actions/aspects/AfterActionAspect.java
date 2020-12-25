package hibernate_one_to_many_bi.practise.actions.aspects;

import hibernate_one_to_many_bi.practise.actions.AbstractAction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterActionAspect {
    @After("hibernate_one_to_many_bi.practise.actions.aspects.MyPointcut.allActionMethodsInActionPackage()")
    public void endTransaction(JoinPoint joinPoint) {
        System.out.println("End transaction");
        Object obj = joinPoint.getTarget();
        if (obj instanceof AbstractAction) {
            AbstractAction action = (AbstractAction) obj;
            action.endTransaction();
        }
    }
}
