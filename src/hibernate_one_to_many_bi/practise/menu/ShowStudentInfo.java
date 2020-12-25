package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("showStudent")
@Order(60)
public class ShowStudentInfo extends AbstractMenuItem {
    @Autowired
    public ShowStudentInfo(@Qualifier("showStudentAction") Action itemAction) {
        super("Show student info by id", itemAction);
    }
}
