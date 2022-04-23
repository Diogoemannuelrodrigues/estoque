package br.com.estoque.exceptions;

import br.com.estoque.model.Product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String s) {
    }
}
