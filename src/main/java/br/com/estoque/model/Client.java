package br.com.estoque.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "client")
	private Set<Demand> demands;

	@NonNull
	private String name_client;

	private String address;

	@NonNull
	private String cpf;

	public Client() {
		super();
	}

	public Client(Integer id, Set<Demand> demands, @NonNull String name_client, String address, @NonNull String cpf) {
		super();
		this.id = id;
		this.demands = demands;
		this.name_client = name_client;
		this.address = address;
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

}
