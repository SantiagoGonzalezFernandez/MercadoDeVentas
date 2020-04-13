package com.santiagogonzalez.mercadodeventas.Service;

import com.santiagogonzalez.mercadodeventas.Model.ProductoResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MercadoLibreApi {

    @GET("sites/MLA/search")
    Call<ProductoResults> obtenerListaProductosPorBusqueda(@Query("q") String myStringQuery ,
                                                           @Query("limit") Integer myIntegerLimit,
                                                           @Query("offset") Integer myIntegerOffset);
}
