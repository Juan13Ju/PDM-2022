package fciencias.pdm2022.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String tipoCarne;
    String[] ingExtras;
    Button btnConfirmar;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        tipoCarne = intent.getStringExtra("TipoCarne");
        ingExtras = intent.getStringArrayExtra("Extras");
        LinearLayout linearLayout = findViewById(R.id.linearLay);
        String extras = generarExtras(ingExtras);
        String pedido = "El resumen de tu pedido: 1 hamburguesa tipo " + tipoCarne + " con: " + extras;
        TextView tv = new TextView(this);
        tv.setText(pedido);
        tv.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }

    private String generarExtras(String[] ar){
        String res = "";

        for(String s : ar){
            res = res + " " + s + ", ";
        }
        return res;
    }
}