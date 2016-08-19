package com.alosatriani.mascotasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alosatriani.mascotasapp.Utileria.SendMail;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    public void enviarcorreo(View v){

        EditText etNombre = (EditText)findViewById(R.id.etNombre);
        EditText etCorreo = (EditText)findViewById(R.id.etEmail);
        EditText etComentario = (EditText)findViewById(R.id.etComentario);

        //Toast.makeText(getBaseContext(),"enviando correo: "+etNombre.getText(),Toast.LENGTH_SHORT).show();
        SendMail sm = new SendMail(this, etCorreo.getText().toString(), "Mensaje de: " + etNombre.getText().toString(),
                etComentario.getText().toString());

        //Executing sendmail to send email
        sm.execute();
//
    }
}
