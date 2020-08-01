package com.example.fragmentmascotas;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {
    TextInputEditText nombre;
    TextInputEditText email;
    TextInputEditText mensaje;
    Button botonEnviar;
    Intent intent;
    private Toolbar toolbar;
    Session sesion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombre = findViewById(R.id.etNombre);
        email = findViewById(R.id.etEmail);
        mensaje = findViewById(R.id.etMensaje);
        botonEnviar = findViewById(R.id.botonEnviar);
        toolbar = findViewById(R.id.miActionBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String nombrestr = nombre.getText().toString();
        final String emailstr = email.getText().toString();
        final String mensajestr = mensaje.getText().toString();
        final String contra = "ingles450";

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDatos();
                if(validarDatos()){
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    Properties properties = new Properties();
                    properties.put("mail.smtp.host","smtp.googlemail.com");
                    properties.put("mail.smtp.socketFactory.port","465");
                    properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                    properties.put("mail.smtp.auth","true");
                    properties.put("mail.smtp.port","465");

//                    Toast.makeText(Contacto.this,"Enviado",Toast.LENGTH_LONG).show();
                    Toast.makeText(Contacto.this,email.getText().toString(),Toast.LENGTH_LONG).show();

                    try {
                        sesion = Session.getDefaultInstance(properties, new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("correitodepruebita2@gmail.com",contra);
                            }
                        });
                        System.out.println(emailstr);
                        if(sesion!=null){
                            MimeMessage message = new MimeMessage(sesion);
                            //Quien envía el correo
                            message.setFrom(new InternetAddress(email.getText().toString()));
                            //Llenamos el asunto
                            message.setSubject("Mensaje de: "+nombre.getText().toString());
                            //A quien va dirigido
                            message.addRecipient(Message.RecipientType.TO, new InternetAddress("pruebaimapredes@gmail.com"));
                         //  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("correitodepruebita2@gmail.com"));
                            //Ponemos el mensaje
                            message.setContent(mensaje.getText().toString(),"text/html;charset=utf-8");
                            Transport.send(message);
                        }
//                        sesion.setDebug(true);
                        //Enviamos el mensaje
/*                        Transport t = sesion.getTransport("smtp");
                        t.connect(emailstr,"ingles450");
                        t.sendMessage(message,message.getAllRecipients());
                        t.close();*/
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public boolean validarNombre(String nombrev){
        Pattern patron = Pattern.compile("[a-zA-Z ]+");
        if(!patron.matcher(nombrev).matches()){
            nombre.setError("Nombre Inválido");
            return false;
        }else
        return true;
    }

    public boolean validarEmail(String emailv){
        if(!Patterns.EMAIL_ADDRESS.matcher(emailv).matches()){
            email.setError("Email Inválido");
            return false;
        }else
            return true;
    }

    public boolean validarDatos(){
        String nombreV = nombre.getEditableText().toString();
        String emailV = email.getEditableText().toString();
        boolean nom =validarNombre(nombreV);
        boolean emai = validarEmail(emailV);
        if(nom&&emai){
            return true;
        }else
            return false;
    }
}
