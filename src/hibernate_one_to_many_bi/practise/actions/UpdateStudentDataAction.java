package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.entity.School;
import hibernate_one_to_many_bi.practise.entity.Student;
import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import hibernate_one_to_many_bi.practise.Session;
import org.springframework.stereotype.Component;

@Component("updateStudentAction")
public class UpdateStudentDataAction extends AbstractAction {
    public UpdateStudentDataAction(Session session, Input input, Output output) {
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
        getOutput().out("Enter new student's name: ");
        String newName = getInput().readString();
        getOutput().out("Enter new student's mark: ");
        int mark = getInput().readInt();
        student.setName(newName);
        student.setMark(mark);
    }
}
