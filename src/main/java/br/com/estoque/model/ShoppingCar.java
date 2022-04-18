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
@Table(name = "shoppingCar")
public class ShoppingCar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne(mappedBy = "shopping")
	private Demand demand;

	@ManyToMany(mappedBy = "shoppingCars")
	private Set<Product> productSet;

}
