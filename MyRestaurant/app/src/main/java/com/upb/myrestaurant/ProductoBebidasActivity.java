package com.upb.myrestaurant;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ProductoBebidasActivity extends ListActivity {

    public class Producto {
        private String nombreProducto;

        private String ingredientesProducto;

        private String precioProducto;

        private Integer imagenProducto;
    }

    private MyAdapter adaptador =null;

    private static ArrayList <Producto> arregloProductos = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adaptador = new MyAdapter (this);
        setData();
        setListAdapter (adaptador);
        //setContentView(R.layout.activity_producto);
    }

    private void setData(){

        arregloProductos.clear();


        // Bebida 1
        Producto productoActual1 = new Producto();
        productoActual1.nombreProducto = this.getResources().getString(R.string.bebida1);
        productoActual1.ingredientesProducto = this.getResources().getString(R.string.ing_bebida1);
        productoActual1.precioProducto = this.getResources().getString(R.string.prec_bebida1);
        productoActual1.imagenProducto = R.drawable.jugos;
        arregloProductos.add(productoActual1);

        // Bebida 2
        Producto productoActual2 = new Producto();
        productoActual2.nombreProducto = this.getResources().getString(R.string.bebida2);
        productoActual2.ingredientesProducto = this.getResources().getString(R.string.ing_bebida2);
        productoActual2.precioProducto = this.getResources().getString(R.string.prec_bebida2);
        productoActual2.imagenProducto = R.drawable.gaseosas;
        arregloProductos.add(productoActual2);

        // Bebida 3
        Producto productoActual3 = new Producto();
        productoActual3.nombreProducto = this.getResources().getString(R.string.bebida3);
        productoActual3.ingredientesProducto = this.getResources().getString(R.string.ing_bebida3);
        productoActual3.precioProducto = this.getResources().getString(R.string.prec_bebida3);
        productoActual3.imagenProducto = R.drawable.sodas;
        arregloProductos.add(productoActual3);
    }

    public static class MyAdapter extends BaseAdapter {

        private Context myContexto;

        public MyAdapter (Context c){

            myContexto = c;
        }
        @Override
        public int getCount () {
            return arregloProductos.size();
        }

        @Override
        public Object getItem (int arg){
            return arregloProductos.get(arg);
        }

        @Override
        public long getItemId(int arg){
            return 0;
        }

        @Override
        public View getView(int position, View vista, ViewGroup arg2){

            View view = null;

            if (vista == null){

                LayoutInflater inflater = (LayoutInflater) myContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_producto, null);
            }
            else{
                view = vista;
            }

            ImageView imgProducto = (ImageView) view.findViewById(R.id.imageView);
            imgProducto.setImageDrawable(myContexto.getResources().getDrawable(arregloProductos.get(position).imagenProducto));

            TextView nombreProducto = (TextView) view.findViewById(R.id.textViewNombreBe);
            nombreProducto.setText(arregloProductos.get(position).nombreProducto);

            TextView ingredientesProducto = (TextView) view.findViewById(R.id.textViewIngredientesBe);
            ingredientesProducto.setText(arregloProductos.get(position).ingredientesProducto);

            TextView precioProducto = (TextView) view.findViewById(R.id.textViewPrecioBe);
            precioProducto.setText(arregloProductos.get(position).precioProducto);

            return view;
        }
    }

}