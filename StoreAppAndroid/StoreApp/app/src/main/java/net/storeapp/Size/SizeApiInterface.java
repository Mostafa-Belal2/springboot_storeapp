package net.storeapp.Size;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SizeApiInterface {
    @GET("getSize")
    Call<List<Size>> getSize();

    @POST("addSize")
    Call<Size> addSize(@Body Size Size);

    @POST("updateSize")
    Call<Size> updateSize(@Body Size Size);

    @POST("deleteSize")
    Call<Size> deleteSize(@Query("id") int id);

    @POST("getSizeById")
    Call<Size> getSizeById(@Query("id") int id);

}