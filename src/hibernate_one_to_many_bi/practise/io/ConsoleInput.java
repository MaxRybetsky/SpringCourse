package hibernate_one_to_many_bi.practise.io;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("consoleInput")
public class ConsoleInput implements Input {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String readString() {
        return sc.nextLine();
    }

    @Override
    public int readInt() {
        return Integer.parseInt(readString());
    }
}
