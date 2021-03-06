package com.digitalhouse.repasoandroidclaseremota.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.digitalhouse.repasoandroidclaseremota.R;
import com.digitalhouse.repasoandroidclaseremota.controller.PeliculaController;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.Detalle;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.Pelicula;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.PeliculaContainer;
import com.digitalhouse.repasoandroidclaseremota.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.EscuchadorCelda {

    private RecyclerView recyclerView;
    private List<Pelicula> peliculas;
    private RecyclerViewAdapter recyclerViewAdapter;
    private PeliculaController peliculaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.miRecyclerView);
        peliculaController = new PeliculaController();

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        peliculas = new ArrayList<>();
        /*peliculas.addAll(Arrays.asList(
                new Pelicula("https://mlstaticquic-a.akamaihd.net/poster-peliculas-afiches-la-la-land-giganto-60x90cm-D_NQ_NP_703386-MLU26416925941_112017-F.jpg","La La Land","dkfjalkdhfasfhasdjfls"),
                new Pelicula("https://http2.mlstatic.com/posters-cine-afiches-peliculas-45x30-cm-avengers-marvel-dc-D_NQ_NP_863625-MLA29758837919_032019-Q.jpg","Avengers","dkfjalkdhfaskdfjaldsfsdfasfhasdjfls"),
                new Pelicula("https://http2.mlstatic.com/pack-4-afiches-poster-cine-42x30cm-todas-las-peliculas-D_NQ_NP_8878-MLA20009194705_112013-F.jpg","Titanic","dkfjalkasdfasdfasdfdhfasfhasdjfls"),
                new Pelicula("https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/los-20-posters-de-peliculas-mas-creativos/los-idus-de-marzo/7055664-1-esl-ES/LOS-IDUS-DE-MARZO.jpg?resize=480:*","Ryan Gosling","dksdfsfdsffjalkdhfasfhasdjfls"),
                new Pelicula("https://miro.medium.com/max/1200/1*q1tZGTWwWkIGyScG5pR9vA.jpeg","Moonlight","dkfjadfsdfsdlkdhfasfhasdjfls"),
                new Pelicula("https://mlstaticquic-a.akamaihd.net/poster-peliculas-afiches-la-la-land-giganto-60x90cm-D_NQ_NP_703386-MLU26416925941_112017-F.jpg","La La Land","dkfjalkdhfasfhasdjfls"),
                new Pelicula("https://http2.mlstatic.com/posters-cine-afiches-peliculas-45x30-cm-avengers-marvel-dc-D_NQ_NP_863625-MLA29758837919_032019-Q.jpg","Avengers","dkfjalkdhfaskdfjaldsfsdfasfhasdjfls"),
                new Pelicula("https://http2.mlstatic.com/pack-4-afiches-poster-cine-42x30cm-todas-las-peliculas-D_NQ_NP_8878-MLA20009194705_112013-F.jpg","Titanic","dkfjalkasdfasdfasdfdhfasfhasdjfls"),
                new Pelicula("https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/los-20-posters-de-peliculas-mas-creativos/los-idus-de-marzo/7055664-1-esl-ES/LOS-IDUS-DE-MARZO.jpg?resize=480:*","Ryan Gosling","dksdfsfdsffjalkdhfasfhasdjfls"),
                new Pelicula("https://miro.medium.com/max/1200/1*q1tZGTWwWkIGyScG5pR9vA.jpeg","Moonlight","dkfjadfsdfsdlkdhfasfhasdjfls"),
                new Pelicula("https://mlstaticquic-a.akamaihd.net/poster-peliculas-afiches-la-la-land-giganto-60x90cm-D_NQ_NP_703386-MLU26416925941_112017-F.jpg","La La Land","dkfjalkdhfasfhasdjfls"),
                new Pelicula("https://http2.mlstatic.com/posters-cine-afiches-peliculas-45x30-cm-avengers-marvel-dc-D_NQ_NP_863625-MLA29758837919_032019-Q.jpg","Avengers","dkfjalkdhfaskdfjaldsfsdfasfhasdjfls"),
                new Pelicula("https://http2.mlstatic.com/pack-4-afiches-poster-cine-42x30cm-todas-las-peliculas-D_NQ_NP_8878-MLA20009194705_112013-F.jpg","Titanic","dkfjalkasdfasdfasdfdhfasfhasdjfls"),
                new Pelicula("https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/los-20-posters-de-peliculas-mas-creativos/los-idus-de-marzo/7055664-1-esl-ES/LOS-IDUS-DE-MARZO.jpg?resize=480:*","Ryan Gosling","dksdfsfdsffjalkdhfasfhasdjfls"),
                new Pelicula("https://miro.medium.com/max/1200/1*q1tZGTWwWkIGyScG5pR9vA.jpeg","Moonlight","dkfjadfsdfsdlkdhfasfhasdjfls")));*/

        traerPaginaDePeliculasPopulares();

        recyclerViewAdapter = new RecyclerViewAdapter(peliculas, this);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int ultimaPosicionVisible = linearLayoutManager.findLastVisibleItemPosition();
                int totalDeElementos = recyclerViewAdapter.getItemCount();

                if (ultimaPosicionVisible >= totalDeElementos - 5) {
                    //Toast.makeText(MainActivity.this, "Llegué al final", Toast.LENGTH_SHORT).show();
                    traerPaginaDePeliculasPopulares();
                }

            }
        });

    }

    private void traerPaginaDePeliculasPopulares() {
        peliculaController.traerPeliculasDeInternet(new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer results) {
                peliculas = results.getListaDePeliculas();
                recyclerViewAdapter.agregarPaginaDePeliculas(peliculas);
                if (results.getYaNoHayMasPaginas()) {
                    Toast.makeText(MainActivity.this, "Última página", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void eligieronUnaCelda(Pelicula peliculita) {
        //OBTENEMOS EL ID
        String id = peliculita.getId();

        peliculaController.traerUnaPeliculaPorId(new ResultListener<Detalle>() {
            @Override
            public void finish(Detalle results) {
                Toast.makeText(MainActivity.this, results.toString(), Toast.LENGTH_LONG).show();
            }
        }, id);
    }
}
