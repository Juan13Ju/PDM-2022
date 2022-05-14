package fciencias.pdm2022.tarea2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

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
        Button btn_enviar = findViewById(R.id.btn_enviar_txt);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
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
                return true;
            case R.id.action_confirmar_pedido:
                Log.d("MainActivity", (String) "Confirmando pedido");
                return true;
            case R.id.action_editar_pedido:
                Log.d("MainActivity", (String) "Editar Pedido");
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}