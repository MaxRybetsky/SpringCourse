package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("showSchools")
@Order(30)
public class ShowAllSchools extends AbstractMenuItem {
    @Autowired
    public ShowAllSchools(@Qualifier("showSchoolsAction") Action itemAction) {
        super("Show all schools", itemAction);
    }
}
