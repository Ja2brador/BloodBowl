package com.example.ja2brador.bloodbowl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bbsrc.equipos.Equipo;

public class MainMenu extends AppCompatActivity {

    private static ArrayList<Equipo> equipos;
    private static String fileteams;
    private static Context cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        fileteams = "teams.bb";
        cont = this;
        try {
            FileInputStream fis = this.openFileInput(fileteams);
            ObjectInput input = new ObjectInputStream(fis);
            try {
                equipos = (ArrayList<Equipo>) input.readObject();
            } finally {
                fis.close();
                input.close();
            }
        } catch (ClassNotFoundException | IOException | IllegalArgumentException ex) {
            equipos = new ArrayList<>();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    public static ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void teams(View view) {
        Intent i = new Intent(this, TeamsMenu.class);
        startActivity(i);
    }

    public void match(View view) {

    }

    public void onStop() {
        super.onStop();
        guardarEquipos();
    }

    public static void guardarEquipos() {

        try {
            FileOutputStream file = cont.openFileOutput(fileteams, Context.MODE_PRIVATE);
            ObjectOutput output = new ObjectOutputStream(file);
            try {
                output.writeObject(equipos);
            } finally {
                output.close();
                file.close();
            }
        } catch (IOException ignored) {
        }

    }

}
