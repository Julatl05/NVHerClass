package com.example.herclass;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AdminHome extends AppCompatActivity {
    EditText etMain, etPassword, etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        setContentView(R.layout.activity_admin_home);
        etMain = findViewById(R.id.etMain);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);

        etMain.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Tampoco aquí
            }
            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();

                // Llenamos los otros campos automáticamente
                etPassword.setText(input + "123");
                etEmail.setText(input + "@email.com");
            }
        });
    }
}