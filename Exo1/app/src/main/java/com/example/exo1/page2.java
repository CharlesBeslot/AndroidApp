package com.example.exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class page2 extends AppCompatActivity {
    private  static ArrayList<String> contact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Intent intent = getIntent();
        String nom = "";
        String prenom = "";
        String phone="";
        if (intent.hasExtra("nom")){
            nom = intent.getStringExtra("nom");
        }
        if (intent.hasExtra("prenom")){
            prenom = intent.getStringExtra("prenom");
        }
        if (intent.hasExtra("phone")){
            phone = intent.getStringExtra("phone");
        }
        contact.add(nom+" "+prenom+" "+ phone);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contact);
        ListView listView = (ListView)findViewById(R.id.myListNom);
        listView.setAdapter(adapter);
    }

}
