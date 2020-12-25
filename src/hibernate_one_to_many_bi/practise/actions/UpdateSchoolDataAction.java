package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.entity.School;
import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import hibernate_one_to_many_bi.practise.Session;
import org.springframework.stereotype.Component;

@Component("updateSchoolAction")
public class UpdateSchoolDataAction extends AbstractAction {
    public UpdateSchoolDataAction(Session session, Input input, Output output) {
        super(session, input, output);
    }

    @Override
    public void action() {
        getOutput().out("Enter school id: ");
        int id = getInput().readInt();
        School school = getSession().get(School.class, id);
        if (school == null) {
            getOutput().out("There is no such school in our data base. Try again.");
            return;
        }
        getOutput().out("Enter new name: ");
        String newName = getInput().readString();
        school.setName(newName);
    }
}
