package br.com.estoque.controller;

import br.com.estoque.model.Product;
import br.com.estoque.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Start controller products")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Save started") })
    public ResponseEntity<Void> saveProduto (@RequestBody Product product){
        Product newproduct = productService.saveProduct(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getIdProdut())
                .toUri();
        log.info("Saving {} to database", product);
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findProduct (@PathVariable Integer id){
        Product product = productService.searchProduct(id);
        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Update started") })
    public ResponseEntity<Product> alterProduct (@RequestBody Product product){
        Product productAlt = productService.alterProduct(product);
        return ResponseEntity.ok().body(productAlt);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_ACCEPTED, message = "Delete started") })
    public ResponseEntity<Product> deletaProduto(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> listarClientes(){
        List<Product> products = productService.listProducts();
        return products;
    }

}
