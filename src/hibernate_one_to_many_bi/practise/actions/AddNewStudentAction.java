package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.Session;
import hibernate_one_to_many_bi.practise.entity.School;
import hibernate_one_to_many_bi.practise.entity.Student;
import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import org.springframework.stereotype.Component;

@Component("addStudentAction")
public class AddNewStudentAction extends AbstractAction {
    public AddNewStudentAction(Session session, Input input, Output output) {
        super(session, input, output);
    }

    @Override
    public void action() {
        getOutput().out("Enter name: ");
        String name = super.getInput().readString();
        super.getOutput().out("Enter student's mark:");
        int mark = super.getInput().readInt();
        super.getOutput().out("Enter student's school:");
        int schoolID = super.getInput().readInt();
        School school = getSession().get(School.class, schoolID);
        while (school == null) {
            getOutput().out("There is no such school in our data base. Try again:");
            schoolID = super.getInput().readInt();
            school = getSession().get(School.class, schoolID);
        }
        Student student = new Student(name, mark);
        student.setSchool(school);
        super.getSession().save(student);
    }
}
