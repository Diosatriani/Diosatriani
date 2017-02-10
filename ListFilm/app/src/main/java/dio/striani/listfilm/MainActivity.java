package dio.striani.listfilm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private String [] fileTitles= {"The Thor", "Harry Potter", "Inception",
            "wolf of wallstreet", "Django Unchained",
            "Titanic", "Captain America", "Doctor Strange",
            "X-Men Apocalypse", "Shutter Island"};

    private ArrayList<Movie> movies = new ArrayList<>();

    ArrayAdapter<Movie> adapter;
    ListView listView;

    private void iniMovie(){
        movies.add(new Movie("The Thor", "Film tentang superhero dengan senjata palu", 7.5, 2012));
        movies.add(new Movie("Hulk", "Superhero yang bisa berubah menjadi raksasa hijau" + "sepert monster", 6.5, 2011));
        movies.add(new Movie("Spiderman", "Film tentang superhero yang bisa mengeluarkan jaring laba - laba", 7, 2010));
        movies.add(new Movie("Titanic", "Film yang menceritakan tentang seorang pemuda dan gadis yang saling jatuh cinta" +
                "di perahu yang bernama Titanic", 8, 2008));
        movies.add(new Movie("The Martial", "Film yang mengisahkan seorang astronot dari Nasa" +
                "yang melakukan perjalanan ke planet Mars kemudian peawatnya rusak ", 8.5, 2015));
        movies.add(new Movie("Harry Potter", "Film tentang pesulap ", 7.5, 2011));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniMovie();
        adapter = new ArrayAdapter<Movie>(this,
                android.R.layout.simple_list_item_1, movies);
        listView = (ListView) findViewById(R.id.List_film);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Movie selectMovie = movies.get(position);
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                intent.putExtra("dio.striani.listfilm", selectMovie);
                startActivity(intent);
            }
        });
    }

    public void TambahListadd(View view){
        Intent intent = new Intent(this, TambahList.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==Activity.RESULT_OK){


                Movie newMovie = (Movie) data.getSerializableExtra("filmlist.result");
                movies.add(newMovie);
                adapter.notifyDataSetChanged();}
        }
    }
}
