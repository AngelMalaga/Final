package com.studios.patota.homecontrol;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alumno-JG on 14/06/2017.
 */

public class Datos extends SQLiteOpenHelper {

    public Datos(Context context) {
        super(context,"tienda",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table usuarios(nombre text,correo text) ");
    }

    public void agregarusuario(Datos db,String nom,String corr){
        SQLiteDatabase sq =db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre",nom);
        cv.put("correo",corr);
        sq.insert("usuarios",null,cv);
    }

    public void actualizarusuario(Datos db,String nom,String corr){
        SQLiteDatabase sq =db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String consulta = "correo like ?";
        String arg[] = {corr};
        cv.put("nombre",nom);
        sq.update("usuarios",cv,consulta,arg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
