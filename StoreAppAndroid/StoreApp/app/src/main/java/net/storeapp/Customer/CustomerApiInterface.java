package net.storeapp.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CustomerApiInterface {
    @GET("getCustomer")
    Call<List<Customer>> getCustomer();

    @POST("addCustomer")
    Call<Customer> addCustomer(@Body Customer Customer);

    @POST("updateCustomer")
    Call<Customer> updateCustomer(@Body Customer Customer);

    @POST("deleteCustomer")
    Call<Customer> deleteCustomer(@Query("id") int id);

    @POST("getCustomerById")
    Call<Customer> getCustomerById(@Query("id") int id);

}