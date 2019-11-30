package com.digitalhouse.repasoandroidclaseremota.controller;

import com.digitalhouse.repasoandroidclaseremota.model.dao.DaoPeliculasInternet;
import com.digitalhouse.repasoandroidclaseremota.model.pojo.PeliculaContainer;
import com.digitalhouse.repasoandroidclaseremota.util.ResultListener;

public class PeliculaController {

    private DaoPeliculasInternet dao;

    public PeliculaController() {
        dao = new DaoPeliculasInternet();
    }

    public void traerPeliculasDeInternet(final ResultListener<PeliculaContainer> escuchadorDeLaVista){
        dao.traerPeliculasDeInternet(new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer results) {
                escuchadorDeLaVista.finish(results);
            }
        });
    }
}