package hibernate_one_to_many_bi.practise.menu;

import hibernate_one_to_many_bi.practise.actions.Action;

public abstract class AbstractMenuItem implements MenuItem {
    private String message = "";
    private Action itemAction;

    public AbstractMenuItem(String message, Action itemAction) {
        this.message = message;
        this.itemAction = itemAction;
    }

    @Override
    public String desc() {
        return message;
    }

    @Override
    public boolean action() {
        System.out.println("in menu");
        itemAction.action();
        return true;
    }
}
