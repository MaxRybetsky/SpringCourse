package hibernate_one_to_many_bi.practise.actions.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut("execution(void hibernate_one_to_many_bi.practise.actions.*.action())")
    public void allActionMethodsInActionPackage() {
    }
}
