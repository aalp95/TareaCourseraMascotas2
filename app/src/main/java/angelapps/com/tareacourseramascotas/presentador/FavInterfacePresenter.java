package angelapps.com.tareacourseramascotas.presentador;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import angelapps.com.tareacourseramascotas.DB.ConstructorMascotas;
import angelapps.com.tareacourseramascotas.POGO.mascota;
import angelapps.com.tareacourseramascotas.pantallas.IFavs;

/**
 * Created by angel on 3/3/2017.
 */

public class FavInterfacePresenter implements IFavInterfacePresenter {


    private IFavs iFavs;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<mascota> mascotas;

    public FavInterfacePresenter(IFavs iFavs, Context context){
        this.iFavs = iFavs;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        ArrayList<mascota> mascotasaux = new ArrayList<>();
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mascotasaux = ordenarArreglo(mascotas);
        mascotas=obtener5(mascotasaux);
        mostrarMascotasRV();
    }

    private ArrayList<mascota> obtener5(ArrayList<mascota> mascotas){
        ArrayList<mascota> mascotasaux = new ArrayList<>();
        mascota mascota = new mascota();
        if(mascotas!=null) {
            for (int a = 0; a < 5; a++) {
                mascota = mascotas.get(a);
                mascotasaux.add(mascota);
            }
                    }
        return mascotasaux;

    }



    private ArrayList<mascota> ordenarArreglo(ArrayList<mascota> mascotas1){
        Collections.sort(mascotas1, new Comparator<mascota>(){

            @Override
            public int compare(mascota o1, mascota o2) {
                return new Integer(o2.getLikes()).compareTo(new Integer(o1.getLikes()));
            }
                }
        );

        return mascotas1;
    }

    @Override
    public void mostrarMascotasRV() {
        iFavs.inicializarAdaptadorRV(iFavs.crearAdaptador(mascotas));
        iFavs.generarLinearLayoutVertical();
    }
}
