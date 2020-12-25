package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("showSchool")
@Order(50)
public class ShowSchoolInfo extends AbstractMenuItem {
    @Autowired
    public ShowSchoolInfo(@Qualifier("showSchoolAction") Action itemAction) {
        super("Show school info by id", itemAction);
    }
}
