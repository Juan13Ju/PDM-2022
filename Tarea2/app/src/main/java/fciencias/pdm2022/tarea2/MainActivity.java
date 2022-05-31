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

    private RadioGroup radioGroup;
    private RadioButton radioButton;

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
                confirmarPedido();
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
                confirmarPedido();
                return true;
            case R.id.action_editar_pedido:
                Log.d("MainActivity", (String) "Editar Pedido");
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    // Confirma un pedido y pasa a la siguiente actividad el contenido del pedido
    private void confirmarPedido(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        // Obtenemos que tipo de carne deseamos
        radioGroup = findViewById(R.id.selCarne);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);
        // Obtenemos los ingredientes extra
        String[] ingExtra = obtenerIngredientes();
        // Agregamos los valores al intent
        intent.putExtra("TipoCarne", (String) radioButton.getText());
        intent.putExtra("Extras", ingExtra);
        startActivityForResult(intent, 1);
    }

    private String[] obtenerIngredientes(){
        LinkedList<String> res = new LinkedList<>();
        CheckBox catsup = findViewById(R.id.sel_catsup);
        if(catsup.isChecked()){
            res.add((String) catsup.getText());
        }
        CheckBox mostaza = findViewById(R.id.sel_mostaza);
        if(mostaza.isChecked()){
            res.add((String) mostaza.getText());
        }
        CheckBox queso = findViewById(R.id.sel_queso);
        if(queso.isChecked()){
            res.add((String) queso.getText());
        }
        CheckBox pepinillo = findViewById(R.id.sel_pepinillo);
        if(pepinillo.isChecked()){
            res.add((String) pepinillo.getText());
        }
        return (String[]) res.toArray();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(1 == requestCode){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, "Gracias por tu pedido", Toast.LENGTH_LONG).show();
            }
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Pedido cancelado", Toast.LENGTH_LONG).show();
            }
        }
    }
}