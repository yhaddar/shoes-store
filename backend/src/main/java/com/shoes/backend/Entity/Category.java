package com.shoes.backend.Entity;

import com.shoes.backend.Entity.Base.Item;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table(name = "category")
@Entity
public class Category extends Item {
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Shoes> shoes;
}
