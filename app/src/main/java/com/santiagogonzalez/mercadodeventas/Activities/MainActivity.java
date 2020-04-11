package com.santiagogonzalez.mercadodeventas.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.santiagogonzalez.mercadodeventas.Fragments.ListaProductosFragment;
import com.santiagogonzalez.mercadodeventas.R;

public class MainActivity extends AppCompatActivity implements ListaProductosFragment.OnFragmentInteractionListener{

    ListaProductosFragment myListaProductoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListaProductoFragment = new ListaProductosFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.MainActivity_FrameLayout_ContenedorDeFragments, myListaProductoFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
