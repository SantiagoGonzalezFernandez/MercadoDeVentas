package com.santiagogonzalez.mercadodeventas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.santiagogonzalez.mercadodeventas.Fragments.ListaProductosFragment;
import com.santiagogonzalez.mercadodeventas.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout myDrawerLayout = findViewById(R.id.MainActivity_DrawerLayout_Parent);

        findViewById(R.id.MainActivity_ImageView_Menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView myNavigationView = findViewById(R.id.MainActivity_NavigationView_NavegadorDePantallas);
        myNavigationView.setItemIconTintList(null);

        NavController myNavController = Navigation.findNavController(this,R.id.MainActivity_fragment_navHostFragment);
        NavigationUI.setupWithNavController(myNavigationView, myNavController);
    }

}
