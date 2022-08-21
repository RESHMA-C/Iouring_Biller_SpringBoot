package com.example.iouring_demo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.zip.DeflaterOutputStream;

@Entity
@Table(name = "product")
public class ProductRecord
{
    @Id
    //@Column(name="productCode")
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String productCode;
    private String productName;
    private float productPrice;
    private float productGst;

    //default conatructor

    public ProductRecord()
    {
    }
    public String getProductCode()
    {
        return productCode;
    }
    public void setProduct_code(String productCode)
    {
        this.productCode=productCode;
    }
    public String getProductName()
    {
        return productName;
    }
    public void setProduct_name(String productName)
    {
        this.productName = productName;
    }
    public float getProductPrice()
    {
        return productPrice;
    }
    public void setProduct_price(float productPrice)
    {
        this.productPrice = productPrice;
    }
    public float getProductGst()
    {
        return productGst;
    }
    public void setProduct_gst(float productGst)
    {
        this.productGst=productGst;
    }
}
