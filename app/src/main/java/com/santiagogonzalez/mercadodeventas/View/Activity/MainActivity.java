package com.santiagogonzalez.mercadodeventas.View.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.santiagogonzalez.mercadodeventas.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuroNavigationView();

    }

    private void configuroNavigationView() {
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

        final TextView myFinalTextViewTitle = findViewById(R.id.MainActivity_TextView_TextTitle);

        myNavController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                myFinalTextViewTitle.setText(destination.getLabel());
            }
        });
    }
}
