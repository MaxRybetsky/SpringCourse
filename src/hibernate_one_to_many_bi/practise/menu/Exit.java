package hibernate_one_to_many_bi.practise.menu;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component("exit")
@Order(110)
public class Exit extends AbstractMenuItem {
    public Exit() {
        super("Exit", null);
    }

    @Override
    public boolean action() {
        return false;
    }
}
