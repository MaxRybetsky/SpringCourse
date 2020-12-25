package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("updateSchool")
@Order(70)
public class UpdateSchoolInfo extends AbstractMenuItem {
    @Autowired
    public UpdateSchoolInfo(@Qualifier("updateSchoolAction") Action itemAction) {
        super("Update school info by id", itemAction);
    }
}
