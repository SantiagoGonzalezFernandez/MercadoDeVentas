package com.santiagogonzalez.mercadodeventas.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santiagogonzalez.mercadodeventas.Clases.ProductoInfo;
import com.santiagogonzalez.mercadodeventas.R;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> {

    ArrayList<ProductoInfo> myArrayListDeProductos;

    public ProductosAdapter(ArrayList<ProductoInfo> myArrayListDeProductos){
        this.myArrayListDeProductos = myArrayListDeProductos;
    }

    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
       return new ProductoViewHolder(view);
    }

    public void onBindViewHolder(ProductoViewHolder holder, int position){
          holder.myTextViewNombreDelProducto.setText(myArrayListDeProductos.get(position).getMyStringNombreDelProducto());
          holder.myTextViewPrecioDelProducto.setText(myArrayListDeProductos.get(position).getMyStringPrecioDelProducto());
          holder.myImageViewImagenDelProducto.setImageResource(myArrayListDeProductos.get(position).getMyIntImagenDelProducto());
    }

    public int getItemCount(){
        return myArrayListDeProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder{
        TextView myTextViewNombreDelProducto;
        TextView myTextViewPrecioDelProducto;
        ImageView myImageViewImagenDelProducto;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextViewNombreDelProducto = itemView.findViewById(R.id.ItemList_TextView_NombreDelProducto);
            myTextViewPrecioDelProducto = itemView.findViewById(R.id.ItemList_TextView_PrecioDelProducto);
            myImageViewImagenDelProducto = itemView.findViewById(R.id.ItemList_ImageView_ImagenDelProducto);
        }
    }
}
