package br.com.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import br.com.estoque.model.Product;
import br.com.estoque.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product searchProduct(Integer idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        return product.orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Integer idProd) {
        productRepository.deleteById(idProd);
    }

    public Product alterProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }

}
