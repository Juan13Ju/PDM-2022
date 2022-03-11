package fciencias.pdm2022.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dibujoView = findViewById(R.id.dibujo);

        // Lo puse asi porque en el layout o en el res string no podia poner mas de un espacio y no encontre
        // solucion, ponerlo entre "" comillas no funcionaba
        String dibujo = "" +
                "        .--'''''''''--.\n     .'      .---.      '.\n    /    .-----------.    \\\n   /        .-----.        \\\n   |       .-.   .-.       |\n   |      /   \\ /   \\      |\n    \\    | .-. | .-. |    /\n     '-._| | | | | | |_.-'\n         | '-' | '-' |\n          \\___/ \\___/\n       _.-'  /   \\  `-._\n     .' _.--|     |--._ '.\n     ' _...-|     |-..._ '\n            |     |\n            '.___.'\n              | |\n             _| |_\n            /\\( )/\\\n           /  ` '  \\\n          | |     | |\n          '-'     '-'\n          | |     | |\n          | |     | |\n          | |-----| |\n       .`/  |     | |/`.\n       |    |     |    |\n       '._.'| .-. |'._.'\n             \\ | /\n             | | |\n             | | |\n             | | |\n            /| | |\\\n          .'_| | |_`.\nLGB       `. | | | .'\n       .    /  |  \\    .\n      /o`.-'  / \\  `-.`o\\\n     /o  o\\ .'   `. /o  o\\\n     `.___.'       `.___.'";
        dibujoView.setText(dibujo);
    }
}