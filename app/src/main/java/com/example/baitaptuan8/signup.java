package com.example.baitaptuan8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitaptuan8.SQLiteConnector;
import com.example.baitaptuan8.User;

public class signup extends AppCompatActivity {

    EditText name,pw,mail;
    private SQLiteConnector sqLiteConnector;
    private final AppCompatActivity activity = signup.this;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sqLiteConnector = new SQLiteConnector(activity);
        user = new User();
        name = findViewById(R.id.txtbUsersigup);
        pw = findViewById(R.id.txtbPwsigup);
        mail = findViewById(R.id.txtbEmail);

        Button btndangky = (Button) findViewById(R.id.btndangky);
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sqLiteConnector.checkUser(mail.getText().toString()))
                {
                    user.setName(name.getText().toString().trim());
                    user.setPassword(pw.getText().toString().trim());

                    user.setEmail(mail.getText().toString().trim());
                    sqLiteConnector.addUser(user);//thêm user vào sqli
                    Toast.makeText(signup.this,"đăng kí thành công", Toast.LENGTH_LONG).show();
                }
                else // hiển thị lỗi khi email đã được đăng kí
                    Toast.makeText(signup.this,"đăng kí thất bại, email exist", Toast.LENGTH_LONG).show();
            }
        });

    }
}