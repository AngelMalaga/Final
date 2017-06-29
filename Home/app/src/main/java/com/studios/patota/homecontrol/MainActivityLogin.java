package com.studios.patota.homecontrol;

import android.app.Activity;
import com.loopj.android.http.*;

import android.app.Application;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.StrictMode;
import android.preference.PreferenceActivity;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.util.TextUtils;

public class MainActivityLogin extends AppCompatActivity {



    String user,Us;
    Integer clave,cl;
    LinearLayout imagen;
    EditText clav;
    EditText use;
    Bundle datos = new Bundle();
    RelativeLayout imagenfondo2,imagenfondo1;
    ArrayList<HashMap<String,String>> lista = new ArrayList<HashMap<String, String>>();
    Button btnAcep,btnSalir,btnAyuda;


    @RequiresApi(api =  Build.VERSION_CODES.JELLY_BEAN)
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        setTitle("HOME");
        imagen =(LinearLayout)findViewById(R.id.fondo);
        imagenfondo2 =(RelativeLayout)findViewById(R.id.fondo2);
        imagenfondo1 =(RelativeLayout)findViewById(R.id.fondo1);
        btnAcep =(Button)findViewById(R.id.button3);
        btnSalir =(Button) findViewById(R.id.BtnSali);
        btnAyuda =(Button) findViewById(R.id.BtnAcep);
        int[] imagenes = new int[]{
                R.drawable.home,
                R.drawable.homefont,
        };
        imagen.setBackgroundResource(imagenes[0]);
        imagenfondo2.setBackgroundResource(imagenes[1]);
        imagenfondo1.setBackgroundResource(imagenes[0]);




        String font_path = "font/ufonts.com_futura-condensed-medium.ttf";                                                                                 //donde tiene que buscar ) de nuetra fuente

        Typeface TF = Typeface.createFromAsset(getAssets(),font_path);


        btnAcep.setTypeface(TF);
        btnSalir.setTypeface(TF);
        btnAyuda.setTypeface(TF);






    }


    public void sali(View view)
    {
        finish();
    }




    public void  onclickBtn(View v){


        StrictMode.ThreadPolicy policy = new StrictMode
                .ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String ruta = "http://telacreiste.esy.es/serviciocategorias.php";
        try {
            URL url = new URL(ruta);
            HttpURLConnection urlConnection =
                    (HttpURLConnection) url.openConnection();
            //Así se establece una conexión al servidor
            InputStream inputStream =
                    new BufferedInputStream(urlConnection.getInputStream());
            //Asi se recuperan los datos
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream));
            //Se almacena los datos en Buffer de lectura
           // setTitle(bufferedReader.readLine());
            //se lee el dato




            JSONArray jsonArray =  new JSONArray(bufferedReader.readLine());
            //Los datos leidos los coloca dentro de una variable JSONArray
            //para poderlo manipular

            for(int i=0;i<=jsonArray.length()-1;i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //Se lee cada fila del jsonArray

               Us = String.valueOf(jsonObject.getString("Login"));
                cl = Integer.parseInt(jsonObject.getString("Password"));

                HashMap<String,String> map = new HashMap<>();
                map.put("pc",jsonObject.getString("Cpu"));
                map.put("nom",jsonObject.getString("UserCpu"));


                lista.add(map);



            }
         valida();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Error JSON", Toast.LENGTH_SHORT).show();
        }



    }
    public void valida(){
        Intent i;

        use =(EditText)findViewById(R.id.editText);
        clav =(EditText)findViewById(R.id.editText2);

        user = use.getText().toString().trim();
        clave = Integer.parseInt(clav.getText().toString().trim());

            if(cl == clave && Us.equals(user)){
                    i = new Intent(this, MainActivityHomeMenu.class);
                    //datos.putStringArrayList("Ls",arl);
                    //i.putExtras(datos);
                i.putExtra("Ls", lista);
                startActivity(i);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);

            }
            else{
                Toast.makeText(getApplicationContext(),"Usuario o Clave incorrecta", Toast.LENGTH_SHORT).show();
            }



    }




}
