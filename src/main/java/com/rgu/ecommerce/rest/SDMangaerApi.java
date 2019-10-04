package com.rgu.ecommerce.rest;

import com.rgu.ecommerce.model.Product;
import com.rgu.ecommerce.model.PromoCode;
import com.rgu.ecommerce.model.Stock;
import com.rgu.ecommerce.model.User;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;





public interface SDMangaerApi {

    //--------------------GET ALL API S-----------------
    
    @GET("product/all")
    public Call<List<Product>> getAllProducts();
    
    @GET("promocode/all")
    public Call<List<PromoCode>> getAllPromoCodes();
    
    @GET("user/all")
    public Call<List<User>> getAllUsers();
    
    @GET("stock/all")
    public Call<List<Stock>> getAllStocks();
    
    
    
    //--------------------POST API S--------------------
    
    @POST("product/add")
    public Call<Product> addProduct(@Body Product p);
    
    @POST("promocode/add")
    public Call<PromoCode> addPromoCode(@Body PromoCode pc);
    
    @POST("stock/add")
    public Call<Stock> addStocks(@Body Stock s);
}