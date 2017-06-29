package com.studios.patota.homecontrol;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivityComputadoras extends AppCompatActivity {
   // String manda;
   // String[] opciones = new String[]{
     //       "P1","P2","P3","P4","P5","P6"
    //};
   //
   TextView listex;
    ListView menuCon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_computadoras);
        LinearLayout imgf = (LinearLayout) findViewById(R.id.fondoCom);
        imgf.setBackgroundResource(R.drawable.fondomenu);
        setTitle("COMPUTADORAS LOCALES");


        listex = (TextView) findViewById(R.id.Titulo);


        String font_path = "font/ufonts.com_futura-condensed-medium.ttf";                                                                                 //donde tiene que buscar ) de nuetra fuente

        Typeface TF = Typeface.createFromAsset(getAssets(),font_path);

        listex.setTypeface(TF);
        //Bundle bundle = getIntent().getExtras();
       // manda = bundle.getString("Op");
      ArrayList<HashMap<String, String>> arl = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("Op1");
       // opciones2.add(manda);
        menuCon = (ListView) findViewById(R.id.menuCom);
     setTitle("home");








       // ListAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arl);
        ListAdapter adaptador = new SimpleAdapter(this, arl,R.layout.item_categoria, new String[]{"pc","nom"},new int[]{R.id.txtCodigo,R.id.txtNombre});
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
                    case "P1":
                        // intent = new Intent(MainActivityLuz.this,MainActivityLuz.class);
                        //intent.putExtras(datos);
                        //startActivity(intent);
                        break;

                    case "P2":

                        break;
                    case "P3":

                        break;

                    case "P4":

                        break;

                    case "P5":

                        break;

                    case "P6":

                        break;



                }

            }


        });
    }

    public void add(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }

    public void Salir(View view)
    {
        finish();
        menuCon.setAdapter(null);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
}
