package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("updateStudent")
@Order(80)
public class UpdateStudentInfo extends AbstractMenuItem {
    @Autowired
    public UpdateStudentInfo(@Qualifier("updateStudentAction") Action itemAction) {
        super("Update student info by id", itemAction);
    }
}
