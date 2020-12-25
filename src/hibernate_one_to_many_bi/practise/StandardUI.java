package hibernate_one_to_many_bi.practise;

import hibernate_one_to_many_bi.practise.io.Input;
import hibernate_one_to_many_bi.practise.io.Output;
import hibernate_one_to_many_bi.practise.menu.MenuList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ui")
public class StandardUI {
    private Input input;
    private Output output;
    private MenuList menu;

    @Autowired
    public StandardUI(@Qualifier("consoleInput") Input input,
                      @Qualifier("consoleOutput") Output output,
                      @Qualifier("menu") MenuList menu) {
        this.input = input;
        this.output = output;
        this.menu = menu;
    }

    public void menu() {
        boolean f = true;
        while (f) {
            output.out(menu);
            int item = input.readInt();
            f = menu.get(item).action();
            System.out.println("in menu");
        }
    }
}
