import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lista {
List <PuntoAcceso> listaDispositivos;
public Lista(){
    listaDispositivos=new ArrayList<>();
    listaDispositivos.add(new PuntoAcceso(1,"DELL","3112",12F));
}
public void agregarDispositivo(PuntoAcceso ap){
    for (PuntoAcceso p: listaDispositivos){
        if (ap.getCodigo()==p.getCodigo()){
            p.setMarca(ap.getMarca());
            p.setIp(ap.getIp());
            p.setPrecio(ap.getPrecio());
            JOptionPane.showMessageDialog(null, "Dispositivo Actualizado");
            return;
        }
    }
    listaDispositivos.add(ap);
    JOptionPane.showMessageDialog(null, "Nuevo Dispositivo Agregado");
}

    public List<PuntoAcceso> listaUnica() {
        Set<String> direccionesIPUnicas = new HashSet<>();
        List<PuntoAcceso> listaNoDuplicados = new ArrayList<>();
        for (PuntoAcceso dispositivo : listaDispositivos) {
            String direccionIP = dispositivo.getIp();
            if (!direccionesIPUnicas.contains(direccionIP)) {
                listaNoDuplicados.add(dispositivo);
                direccionesIPUnicas.add(direccionIP);
            }
        }
        return listaNoDuplicados;
    }


public void ordenarNoDuplicados(){
    PuntoAcceso aux;
    for (int i=0; i<listaUnica().size()-1;i++){
        for(int j=i+1; j<listaUnica().size(); j++){
            if (listaUnica().get(i).getCodigo()>listaUnica().get(j).getCodigo()){
                aux=listaUnica().get(i);
                listaUnica().set(i,listaUnica().get(j));
                listaUnica().set(j, aux);
            }
        }
    }
}
public float sumatoria(int indice, String Marca){
if (indice<listaDispositivos.size()){
    if (listaDispositivos.get(indice).getMarca().equals(Marca)){
        return listaDispositivos.get(indice).getPrecio()+sumatoria(indice+1,Marca);
    }else {
        return sumatoria(indice+1,Marca);
    }
}else{
    return 0;
    }
}
public float sumatoria(String marca){
    return sumatoria(0, marca);
}

}
