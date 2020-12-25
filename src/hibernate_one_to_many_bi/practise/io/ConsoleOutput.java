package hibernate_one_to_many_bi.practise.io;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("consoleOutput")
public class ConsoleOutput implements Output {
    @Override
    public void out(Object o) {
        System.out.println(o);
    }

    @Override
    public void out(List<Object> objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }
}
