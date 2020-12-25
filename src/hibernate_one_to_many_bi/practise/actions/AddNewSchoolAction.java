package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.Session;
import hibernate_one_to_many_bi.practise.entity.School;
import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import org.springframework.stereotype.Component;

@Component("addSchoolAction")
public class AddNewSchoolAction extends AbstractAction {
    public AddNewSchoolAction(Session session, Input input, Output output) {
        super(session, input, output);
    }

    @Override
    public void action() {
        getOutput().out("Enter School's name: ");
        String name = super.getInput().readString();
        super.getSession().save(new School(name));
    }
}
