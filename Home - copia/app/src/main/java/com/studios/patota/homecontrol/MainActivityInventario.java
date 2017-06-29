package com.studios.patota.homecontrol;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityInventario extends AppCompatActivity {
    String[] opciones = new String[]{
            "Pollo","Papa","Lechuga","Leche","Atun ","Huevo","Agua"
    };
    TextView listex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inventario);
        LinearLayout imgf = (LinearLayout) findViewById(R.id.fondoInv);
        imgf.setBackgroundResource(R.drawable.fondomenu);
        setTitle("INVENTARIO");



        listex = (TextView) findViewById(R.id.Titulo);


        String font_path = "font/ufonts.com_futura-condensed-medium.ttf";                                                                                 //donde tiene que buscar ) de nuetra fuente

        Typeface TF = Typeface.createFromAsset(getAssets(),font_path);

        listex.setTypeface(TF);




        final ListView menuCon = (ListView) findViewById(R.id.menuInv);

        ListAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones);

        menuCon.setAdapter(adaptador);


        menuCon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                String valor = menuCon.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), valor, Toast.LENGTH_SHORT).show();
                Bundle datos = new Bundle();
                datos.putString("Op", valor);

                Intent intent;
                switch (valor) {
                    case "Comedor":
                        // intent = new Intent(MainActivityLuz.this,MainActivityLuz.class);
                        //intent.putExtras(datos);
                        //startActivity(intent);
                        break;

                    case "Sala":

                        break;



                    case "Cocina":

                        break;


                    case "Baños":

                        break;



                    case "Cuartos":

                        break;


                    case "Cochera":

                        break;


                    case "Exterior":

                        break;

                }

            }


        });
    }
    public void Salir(View view)
    {
        finish();
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
}
