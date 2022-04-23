package br.com.estoque.service;

import br.com.estoque.config.BaseService;
import br.com.estoque.exceptions.ProductNotFoundException;
import br.com.estoque.model.DTO.ProductDTO;
import br.com.estoque.model.Product;
import br.com.estoque.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService extends BaseService {

    @Autowired
    private ProductRepository productRepository;
    private Object ProductDTO;

    public Product searchProduct(Integer idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        return product.orElse(null);
    }

    public Product saveProduct(ProductDTO productDTO){
        return productRepository.save(getConverter().map(productDTO, Product.class));
    }

    public void deleteProduct(Integer idProd) {
        productRepository.deleteById(idProd);
    }

    public Product updateProduct(Integer id, ProductDTO productDTO) {
        Optional<Product> productFound = productRepository.findById(id);
        if(productFound.isPresent()){
            productFound.get().setNameProduct(productDTO.getNameProduct());
            productFound.get().setPrice(productDTO.getPrice());
            productFound.get().setDescriptions(productDTO.getDescriptions());
            productFound.get().setWeightProdut(productDTO.getWeightProdut());
            log.info("{}, ", productFound);
            return productRepository.save(productFound.get());
        }
        throw new ProductNotFoundException("Product not found");
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

}
