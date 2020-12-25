package hibernate_one_to_many_bi.practise;

import hibernate_one_to_many_bi.practise.io.Output;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        StandardUI ui = context.getBean("ui", StandardUI.class);
        try {
            ui.menu();
        } catch (Exception e) {
            context.getBean("consoleOutput", Output.class).out(e.getMessage());
        } finally {
            context.close();
        }
    }
}
