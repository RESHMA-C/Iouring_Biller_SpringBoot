package com.example.iouring_demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.iouring_demo.ProductRecord;
import com.example.iouring_demo.ProductService;
import com.example.iouring_demo.BillRecord;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;
    private User user;

    @RequestMapping("/user/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRecord> getAllProducts()
    {
        return productService.getAllProducts();
    }
    @RequestMapping(value="/user/search", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRecord> searchProducts(@RequestParam(required = false) String code,@RequestParam(required = false) String name) {
        List<ProductRecord> prodRecords = productService.searchProducts(code, name);
            return prodRecords;
    }
    @RequestMapping(value="/user/bill", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void generateBill(@RequestBody List<BillRecord> billRecords, HttpServletResponse response) throws IOException {
        float totalAmount=0;
        for (BillRecord billrecord:billRecords) {
            String prodCode = billrecord.getProdCode();
            int quantity=billrecord.getQuantity();
            List<ProductRecord> prodRecords= productService.searchProd(prodCode);
            if(!prodRecords.isEmpty()) {
                ProductRecord prodRecord = prodRecords.get(0);
                float price = prodRecord.getProductPrice();
                float gst = prodRecord.getProductGst();
                float amount=quantity * (price + ((gst / price) * 100));
                totalAmount=totalAmount+amount;
                response.getWriter().println("Prod code: "+prodCode+" Tax: "+gst+" Amount: "+amount);
            }
            else
                response.getWriter().println(" Item: "+prodCode+" not Found");
        }
        response.getWriter().println(" Total Amount: "+totalAmount);
    }

    @RequestMapping(value="/add-product", method=RequestMethod.POST)
    public void addProduct(@RequestBody ProductRecord productRecord)
    {
        productService.addProduct(productRecord);
    }
}