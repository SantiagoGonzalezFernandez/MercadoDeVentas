package com.santiagogonzalez.mercadodeventas.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santiagogonzalez.mercadodeventas.Adapters.ProductosAdapter;
import com.santiagogonzalez.mercadodeventas.Clases.ProductoInfo;
import com.santiagogonzalez.mercadodeventas.R;

import java.util.ArrayList;

public class ListaProductosFragment extends Fragment {

    RecyclerView myRecyclerViewProductos;
    ArrayList<ProductoInfo> myArratListListaDeProductos;

    public ListaProductosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_lista_productos,container,false);

        myArratListListaDeProductos = new ArrayList<>();

        myRecyclerViewProductos = myView.findViewById(R.id.ListaProductosFragments_RecyclerView_ListaDeProductos);
        myRecyclerViewProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        ProductosAdapter myProductoAdapter = new ProductosAdapter(myArratListListaDeProductos);
        myRecyclerViewProductos.setAdapter(myProductoAdapter);

        return myView;
    }

    private void llenarLista() {
        myArratListListaDeProductos.add(new ProductoInfo("Pc Gamer Nueva","$45000",R.drawable.pc_gamer));
        myArratListListaDeProductos.add(new ProductoInfo("Barbijos Otakus Kawais C/U","$350",R.drawable.barbijo_anime));
        myArratListListaDeProductos.add(new ProductoInfo("Inodoro Inteligente","$120000",R.drawable.inodoro_japones));
        myArratListListaDeProductos.add(new ProductoInfo("Taza de Ban y Meliodas","$550",R.drawable.taza_meliodas));
        myArratListListaDeProductos.add(new ProductoInfo("Cuadro de cafe con frase","$1400",R.drawable.poste_de_cafe));
        myArratListListaDeProductos.add(new ProductoInfo("Vaso termino economico","$900",R.drawable.vaso_termico));
        myArratListListaDeProductos.add(new ProductoInfo("Tablet Samsung S11","$12000",R.drawable.tablet));
        myArratListListaDeProductos.add(new ProductoInfo("Smart Tv TCL Full HD","$34000",R.drawable.smart_tv));
        myArratListListaDeProductos.add(new ProductoInfo("Batidora de mesa PeaBody 600W","$25000",R.drawable.batidora_de_mesa));
        myArratListListaDeProductos.add(new ProductoInfo("Trapeador de suelo giratorio","$1700",R.drawable.trapeador));
        myArratListListaDeProductos.add(new ProductoInfo("Robot Aspirador Eufy BoostIQ RoboVac 11S","$42000",R.drawable.aspiradora_robot));
        myArratListListaDeProductos.add(new ProductoInfo("Buzo Adidas Original","$3500",R.drawable.buzo_adidas));
        myArratListListaDeProductos.add(new ProductoInfo("Reloj Rolex de Oro","$78000",R.drawable.reloj_rolex));
    }

}
