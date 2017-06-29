package com.studios.patota.homecontrol;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivityOpciones extends AppCompatActivity {
    Button btnSalir;
    TextView listex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_opciones);
        LinearLayout imgf = (LinearLayout) findViewById(R.id.fondoOpc);
        imgf.setBackgroundResource(R.drawable.fondomenu);
        setTitle("OPCIONES");


        listex = (TextView) findViewById(R.id.Titulo);


        String font_path = "font/ufonts.com_futura-condensed-medium.ttf";                                                                                 //donde tiene que buscar ) de nuetra fuente

        Typeface TF = Typeface.createFromAsset(getAssets(),font_path);

        listex.setTypeface(TF);



    }





    public void Salir(View view)
    {

        finish();
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
}
