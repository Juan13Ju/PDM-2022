package fciencias.pdm2022.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import fciencias.pdm2022.tarea2.CustomAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityMexicana extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> platillos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexicana);

        platillos = new ArrayList<>();
        platillos.add("Enchiladas");
        platillos.add("Tinga de pollo");
        platillos.add("Tacos de canasta");
        platillos.add("Cochinita");
        platillos.add("Barbacoa");

        listView = findViewById(R.id.lista_mexicana);

        CustomAdapter myAdapter = new CustomAdapter(this, R.layout.list_item, platillos);

        listView.setAdapter(myAdapter);
    }
}