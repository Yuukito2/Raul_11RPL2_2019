package com.example.raul_11rpl2_2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button btn_Logout;
    CardView menu1;
    CardView menu2;
    static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btn_Logout = findViewById(R.id.btn_Logout);
        menu1 = (CardView)findViewById(R.id.menu1);
        menu2 = (CardView)findViewById(R.id.menu2);

        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);

        //LOGOUT
        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().clear().commit();
                Intent intent = new Intent(MainMenu.this, ControlClass.class);
                startActivity(intent);
            }
        });
        String username;
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            username = "";

        }else{
            username = extras.getString("Username");
        }

        //Menu1
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListData.class));
            }
        });

    }

}