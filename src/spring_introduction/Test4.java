package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Pet pet1 = context.getBean("myPet", Pet.class);
        Pet pet2 = context.getBean("myPet", Pet.class);
        Pet pet3 = context.getBean("myPet", Pet.class);
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);
        context.close();
    }
}
