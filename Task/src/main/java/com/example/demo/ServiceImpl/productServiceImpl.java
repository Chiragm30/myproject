package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Model.Product;
import com.example.demo.ServiceI.productService;
import com.example.demo.repository.productRepository;

@Service
public class productServiceImpl implements productService {

	@Autowired
	productRepository pr;
	
	@Override
	public Product insertProduct(Product product) {
		
		return pr.save(product);
	}

	@Override
	public Product searchProduct(String proname) {
		Product srp = pr.findByproname(proname);
		if(srp!=null)
		{
			return srp;
		}
		else {
			throw new ProductNotFoundException("Product Not Found");
		}
	}

}
