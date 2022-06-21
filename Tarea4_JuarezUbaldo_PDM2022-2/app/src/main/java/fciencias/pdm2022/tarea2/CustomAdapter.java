package fciencias.pdm2022.tarea2;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<String> items;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public CustomAdapter(Context context, int layout, ArrayList<String> arr){
        this.context = context;
        this.layout = layout;
        this.items = arr;
        this.pref = context.getSharedPreferences("prefPedido", Context.MODE_PRIVATE);
        this.editor = pref.edit();
    }


    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.list_item, null);

        String currentItem = items.get(position);

        TextView textView = v.findViewById(R.id.textView);
        textView.setText(currentItem);

        Button btn_anadir = v.findViewById(R.id.btn_anadir);

        btn_anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String platillo = items.get(position);


                if(pref.contains(platillo)) {
                    editor.putInt(platillo, pref.getInt(platillo, 0) + 1);
                }else{
                    editor.putInt(platillo, 1);
                }
                editor.apply();
                Toast.makeText(context, "Platillo añadido", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
