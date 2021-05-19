package com.example.baitaptuan8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,pw,mail;
    private SQLiteConnector sqLiteConnector;
    private User user;
    private final AppCompatActivity activity = MainActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sqLiteConnector = new SQLiteConnector(activity);
        user = new User();
        name = findViewById(R.id.txtUser);
        pw = findViewById(R.id.txtPw);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btndk = (Button) findViewById(R.id.button2);
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSiginup =new Intent(getApplicationContext(),signup.class);
                startActivity(intentSiginup);




            }
        });



        Button btndn = (Button) findViewById(R.id.button);
        btndn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                boolean check = sqLiteConnector.checkUser(name.getText().toString().trim(),pw.getText().toString().trim());
                if (check == true) //nếu user tồn tại, thì cho đăng nhập vào phần hiển thị thông tin người dùng
                {
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.activity_main2);
                    //dialog.setCancelable(false);
                    dialog.show();
                }
                else {
                    Toast.makeText(MainActivity.this,"invalid", Toast.LENGTH_LONG).show();
                }

            }

        });
    }
}