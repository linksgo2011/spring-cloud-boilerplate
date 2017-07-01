package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RefreshScope
@RestController
@SpringBootApplication
public class ServiceProductApplication {

    @RequestMapping("/categories")
    List<Category> categories() {

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Arrays.asList(
                new Category(1, "T-Shirt"),
                new Category(2, "Mobile Phone"),
                new Category(3, "Food"));
    }

    @Value("${service.hello}")
    private String hello;

    @RequestMapping("/helloword")
    public String hello(){
        return hello;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceProductApplication.class, args);
    }
}

class Category {
    private Integer id;
    private String categoryName;

    public Category() {
    }

    public Category(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}