package com.santiagogonzalez.mercadodeventas.View.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.santiagogonzalez.mercadodeventas.Model.Producto;
import com.santiagogonzalez.mercadodeventas.R;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> {

    private ArrayList<Producto> myArrayListDeProductos;
    private Dialog myDialog;
    private Context myContext;

    public ProductosAdapter(Context myContext) {
        this.myContext = myContext;
        myArrayListDeProductos = new ArrayList<>();
    }

    public ProductosAdapter(ArrayList<Producto> myArrayListDeProductos){
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

               myTextViewNombreDelProducto.setText(myArrayListDeProductos.get(myProductoViewHolder.getAdapterPosition()).getMyStringTitulo());
               myTextViewPrecioDelProducto.setText("$" + myArrayListDeProductos.get(myProductoViewHolder.getAdapterPosition()).getMyDoublePrecio());

               Glide.with(myContext)
                       .load(myArrayListDeProductos.get(myProductoViewHolder.getAdapterPosition()).getMyStringImagen())
                       .diskCacheStrategy(DiskCacheStrategy.ALL)
                       .into(myImageViewImagenDelProducto);

               myDialog.show();
           }
       });

       return myProductoViewHolder;
    }

    public void onBindViewHolder(ProductoViewHolder holder, int position){
          holder.myTextViewNombreDelProducto.setText(myArrayListDeProductos.get(position).getMyStringTitulo());
          holder.myTextViewPrecioDelProducto.setText("$" + myArrayListDeProductos.get(position).getMyDoublePrecio());

        Glide.with(myContext)
                .load(myArrayListDeProductos.get(position).getMyStringImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.myImageViewImagenDelProducto);
    }

    public int getItemCount(){
        return myArrayListDeProductos.size();
    }

    public void adicionarListaProductos(ArrayList<Producto> myProductoArrayList) {
        myArrayListDeProductos.addAll(myProductoArrayList);
        notifyDataSetChanged();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout myLinearLayoutCeldaDelProducto;
        private TextView myTextViewNombreDelProducto;
        private TextView myTextViewPrecioDelProducto;
        private ImageView myImageViewImagenDelProducto;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            myLinearLayoutCeldaDelProducto = itemView.findViewById(R.id.ItemList_LinearLayout_Parent);
            myTextViewNombreDelProducto = itemView.findViewById(R.id.ItemList_TextView_NombreDelProducto);
            myTextViewPrecioDelProducto = itemView.findViewById(R.id.ItemList_TextView_PrecioDelProducto);
            myImageViewImagenDelProducto = itemView.findViewById(R.id.ItemList_ImageView_ImagenDelProducto);
        }
    }
}
