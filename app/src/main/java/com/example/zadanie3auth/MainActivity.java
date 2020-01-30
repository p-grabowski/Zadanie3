package com.example.zadanie3auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText user, passwd;
    Button batton1;
    Auth[] Users = new Auth[5];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.mainEtUsername);
        passwd = findViewById(R.id.mainEtPasswd);
        batton1 = findViewById(R.id.mainBtSubmit);// polaczenie do id



        Users[0] = new Auth("user1","test1",true);
        Users[1] = new Auth("user2","test2",false);
        Users[2] = new Auth("user3","test3",false);
        Users[3] = new Auth("user4","test4",true);
        Users[4] = new Auth("user5","test5",false);//dodani uzytkownicy  admin range t/f

        batton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameS = user.getText().toString();// get text - pobiera tekst z klawiatury
                String passwdS= passwd.getText().toString();
                for(int i=0; i<Users.length; i++) {//pentl sspr users
                    //Log.d("for", "Value: " + i);
                    //Log.d("Users", "" + usernameS + " - " + passwdS);
                    if (Users[i].checkPass(usernameS, passwdS)){
                        //Log.d("login", "Value: " + Users[i].checkPass(usernameS, passwdS));
                        Toast.makeText(MainActivity.this, "zalogowano", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, AfterLoginActivity.class);
                        intent.putExtra("username", Users[i].Username);
                        if(Users[i].isAdmin){ intent.putExtra("isadmin", "Admin");}
                        else{ intent.putExtra("isadmin", "User");}
                        startActivity(intent);
                        finish();
                        break;
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Bledny username lub password", Toast.LENGTH_SHORT).show();
                        passwd.setText(null);
                    }
                }
            }
        });
    }
}