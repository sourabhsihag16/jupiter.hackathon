package com.jupiter.jupiter.hackathon.controller;

import com.jupiter.jupiter.hackathon.dao.ProductDao;
import com.jupiter.jupiter.hackathon.entity.Product;

import com.jupiter.jupiter.hackathon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@EnableCaching
public class APIController {

    @Autowired
    private ProductDao productDao;
    @Autowired private ProductRepository productRepository;

    @GetMapping(value = "/getValues")
    @Cacheable(value="Product")
    public List<Product> getValues(){
        return productRepository.findAll();
    }
    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "Product")
    public Optional<Product> findProduct(@PathVariable int id) {
        System.out.println("find by ID");
        return productRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "Product")
    public String remove(@PathVariable int id) {
         productRepository.deleteById(id);
         return "deleteById";
    }

    @PostMapping(value = "/setValues")
    public ResponseEntity create(@RequestBody Product entity){
        productRepository.save(entity);
        return  ResponseEntity.ok().build();
    }
    @GetMapping(value = "/getFromCache")
    public List<Product> getFromCache(){
        return  productDao.getAllProductsFromCache();
    }
    @DeleteMapping(value = "/deleteAll/")
    public String deleteFromCache(@PathVariable int id){
        return productDao.deleteProduct(id);
    }
}
