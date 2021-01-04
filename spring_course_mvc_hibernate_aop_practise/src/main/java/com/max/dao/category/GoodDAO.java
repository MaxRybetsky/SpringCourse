package com.max.dao.category;

import com.max.entity.Good;

public interface GoodDAO {
    void delete(int id);

    void save(Good good);
}
