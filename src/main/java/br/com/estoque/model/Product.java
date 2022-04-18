package br.com.estoque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nameProduct;
    @Column
    private int weightProdut;

    @ManyToMany(mappedBy = "products")
    private Set<Demand> demands;

    @ManyToMany
    @JoinTable(name = "product_shoppingCar",
            joinColumns =  @JoinColumn (name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "shoppingCar_id"))
    private Set<ShoppingCar> shoppingCars;

}
