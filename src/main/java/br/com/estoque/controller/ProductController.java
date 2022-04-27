package br.com.estoque.controller;

import br.com.estoque.config.BaseService;
import br.com.estoque.model.DTO.ProductDTO;
import br.com.estoque.model.Product;
import br.com.estoque.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> saveProduto (@RequestBody ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findProduct (@PathVariable Integer id){
        Product product = productService.searchProduct(id);
        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> alterProduct (@PathVariable Integer id, @RequestBody ProductDTO productDTO){
        Product productAlt = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok().body(productAlt);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deletaProduto(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> listarProducts(){
        List<Product> products = productService.listProducts();
        return products;
    }

}
