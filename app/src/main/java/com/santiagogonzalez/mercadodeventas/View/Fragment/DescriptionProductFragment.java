package com.santiagogonzalez.mercadodeventas.View.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santiagogonzalez.mercadodeventas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionProductFragment extends Fragment {


    public DescriptionProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description_product, container, false);
    }

}
