package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import hibernate_one_to_many_bi.practise.Session;
import org.springframework.stereotype.Component;

@Component("showSchoolsAction")
public class ShowAllSchoolsAction extends AbstractAction {
    public ShowAllSchoolsAction(Session session, Input input, Output output) {
        super(session, input, output);
    }

    @Override
    public void action() {
        System.out.println("in action");
        super.getOutput().out(super.getSession().createQuery("from School").getResultList());
    }
}
