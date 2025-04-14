package com.example.herclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class AdminHome extends AppCompatActivity {
    EditText etMain, etPassword, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_home);



        etMain = findViewById(R.id.etMain);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);

        // Agregamos un listener para detectar cuando el usuario escribe
        etMain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No necesitas nada aquí por ahora
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

    public void Regreso(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}