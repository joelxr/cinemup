package br.com.joelxr.cinemup.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.joelxr.cinemup.dao.AtorDAO;
import br.com.joelxr.cinemup.dao.CinemaDAO;
import br.com.joelxr.cinemup.dao.DiretorDAO;
import br.com.joelxr.cinemup.dao.GeneroDAO;
import br.com.joelxr.cinemup.entities.Ator;
import br.com.joelxr.cinemup.entities.Cinema;
import br.com.joelxr.cinemup.entities.Diretor;
import br.com.joelxr.cinemup.entities.Genero;
import br.com.joelxr.cinemup.util.Util;
import java.util.List;

/**
 *
 * @author joel
 */
@Resource
public class FilmeController {

    private final Result result;
    private AtorDAO atorDao;
    private DiretorDAO diretorDao;
    private GeneroDAO generoDao;
    private CinemaDAO cinemaDao;

    public FilmeController(CinemaDAO cinemaDao, GeneroDAO generoDao, DiretorDAO diretorDao, AtorDAO atorDao, Result result) {
        this.cinemaDao = cinemaDao;
        this.generoDao = generoDao;
        this.diretorDao = diretorDao;
        this.atorDao = atorDao;
        this.result = result;
    }

    @Path("/filme/preparar_valores")
    public void setarValores() {
        List<Ator> atores = atorDao.listar();
        List<Diretor> diretores = diretorDao.listar();
        List<Genero> generos = generoDao.listar();
        List<Cinema> cinemas = cinemaDao.listar();
        result.include("lista_atores", Util.listAsString(atores));
        result.include("lista_diretores", Util.listAsString(diretores));
        result.include("lista_generos", Util.listAsString(generos));
        result.include("lista_cinema", Util.listAsString(cinemas));
        result.redirectTo(FilmeController.class).adicionar();
    }

    @Path("/filme/adicionar")
    public void adicionar() {
    }
}
