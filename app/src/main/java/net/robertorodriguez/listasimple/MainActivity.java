package net.robertorodriguez.listasimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listaComercios;

    private List<String> comercios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Colección de comercios
        comercios = new ArrayList<>();
        comercios.add("Carrefour");
        comercios.add("Dia");
        comercios.add("Mercadona");
        comercios.add("Lupa");
        comercios.add("El árbol");
        comercios.add("Carrefour Express");
        comercios.add("Gadis");
        comercios.add("El Corte Inglés");
        comercios.add("Primaprix");

        // Conectar con el ListView
        listaComercios = (ListView) findViewById(R.id.lv_comercios);

        // Conectar el listado con el ListView mediante un adapter.
        // El adapter toma el listado, el ListView y una plantilla.
        // Existen adaptadores y plantillas por defecto.
        ArrayAdapter<String> adaptadorComercios = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                comercios
        );

        // Asignamos el adaptador al listado
        listaComercios.setAdapter( adaptadorComercios );

        // Asignamos eventos a cada elemento de la vista
        listaComercios.setOnItemClickListener( this );

    }

    /**
     * Método que implementa la acción que se debe realizar como respuesta a la selección
     * de un elemento de la lista
     * @param adapterView El adaptador
     * @param view el elemento sobre el que se clicado
     * @param posicion la posición que ocupa el elemento clicado
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        Toast.makeText(this,
               "Comercio seleccionada: " + comercios.get(posicion), Toast.LENGTH_SHORT)
                .show();
    }
}