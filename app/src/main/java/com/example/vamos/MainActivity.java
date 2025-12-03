package com.example.vamos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etValor;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValor = findViewById(R.id.etValor);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularSerie();
            }
        });
    }

    private void calcularSerie() {
        String nStr = etValor.getText().toString().trim();

        if (nStr.isEmpty()) {
            Toast.makeText(this, "Digite um valor!", Toast.LENGTH_SHORT).show();
            return;
        }

        int n;
        try {
            n = Integer.parseInt(nStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (n <= 0 || n >= 20) {
            Toast.makeText(this, "O valor deve ser entre 1 e 19!", Toast.LENGTH_LONG).show();
            return;
        }

        double soma = 0.0;
        for (int i = 1; i <= n; i++) {
            soma += 1.0 / i; // (i / i²) = 1/i
        }

        String resultado = String.format("Resultado: %.6f", soma);
        tvResultado.setText(resultado);
    }
}
