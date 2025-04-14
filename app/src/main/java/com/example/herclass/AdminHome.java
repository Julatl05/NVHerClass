package com.example.herclass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;

public class AdminHome extends AppCompatActivity {

    EditText txtbuscar, editTextResultado1, editTextResultado2;
    Button btnbuscar, btneliminar, btnactualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_home);

        txtbuscar = findViewById(R.id.txtbuscar);
        editTextResultado1 = findViewById(R.id.editTextResultado1);
        editTextResultado2 = findViewById(R.id.editTextResultado2);
        btnbuscar = findViewById(R.id.btnbuscar);
        btneliminar = findViewById(R.id.btneliminar);
        btnactualizar = findVewById(R.id.btnactualizar);

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = txtbuscar.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(AdminHome.this, "Por favor escribe algo", Toast.LENGTH_SHORT).show();
                    return;
                }

                buscarUsuarioPorID(id);
            }
        });
    }


    private void buscarUsuarioPorID(String id){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("usuarios").child(id);
        ref.addListenerForSingleValueEvent(new ValueEventListener(){
        @Override
        public void onDataChange(DataSnapshot snapshot){
            if (snapshot.exists()){
                String nombre = snapshot.child("nombre").getValue(String.class);
                String contraseña = snapshot.child("contraseña").getValue(String.class);
                editTextResultado1.setText(nombre);
                editTextResultado2.setText(contraseña);
            }
            else {
                Toast.makeText(AdminHome.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                editTextResultado1.setText("");
                editTextResultado2.setText("");
            }
        }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(AdminHome.this, "Error al buscar usuario", Toast.LENGTH_SHORT).show();
        }
    }
}