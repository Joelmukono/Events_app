package com.joel.events.interfaces;

import com.joel.events.EventsSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventsApi {
    @GET("categories")
    Call<EventsSearchResponse> getCategories(
            @Query("name") String name
    );
}
