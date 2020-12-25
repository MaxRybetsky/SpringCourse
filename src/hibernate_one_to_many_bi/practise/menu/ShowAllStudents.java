package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("showStudents")
@Order(40)
public class ShowAllStudents extends AbstractMenuItem {
    @Autowired
    public ShowAllStudents(@Qualifier("showStudentsAction") Action itemAction) {
        super("Show all students", itemAction);
    }
}
