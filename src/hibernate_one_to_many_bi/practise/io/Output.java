package hibernate_one_to_many_bi.practise.io;

import java.util.List;

public interface Output {
    void out(Object o);

    void out(List<Object> objects);
}
