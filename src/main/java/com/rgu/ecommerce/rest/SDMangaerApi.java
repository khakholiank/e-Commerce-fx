package com.rgu.ecommerce.rest;

import com.rgu.ecommerce.model.DeliveryTime;
import com.rgu.ecommerce.model.Order;
import com.rgu.ecommerce.model.OrderItem;
import com.rgu.ecommerce.model.Product;
import com.rgu.ecommerce.model.PromoCode;
import com.rgu.ecommerce.model.Stock;
import com.rgu.ecommerce.model.User;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;





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
    
    @GET("odreritem/id/{id}")
    public Call<List<OrderItem>> getOrderItemsByOrderId(@Path("id") int id);
    
    @GET("order/user/{id}")
    public Call<List<Order>> getOrdersByBuyerId(@Path("id") int id);
    
    @GET("deliverytime/all")
    public Call<List<DeliveryTime>> getAllDeliveryTime();
    
    
    //--------------------POST API S--------------------
    
    @POST("product/add")
    public Call<Product> addProduct(@Body Product p);
    
    @POST("promocode/add")
    public Call<PromoCode> addPromoCode(@Body PromoCode pc);
    
    @POST("stock/add")
    public Call<Stock> addStocks(@Body Stock s);
    
    @POST("deliverytime/add")
    public Call<DeliveryTime> addDeliveryTime(@Body DeliveryTime dt);
}