package de.romankoutny.rest.client.jsonservicegetname;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetNameAPI
{

    @GET("name/{name}")
    Call<NameClientContainer> loadName(@Path("name") String name);
    
    // Call<NameClientContainer> loadName(@Query("q") String status);

}
