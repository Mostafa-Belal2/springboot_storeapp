package net.storeapp.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CategoryApiInterface {
    @GET("getCategory")
    Call<List<Category>> getCategory();

    @POST("addCategory")
    Call<Category> addCategory(@Body Category category);

    @POST("updateCategory")
    Call<Category> updateCategory(@Body Category category);

    @POST("deleteCategory")
    Call<Category> deleteCategory(@Query("id") int id);

    @POST("getCategoryById")
    Call<Category> getCategoryById(@Query("id") int id);

    @POST("getCategoryByName")
    Call<Category> getCategoryByName(@Query("name") String name);

}