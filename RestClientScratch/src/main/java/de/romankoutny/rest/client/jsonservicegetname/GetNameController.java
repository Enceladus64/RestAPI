package de.romankoutny.rest.client.jsonservicegetname;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.romankoutny.rest.client.Change;
import de.romankoutny.rest.client.GerritAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetNameController implements Callback<NameClientContainer>
{
    static final String BASE_URL = "http://localhost:8888/jersey/json/";

    public void start()
    {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

        GetNameAPI api = retrofit.create(GetNameAPI.class);

        Call<NameClientContainer> call = api.loadName("SomePathParamName");
        call.enqueue(this);

    }


    @Override
    public void onResponse(Call<NameClientContainer> call, Response<NameClientContainer> response)
    {
        if(response.isSuccessful())
        {
            NameClientContainer cont = response.body();
            System.out.println("--> " + cont.name);
            System.out.println("--> " + cont.ts);
        }
        else
        {
            System.err.println(response.errorBody());
        }
        
    }

    @Override
    public void onFailure(Call<NameClientContainer> call, Throwable t)
    {
        t.printStackTrace();
    }

}
