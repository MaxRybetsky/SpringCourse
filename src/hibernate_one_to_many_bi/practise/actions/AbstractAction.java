package hibernate_one_to_many_bi.practise.actions;

import hibernate_one_to_many_bi.practise.Session;
import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractAction implements Action {
    private Session session;
    private Input input;
    private Output output;

    @Autowired
    public AbstractAction(Session session, Input input, Output output) {
        this.session = session;
        this.input = input;
        this.output = output;
    }

    public Session getSession() {
        return session;
    }

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }

    public void startTransaction() {
        session.beginTransaction();
    }

    public void endTransaction() {
        if (session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().commit();
        }
        output.out("Changes committed");
    }
}
