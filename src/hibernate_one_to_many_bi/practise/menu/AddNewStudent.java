package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("addStudent")
@Order(20)
public class AddNewStudent extends AbstractMenuItem {
    @Autowired
    public AddNewStudent(@Qualifier("addStudentAction") Action itemAction) {
        super("Add new student", itemAction);
    }
}
