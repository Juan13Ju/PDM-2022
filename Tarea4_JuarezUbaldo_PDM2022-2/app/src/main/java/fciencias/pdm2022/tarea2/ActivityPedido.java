package fciencias.pdm2022.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class ActivityPedido extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> pedido;
    private SharedPreferences pref;
    Button btn_confirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        pedido = new ArrayList<>();
        pedido.add("Rseumen de tu pedido: ");
        pref = getSharedPreferences("prefPedido", MODE_PRIVATE);
        Map<String, ?>  mapaPedido = pref.getAll();
        for(Map.Entry<String, ?> entry : mapaPedido.entrySet()){
            String order = "- " + entry.getKey() + ": " + " x" + entry.getValue().toString();
            pedido.add(order);
        }

        listView = findViewById(R.id.listViewPedido);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pedido);

        listView.setAdapter(adapter);

        btn_confirmar = findViewById(R.id.btn_confirmarPedido);

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref.edit().clear().apply();
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}