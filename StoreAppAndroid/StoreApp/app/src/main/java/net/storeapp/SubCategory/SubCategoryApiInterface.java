package net.storeapp.SubCategory;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SubCategoryApiInterface {
    @GET("getSubCategory")
    Call<List<SubCategory>> getSubCategory();

    @POST("addSubCategory")
    Call<SubCategory> addSubCategory(@Body SubCategory SubCategory);

    @POST("updateSubCategory")
    Call<SubCategory> updateSubCategory(@Body SubCategory SubCategory);

    @POST("deleteSubCategory")
    Call<SubCategory> deleteSubCategory(@Query("id") int id);

    @POST("getSubCategoryById")
    Call<SubCategory> getSubCategoryById(@Query("id") int id);
}