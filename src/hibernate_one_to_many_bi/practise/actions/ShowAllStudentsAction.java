package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import hibernate_one_to_many_bi.practise.Session;
import org.springframework.stereotype.Component;

@Component("showStudentsAction")
public class ShowAllStudentsAction extends AbstractAction {
    public ShowAllStudentsAction(Session session, Input input, Output output) {
        super(session, input, output);
    }

    @Override
    public void action() {
        super.getOutput().out(super.getSession().createQuery("from Student").getResultList());
    }
}
