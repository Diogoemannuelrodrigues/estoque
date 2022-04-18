package br.com.estoque.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nameProduct;
    @Column
    private int weightProdut;

    public Product() {
    }

    public Product(Integer id, String nameProdut, int weightProdut) {
        this.id = id;
        this.nameProduct = nameProdut;
        this.weightProdut = weightProdut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
