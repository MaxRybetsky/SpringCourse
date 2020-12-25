package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.entity.Student;
import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import hibernate_one_to_many_bi.practise.Session;
import org.springframework.stereotype.Component;

@Component("showStudentAction")
public class ShowStudentInfoAction extends AbstractAction {
    public ShowStudentInfoAction(Session session, Input input, Output output) {
        super(session, input, output);
    }

    @Override
    public void action() {
        getOutput().out("Enter student id: ");
        int id = getInput().readInt();
        Student student = getSession().get(Student.class, id);
        if (student == null) {
            getOutput().out("There is no such student in our data base. Try again.");
            return;
        }
        getOutput().out(student);
        getOutput().out("School of student:");
        getOutput().out(student.getSchool());
    }
}
