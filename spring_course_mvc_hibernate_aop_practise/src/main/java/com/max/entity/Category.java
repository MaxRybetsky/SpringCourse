package com.max.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "category",
            fetch = FetchType.LAZY)
    private List<Good> goods;

    /**
     * Adds new good to the category.
     *
     * @param good Good to add.
     * @return true if a good was sucessfully
     * added to category, otherwise - false.
     */
    public boolean addGood(Good good) {
        if (goods == null) {
            goods = new ArrayList<>();
        }
        return goods.add(good);
    }
}
