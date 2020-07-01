package net.storeapp.Supplier;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SupplierApiInterface {
    @GET("getSupplier")
    Call<List<Supplier>> getSupplier();

    @POST("addSupplier")
    Call<Supplier> addSupplier(@Body Supplier Supplier);

    @POST("updateSupplier")
    Call<Supplier> updateSupplier(@Body Supplier Supplier);

    @POST("deleteSupplier")
    Call<Supplier> deleteSupplier(@Query("id") int id);

    @POST("getSupplierById")
    Call<Supplier> getSupplierById(@Query("id") int id);

}