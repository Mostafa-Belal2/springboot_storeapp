package net.storeapp.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApiInterface {
    @GET("getUser")
    Call<List<User>> getUser();

    @POST("addUser")
    Call<User> addUser(@Body User User);

    @POST("updateUser")
    Call<User> updateUser(@Body User User);

    @POST("deleteUser")
    Call<User> deleteUser(@Query("id") int id);

    @POST("getUserById")
    Call<User> getUserById(@Query("id") int id);

}