package service;

import dto.*;
import exceptions.VidaUtilInsuficienteException;


import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CocinaSvc implements Callable<Void> {

    private static CocinaSvc instance = null;
    List<Chef> chefsLuneasAJueves; // 3 Chefs
    List<Chef> chefsViernesADomingoYFeriados; // 5 Chefs

    List<Cocinable> recetasAPreparar;

    private CocinaSvc(List<Chef> chefsLuneasAJueves, List<Chef> chefsViernesADomingoYFeriados) {
        this.chefsLuneasAJueves = chefsLuneasAJueves;
        this.chefsViernesADomingoYFeriados = chefsViernesADomingoYFeriados;
    }

    private CocinaSvc(){

    }

    public static CocinaSvc getInstance() {
        if (instance == null) {
            instance = new CocinaSvc();
        }
        return instance;
    }
    public void agregarRecetasParaPreparar(List<Cocinable> recetas){
        recetasAPreparar.addAll(recetas);
    }
    public void prepararPlatilloChefsLuneasAJueves(List<Cocinable> recetasPorCocinar){
        ExecutorService executorServiceLunesAJueves  = Executors.newFixedThreadPool(3);
        for (int i = 0; i < chefsLuneasAJueves.size(); i++){
            executorServiceLunesAJueves.submit(getInstance());
        }
        executorServiceLunesAJueves.shutdown();
    }

    public void prepararPlatilloChefsViernesADomingoYFeriados(List<Cocinable> recetasPorCocinar){
        ExecutorService executorServiceViernesADomingoYFeriados  = Executors.newFixedThreadPool(5);
        for (int i = 0; i < chefsViernesADomingoYFeriados.size(); i++){
            executorServiceViernesADomingoYFeriados.submit(getInstance());
        }
        executorServiceViernesADomingoYFeriados.shutdown();
    }

    private void preparPlatillos(List<Cocinable> recetasPorCocinar) throws  Exception{

    }

    private void disminuirVidaUtil(Cocinable cocinable) throws VidaUtilInsuficienteException {
        for (Utensillo utensillo : cocinable.getUtensillos()){
                utensillo.sacar(1);
        }

    }


    @Override
    public Void call() throws Exception {
        preparPlatillos(recetasAPreparar);
    }
}
