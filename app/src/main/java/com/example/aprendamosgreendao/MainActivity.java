package com.example.aprendamosgreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aprendamosgreendao.models.db.DaoHelper;

public class MainActivity extends AppCompatActivity {


    private DaoHelper daoHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creaBaseDeDatos();
    }

    private void creaBaseDeDatos(){
        try{

            daoHelper = DaoHelper.getSingleton();
            daoHelper.init(MainActivity.this, "acodigo_db");

        }catch (Exception e){
            Log.d("Error en: ", e.getMessage());
        }
    }

    private void addUser(){




    }




}
