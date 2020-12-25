package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("deleteStudent")
@Order(100)
public class DeleteStudent extends AbstractMenuItem {
    @Autowired
    public DeleteStudent(@Qualifier("deleteStudentAction") Action itemAction) {
        super("Delete student by id", itemAction);
    }
}
