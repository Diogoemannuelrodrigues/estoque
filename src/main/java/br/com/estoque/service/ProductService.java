package br.com.estoque.service;

import br.com.estoque.model.Product;
import br.com.estoque.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
        Optional<Product> product1 = productRepository.findById(product.getIdProdut());
        return productRepository.save(product);
    }

    public List<Product> listProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }

}
