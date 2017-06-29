package com.studios.patota.homecontrol;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class UsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        Datos da  = new Datos(this);
        SQLiteDatabase sq = da.getWritableDatabase();
        RelativeLayout imgf = (RelativeLayout) findViewById(R.id.activity_usuarios);
        imgf.setBackgroundResource(R.drawable.fondomenu);

        Cursor c = sq.rawQuery("select * from usuarios",null);
        ArrayList<HashMap<String,String>> lista =
                new ArrayList<>();
        if(c!=null){
            if(c.moveToFirst()){
                do{
                    String nom = c.getString(c.getColumnIndex("nombre"));
                    String cor = c.getString(c.getColumnIndex("correo"));
                    HashMap <String,String> map = new HashMap<>();
                    map.put("nomb",nom);
                    map.put("corr",cor);
                    lista.add(map);
                }while(c.moveToNext());
                ListAdapter listado = new SimpleAdapter(this,lista,
                        R.layout.item_usuarios,
                        new String[]{"nomb","corr"},
                        new int[]{R.id.tvNombre,R.id.tvCorreo});
                final ListView lUsuarios = (ListView)findViewById(R.id.lstUsuarios);
                lUsuarios.setAdapter(listado);
                lUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        HashMap<String,String> opcionseleccionada =
                                (HashMap<String,String>)lUsuarios.getItemAtPosition(i);
                        Bundle bundle = new Bundle();
                        bundle.putString("vnombre",opcionseleccionada.get("nomb"));
                        bundle.putString("vcorreo",opcionseleccionada.get("corr"));
                        Intent intent = new Intent(UsuariosActivity.this,MainActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        }

    }
}
