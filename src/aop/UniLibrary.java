package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {
    public void getBook() {
        System.out.println("Книга получена из UniLibrary!");
        System.out.println("-------------------------------");
    }

    public void returnBook() {
        System.out.println("Книга возвращена в UniLibrary!");
        System.out.println("-------------------------------");
    }

    public void getMagazine() {
        System.out.println("Журнал получен из UniLibrary!");
        System.out.println("-------------------------------");
    }

    public void returnMagazine() {
        System.out.println("Журнал возвращен в UniLibrary!");
        System.out.println("-------------------------------");
    }

    public void addBook(String name, Book book) {
        System.out.println("Книга добавлена в UniLibrary!");
        System.out.println("-------------------------------");
    }

    public void addMagazine() {
        System.out.println("Журнал добавлен в UniLibrary!");
        System.out.println("-------------------------------");
    }
}
