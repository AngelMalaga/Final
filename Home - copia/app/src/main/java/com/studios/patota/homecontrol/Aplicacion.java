package com.studios.patota.homecontrol;

import android.app.Application;
import android.hardware.Sensor;

/**
 * Created by AMC on 12/06/2017.
 */

public class Aplicacion extends Application {

    private String usuario;

    public String getUsuario(){

        return  usuario;
    }
    public void setUsuario(String usuario){

        this.usuario=usuario;
    }
}
