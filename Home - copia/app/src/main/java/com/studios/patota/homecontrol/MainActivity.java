package com.studios.patota.homecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tNombre, tCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tNombre = (EditText)findViewById(R.id.txtNombre);
        tCorreo = (EditText)findViewById(R.id.txtCorreo);
        if(getIntent().getExtras()!=null){
            Bundle datosRecibidos = getIntent().getExtras();
            tNombre.setText(datosRecibidos.getString("vnombre"));
            tCorreo.setText(datosRecibidos.getString("vcorreo"));

            LinearLayout imgf = (LinearLayout) findViewById(R.id.activity_main);
            imgf.setBackgroundResource(R.drawable.fondomenu);
        }

    }

    public void registrar(View view) {
        Datos da = new Datos(this);
        da.agregarusuario(da,tNombre.getText().toString(),
                tCorreo.getText().toString());
        Toast.makeText(this,"Registrado",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,UsuariosActivity.class);
        startActivity(intent);
    }

    public void actualizar(View view) {
        Datos da = new Datos(this);
        da.actualizarusuario(da,tNombre.getText().toString(),
                tCorreo.getText().toString());
        Toast.makeText(this,"Actualizado",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,UsuariosActivity.class);
        startActivity(intent);
    }
}
