package com.example.demo.ServiceI;

import com.example.demo.Model.Product;

public interface productService {

	Product insertProduct(Product product);

	Product searchProduct(String pName);

}
