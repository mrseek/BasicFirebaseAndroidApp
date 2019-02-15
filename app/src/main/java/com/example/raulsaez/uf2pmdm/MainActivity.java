package com.example.raulsaez.uf2pmdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //Declaración de las variables que vamos a necesitar, tanto las que vamos a enviar como las asociadas a los campos donde el usuario introducirá sus datos.
    String matricula, marca, color;
    EditText etMatricula;
    EditText etMarca;
    EditText etColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void introducirDatos(View v){

        //Pasamos los datos necesarios desde el textbox a la variable y después a la variable que será la encargada de subirlos a Firebase
        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etMarca = (EditText)findViewById(R.id.etMarca);
        etColor = (EditText)findViewById(R.id.etColor);

        matricula = etMatricula.getText().toString();
        marca = etMarca.getText().toString();
        color = etColor.getText().toString();

        // Comprobamos que se han introducido los tres datos, sino entra en else
        if(matricula.trim().length() == 0 || matricula == null || marca.trim().length() == 0 || marca == null || color.trim().length() == 0 || color == null){

            Toast.makeText(this, "Debes completar todos los campos", Toast.LENGTH_SHORT).show();

        }else{

            //Creamos la estructura de nuestra base de datos Firebase de la siguinte forma
            Datos Datos = new Datos (matricula, marca, color);
            DatabaseReference dbRoot = FirebaseDatabase.getInstance().getReference();

            Map<String, Object> map = new HashMap<>();
            map.put(Datos.getMatricula(),"");
            dbRoot.updateChildren(map);

            // Estos serían los que van por debajo en el arbol de la base de datos.
            DatabaseReference dbMatricula = dbRoot.child(matricula);
            Map<String, Object> map2 = new HashMap<>();
            map2.put("MARCA", marca);
            map2.put("COLOR", color);
            dbMatricula.updateChildren(map2);


            /*Intent intent = new Intent(packageContent(this), MainActivity.class);
            startActivity(intent);
            finish();*/
        }
    }
}
