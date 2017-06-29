package com.studios.patota.homecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityHomeMenu extends AppCompatActivity {

    LinearLayout imgf;
    String manda;
    ListView menuCon;
    String[] opciones = new String[]{
            "Luz","Puertas","Computadoras","Electrodomesticos","Opciones","Invetario","Seguridad"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_menu);
        imgf = (LinearLayout) findViewById(R.id.fondoMenu);
        imgf.setBackgroundResource(R.drawable.fondomenu);
        Bundle bundle = getIntent().getExtras();
        manda = bundle.getString("Ls");
        menuCon = (ListView) findViewById(R.id.menu);
        setTitle("HOME MENU");


       final ArrayList<HashMap<String, String>> arl = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("Ls");
        ListAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones);

        menuCon.setAdapter(adaptador);


        menuCon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                String valor = menuCon.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), valor, Toast.LENGTH_SHORT).show();
                Bundle datos = new Bundle();
                datos.putString("Op", manda);

                Intent intent;
                switch (valor) {
                    case "Luz":
                        intent = new Intent(MainActivityHomeMenu.this,MainActivityLuz.class);
                        intent.putExtras(datos);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;

                    case "Puertas":
                         intent = new Intent(MainActivityHomeMenu.this, MainActivityPuertas.class);
                        intent.putExtras(datos);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;



                    case "Computadoras":
                         intent = new Intent(MainActivityHomeMenu.this, MainActivityComputadoras.class);
                       intent.putExtra("Op1",arl);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;


                    case "Electrodomesticos":
                         intent = new Intent(MainActivityHomeMenu.this, MainActivityElectro.class);
                        intent.putExtras(datos);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;



                    case "Opciones":
                         intent = new Intent(MainActivityHomeMenu.this, MainActivityOpciones.class);
                        intent.putExtras(datos);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;


                    case "Invetario":
                         intent = new Intent(MainActivityHomeMenu.this, MainActivityInventario.class);
                        intent.putExtras(datos);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;


                    case "Seguridad":
                         intent = new Intent(MainActivityHomeMenu.this, MainActivitySeguridad.class);
                        intent.putExtras(datos);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
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
