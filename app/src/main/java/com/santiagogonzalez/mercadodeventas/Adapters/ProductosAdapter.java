package com.santiagogonzalez.mercadodeventas.Adapters;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santiagogonzalez.mercadodeventas.Clases.ProductoInfo;
import com.santiagogonzalez.mercadodeventas.R;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> {

    ArrayList<ProductoInfo> myArrayListDeProductos;
    Dialog myDialog;

    public ProductosAdapter(ArrayList<ProductoInfo> myArrayListDeProductos){
        this.myArrayListDeProductos = myArrayListDeProductos;
    }

    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
       final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
       final ProductoViewHolder myProductoViewHolder = new ProductoViewHolder(view);

       myDialog = new Dialog(view.getContext());
       myDialog.setContentView(R.layout.fragment_description_product);

       myProductoViewHolder.myLinearLayoutCeldaDelProducto.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               TextView myTextViewNombreDelProducto = myDialog.findViewById(R.id.DescriptionProductFragment_TextView_NombreDelProducto);
               TextView myTextViewPrecioDelProducto = myDialog.findViewById(R.id.DescriptionProductFragment_TextView_PrecioDelProducto);
               ImageView myImageViewImagenDelProducto = myDialog.findViewById(R.id.DescriptionProductFragment_ImageView_ImagenDelProducto);

               myTextViewNombreDelProducto.setText(myArrayListDeProductos.get(myProductoViewHolder.getAdapterPosition()).getMyStringNombreDelProducto());
               myTextViewPrecioDelProducto.setText(myArrayListDeProductos.get(myProductoViewHolder.getAdapterPosition()).getMyStringPrecioDelProducto());
               myImageViewImagenDelProducto.setImageResource(myArrayListDeProductos.get(myProductoViewHolder.getAdapterPosition()).getMyIntImagenDelProducto());

               Toast.makeText(view.getContext(), "Test Click " + String.valueOf(myProductoViewHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
               myDialog.show();
           }
       });

       return myProductoViewHolder;
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

        LinearLayout myLinearLayoutCeldaDelProducto;
        TextView myTextViewNombreDelProducto;
        TextView myTextViewPrecioDelProducto;
        ImageView myImageViewImagenDelProducto;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            myLinearLayoutCeldaDelProducto = itemView.findViewById(R.id.ItemList_LinearLayout_Parent);
            myTextViewNombreDelProducto = itemView.findViewById(R.id.ItemList_TextView_NombreDelProducto);
            myTextViewPrecioDelProducto = itemView.findViewById(R.id.ItemList_TextView_PrecioDelProducto);
            myImageViewImagenDelProducto = itemView.findViewById(R.id.ItemList_ImageView_ImagenDelProducto);
        }
    }
}
