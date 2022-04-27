package br.com.estoque.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "demand")
public class Demand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(name = "demand_product",
            joinColumns =  @JoinColumn (name = "demand_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "shoppingCar_id")
    private ShoppingCar shopping;
    
    private boolean budget;

    public Double getCalculateTotalCar(){
        Double total = null;
        for (Product product: products) {
            total+=product.getPrice();
        }
        return total;
    }

}
