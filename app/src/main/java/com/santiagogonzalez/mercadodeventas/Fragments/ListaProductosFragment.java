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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaProductosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaProductosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaProductosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView myRecyclerViewProductos;
    ArrayList<ProductoInfo> myArratListListaDeProductos;

    public ListaProductosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaProductosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaProductosFragment newInstance(String param1, String param2) {
        ListaProductosFragment fragment = new ListaProductosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
