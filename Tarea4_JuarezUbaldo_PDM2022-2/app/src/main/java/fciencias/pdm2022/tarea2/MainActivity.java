package fciencias.pdm2022.tarea2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private Button btn_mexicana;
    private Button btn_rapida;
    private Button btn_confirmar;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private class DrawerItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id){
            Log.d("MainActivity", (String) parent.getAdapter().getItem(position));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenuSections = getResources().getStringArray(R.array.menu_items);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.left_drawer, mMenuSections));
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.app_name,
                R.string.app_name
        );
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btn_mexicana = findViewById(R.id.btn_mexicana);
        btn_rapida = findViewById(R.id.btn_rapida);
        btn_confirmar = findViewById(R.id.btn_enviar);

        pref = getSharedPreferences("pedidoPref", MODE_PRIVATE);
        editor = pref.edit();

        btn_mexicana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityMexicana.class);
                startActivity(intent);
            }
        });

        btn_rapida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityRapida.class);
                startActivity(intent);
            }
        });

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityPedido.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        int id = item.getItemId();

        switch(id){
            case R.id.action_settings:
                Log.d("MainActivity", (String) "Abriendo configuracion");
                return true;
            case R.id.action_cancelar_pedido:
                Log.d("MainActivity", (String) "Cancelando pedido");
                editor.clear();
                editor.apply();
                Toast.makeText(this, "Pedido cancelado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_confirmar_pedido:
                Intent intent = new Intent(MainActivity.this, ActivityPedido.class);
                startActivity(intent);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    /*
       @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(1 == requestCode){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "Gracias por tu pedido", Toast.LENGTH_LONG).show();
            }
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Pedido cancelado", Toast.LENGTH_LONG).show();
                resetPedido();
            }
        }
    }*/


}