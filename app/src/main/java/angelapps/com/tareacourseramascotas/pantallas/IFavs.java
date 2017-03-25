package angelapps.com.tareacourseramascotas.pantallas;

import java.util.ArrayList;

import angelapps.com.tareacourseramascotas.Adapter.mascotaAdaptador;
import angelapps.com.tareacourseramascotas.POGO.mascota;

/**
 * Created by angel on 3/3/2017.
 */

public interface IFavs {

    public void generarLinearLayoutVertical();

    public mascotaAdaptador crearAdaptador(ArrayList<mascota> mascotas);

    public void inicializarAdaptadorRV(mascotaAdaptador adaptador);

}


