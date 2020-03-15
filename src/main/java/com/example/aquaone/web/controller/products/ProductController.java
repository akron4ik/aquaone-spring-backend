package com.example.aquaone.web.controller.products;

import com.example.aquaone.View;
import com.example.aquaone.model.Product;
import com.example.aquaone.service.category.CategoryService;
import com.example.aquaone.service.product.ProductService;
import com.example.aquaone.to.MessageTo;
import com.example.aquaone.util.SendEmailUtil;
import com.example.aquaone.web.controller.products.AbstractProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController extends AbstractProductController {

    @Autowired
    ProductService service;

    @Autowired
    CategoryService categoryService;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/cart", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductsInCart(@RequestBody Integer[] values){
        List<Product> products = new ArrayList<>();
        for (Integer id: values) {
           products.add(service.get(id));
        }
        return products;
    }

    @GetMapping(value = "/categories/{id}")
    public List<Product> getProductByCategoryId(@PathVariable(required = false) Integer id){
        if (id != null && id != 4) {
            return service.getByCategoryId(id);
        }
        return service.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Product get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendMessage(@Validated(View.Web.class) @RequestBody MessageTo messageTo){
        SendEmailUtil sendEmailUtil = new SendEmailUtil();
        sendEmailUtil.createAndSendMessage(messageTo.getName(), messageTo.getEmail(), messageTo.getText());
        return "Success";
    }
}
