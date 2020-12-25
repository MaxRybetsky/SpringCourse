package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("addSchool")
@Order(10)
public class AddNewSchool extends AbstractMenuItem {
    @Autowired
    public AddNewSchool(@Qualifier("addSchoolAction")Action itemAction) {
        super("Add new school", itemAction);
    }
}
