package com.santiagogonzalez.mercadodeventas.View.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.santiagogonzalez.mercadodeventas.Model.Producto;
import com.santiagogonzalez.mercadodeventas.Model.ProductoResults;
import com.santiagogonzalez.mercadodeventas.R;
import com.santiagogonzalez.mercadodeventas.Service.MercadoLibreApi;
import com.santiagogonzalez.mercadodeventas.View.Adapter.ProductosAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaProductosFragment extends Fragment {

    private static final String TAG = "MERCADODEVENTAS";

    private Retrofit myRetrofit;

    private RecyclerView myRecyclerViewProductos;
    private ProductosAdapter myProductosAdapter;

    private Integer myIntegerOffset;

    private boolean myBooleanAptoParaCargar;

    private ImageButton myImageButtonSearch;
    private EditText myEditTextSearch;

    private String myStringProductoBuscado;

    public ListaProductosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_lista_productos,container,false);

        encontrarComponentesPorId(myView);

        configurarRecyclerView();

        configuroBotonSearch();

        configuroRetrofit();

        return myView;
    }

    private void configuroRetrofit() {
        myRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myBooleanAptoParaCargar = true;
        myIntegerOffset = 0 ;
    }

    private void configuroBotonSearch() {
        myImageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myStringProductoBuscado = myEditTextSearch.getText().toString();

                obtenerDatos(myIntegerOffset,myStringProductoBuscado);
            }
        });
    }

    private void configurarRecyclerView() {
        myProductosAdapter = new ProductosAdapter(getContext());
        myRecyclerViewProductos.setAdapter(myProductosAdapter);
        final LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(getContext());
        myRecyclerViewProductos.setLayoutManager(myLinearLayoutManager);

        myRecyclerViewProductos.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0){
                    Integer myIntegerVisibleItemCount = myLinearLayoutManager.getChildCount();
                    Integer myIntegerTotalItemCount = myLinearLayoutManager.getItemCount();
                    Integer myIntegerPastVisibleItems = myLinearLayoutManager.findFirstVisibleItemPosition();

                    if (myBooleanAptoParaCargar){
                        if ((myIntegerVisibleItemCount + myIntegerPastVisibleItems) >= myIntegerTotalItemCount){
                            Log.i(TAG, "Llegamos al final del RecyclerView.");

                            myBooleanAptoParaCargar = false;
                            myIntegerOffset += 30;
                            agregarDatos(myIntegerOffset);
                        }
                    }

                }
            }
        });
    }

    public void encontrarComponentesPorId(View myView){
        myImageButtonSearch = myView.findViewById(R.id.ListaProductosFragments_ImageButton_SearchBoton);
        myEditTextSearch = myView.findViewById(R.id.ListaProductosFragments_EditText_SearchEditText);
        myRecyclerViewProductos = myView.findViewById(R.id.ListaProductosFragments_RecyclerView_ListaDeProductos);
    }

    private void obtenerDatos(Integer myIntegerOffset, String myStringQuery) {
        MercadoLibreApi myMercadoLibreApi = myRetrofit.create(MercadoLibreApi.class);
        Call<ProductoResults> myCallProductoResults = myMercadoLibreApi.obtenerListaProductosPorBusqueda(myStringQuery, 30, myIntegerOffset);

        myCallProductoResults.enqueue(new Callback<ProductoResults>() {
            @Override
            public void onResponse(Call<ProductoResults> call, Response<ProductoResults> response) {
                myBooleanAptoParaCargar = true;
                if(response.isSuccessful()){
                    ProductoResults myProductoResults = response.body();
                    ArrayList<Producto> myProductoArrayList = myProductoResults.getResults();

                    myProductosAdapter.setMyArrayListDeProductos(myProductoArrayList);

                }else{
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ProductoResults> call, Throwable t) {
                myBooleanAptoParaCargar = true;
                Log.e(TAG, "onFailure: "+ t.getMessage());
            }
        });
    }

    private void agregarDatos(Integer myIntegerOffset) {
        MercadoLibreApi myMercadoLibreApi = myRetrofit.create(MercadoLibreApi.class);
        Call<ProductoResults> myCallProductoResults = myMercadoLibreApi.obtenerListaProductosPorBusqueda(myStringProductoBuscado, 30, myIntegerOffset);

        myCallProductoResults.enqueue(new Callback<ProductoResults>() {
            @Override
            public void onResponse(Call<ProductoResults> call, Response<ProductoResults> response) {
                myBooleanAptoParaCargar = true;
                if(response.isSuccessful()){
                    ProductoResults myProductoResults = response.body();
                    ArrayList<Producto> myProductoArrayList = myProductoResults.getResults();

                    myProductosAdapter.adicionarListaProductos(myProductoArrayList);

                }else{
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ProductoResults> call, Throwable t) {
                myBooleanAptoParaCargar = true;
                Log.e(TAG, "onFailure: "+ t.getMessage());
            }
        });
    }

}
