package com.example.reinaldo.listview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String[] itens = {"Angra dos Reis", "Caldas Novas",
            "Campos do Jordão", "Costa do Sauípe", "ilhéus",
            "Porto Seguro", "Tiradentes", "Praga", "Santiago",
            "Zurique", "Caribe", "Buenos Aires", "Budapeste",
            "Cancún", "Aruba"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        //Cria um adaptador para a listaLocais
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens) {

            //Metodo que coloca cor na listView
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;

            }
        };


        //Adiciona o adaptador para a lista
        listLocais.setAdapter(adaptador);


        //Adiciona o clique na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicaoItem, long l) {

                //variavel do tipo string que pega a posiao do item clicado e convert para string(toString())
                String valorSelecionado = listLocais.getItemAtPosition(posicaoItem).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG ).show();
            }
        });

    }
}
