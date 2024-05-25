package com.ecom.webstore.global;

import com.ecom.webstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart=new ArrayList<Product>();

    }
}
