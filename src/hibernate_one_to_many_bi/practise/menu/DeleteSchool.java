package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("deleteSchool")
@Order(90)
public class DeleteSchool extends AbstractMenuItem {
    @Autowired
    public DeleteSchool(@Qualifier("deleteSchoolAction") Action itemAction) {
        super("Delete school by id", itemAction);
    }
}
