package com.shoes.backend.Entity;

import com.shoes.backend.Entity.Base.Item;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "brands")
@Data
public class Brand extends Item {
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Shoes> shoes;
}
