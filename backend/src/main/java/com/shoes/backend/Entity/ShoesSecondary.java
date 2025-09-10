package com.shoes.backend.Entity;

import com.shoes.backend.Entity.Base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "shoes_secondary")
@Entity
public class ShoesSecondary extends Base {
    @ManyToOne
    @JoinColumn(name = "shoes_id")
    private Shoes shoes;

    @Column(unique = false, nullable = false)
    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    private String image;

    @NotBlank(message = "this field no should be blank")
    @NotEmpty(message = "this field no should be empty")
    @NotNull(message = "this field no should be null")
    private String color;

    @NotNull(message = "this field no should be null")
    private List<Integer> size;
}
