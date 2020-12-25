package hibernate_one_to_many_bi.practise.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("menu")
public class MenuList {
    List<MenuItem> menu;

    @Autowired
    public MenuList(List<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            sb.append(i)
                    .append(". ")
                    .append(menu.get(i).desc())
                    .append("\n");
        }
        return sb.toString();
    }

    public MenuItem get(int item) {
        return menu.get(item);
    }
}
