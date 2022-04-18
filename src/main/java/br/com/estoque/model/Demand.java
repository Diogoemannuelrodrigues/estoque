package br.com.estoque.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "demand")
public class Demand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
    
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "demand")
    private ShoppingCar shopping;
    
    private boolean budget;

    public Demand() {
    }

    public Demand(Integer idDemand, Client idClient, ShoppingCar shopping, boolean budget) {
        this.id = idDemand;
        this.client = idClient;
        this.shopping = shopping;
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ShoppingCar getShopping() {
        return shopping;
    }

    public void setShopping(ShoppingCar shopping) {
        this.shopping = shopping;
    }

    public boolean isBudget() {
        return budget;
    }

    public void setBudget(boolean budget) {
        this.budget = budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demand demand = (Demand) o;
        return id.equals(demand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
