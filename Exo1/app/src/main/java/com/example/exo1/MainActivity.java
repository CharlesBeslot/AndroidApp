package com.example.exo1;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int CODE_RES=1;
    private static  final String MA_SUPER_CLEF ="valeur";
    private static  int Cpt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String val="";
        if((savedInstanceState != null) && savedInstanceState.containsKey(MA_SUPER_CLEF)){
             val = savedInstanceState.getString(MA_SUPER_CLEF);
        }
        setContentView(R.layout.activity_main);
        Toast.makeText(this,val,Toast.LENGTH_SHORT).show();
        Button button = (Button) findViewById(R.id.valider);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.nom);
                String nom = name.getText().toString();
                EditText firstname = (EditText)findViewById(R.id.prenom);
                String prenom = firstname.getText().toString();
                EditText number = (EditText)findViewById(R.id.phone);
                String phone = number.getText().toString();

                Intent intent = new Intent(MainActivity.this, page2.class);
                intent.setDataAndType(Uri.parse("content://contacts"), ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                intent.putExtra("nom",nom);
                intent.putExtra("prenom",prenom);
                intent.putExtra("phone",phone);
                startActivityForResult(intent,CODE_RES);
            }
        });
        Button addCpt = (Button)findViewById(R.id.addCompteur);
        addCpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtCpt = (TextView)findViewById(R.id.txt_Cpt);
                txtCpt.setText(String.valueOf(Cpt++));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_RES) {
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "Action validée", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, page2.class);
                    startActivity(intent);
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Action refusée", Toast.LENGTH_LONG).show();
                    break;
                default:
                    Toast.makeText(this, "Action error", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(MA_SUPER_CLEF,"coucou");
        Toast.makeText(this,"save",Toast.LENGTH_SHORT).show();
    }
}
