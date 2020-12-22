package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CofigViaAnnotations {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        person.printInfo();
        Cat cat = context.getBean("catBean", Cat.class);
        cat.say();
        context.close();
    }
}
