package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.entity.Student;
import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import hibernate_one_to_many_bi.practise.Session;
import org.springframework.stereotype.Component;

@Component("deleteStudentAction")
public class DeleteStudentAction extends AbstractAction {
    public DeleteStudentAction(Session session, Input input, Output output) {
        super(session, input, output);
    }

    @Override
    public void action() {
        getOutput().out("Enter student's id to delete");
        int id = getInput().readInt();
        Student student = getSession().get(Student.class, id);
        if (student == null) {
            getOutput().out("There is no such school in our data base. Try again.");
            return;
        }
        getSession().delete(student);
    }
}
