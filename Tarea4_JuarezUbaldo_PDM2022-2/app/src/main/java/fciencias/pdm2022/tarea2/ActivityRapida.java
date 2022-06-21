package fciencias.pdm2022.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import fciencias.pdm2022.tarea2.CustomAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityRapida extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> platillos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapida);
        platillos = new ArrayList<>();
        platillos.add("Hamburguesa");
        platillos.add("Hot dog");
        platillos.add("Banderillas");
        platillos.add("Papas a la francesa");
        platillos.add("Alitas");

        listView = findViewById(R.id.lista_rapida);

        CustomAdapter myAdapter = new CustomAdapter(this, R.layout.list_item, platillos);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityRapida.this, "Seleccionaste " + platillos.get(i), Toast.LENGTH_LONG).show();
            }
        });
    }
}