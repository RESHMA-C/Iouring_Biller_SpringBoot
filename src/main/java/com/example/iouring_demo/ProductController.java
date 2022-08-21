package com.example.iouring_demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.iouring_demo.ProductRecord;
import com.example.iouring_demo.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRecord> getAllProducts()
    {
        return productService.getAllProducts();
    }
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String searchProducts(@RequestParam(required = false) String code,@RequestParam(required = false) String name) {
        List<ProductRecord> prodRecords = productService.searchProducts(code, name);
        if (!prodRecords.isEmpty()) {
            ProductRecord prodRecord = prodRecords.get(0);
            return "Product Code: " + prodRecord.getProductCode() + " Product Name:" + prodRecord.getProductName() + " Product Price:" + prodRecord.getProductPrice() + " Product GST:" + prodRecord.getProductGst();
        } else
            return "Item not found";
    }
    @RequestMapping(value="/bill", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String generateBill(@RequestParam(required = false) String code,@RequestParam(required = false) String name,@RequestParam int quantity) {
        List<ProductRecord> prodRecords= productService.searchProducts(code,name);
        if(!prodRecords.isEmpty()) {
            ProductRecord prodRecord = prodRecords.get(0);
            float price = prodRecord.getProductPrice();
            float gst = prodRecord.getProductGst();
            return "Price: "+price+"Gst %: "+gst+"Total Amount: " + quantity * (price + ((gst / price) * 100));
        }
        else
            return "Item not Found";
    }
    @RequestMapping(value="/add-product", method=RequestMethod.POST)
    public void addProduct(@RequestBody ProductRecord productRecord)
    {
        productService.addProduct(productRecord);
    }
}