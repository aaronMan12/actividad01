package com.escuela.Escuela;

public class Profe {
private String nombre=null;
private int Nsalon=0;
private String ubicacion=null;

public Profe(String nombre, int nsalon, String ubicacion) {
    this.nombre = nombre;
    Nsalon = nsalon;
    this.ubicacion = ubicacion;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int getNsalon() {
    return Nsalon;
}

public void setNsalon(int nsalon) {
    Nsalon = nsalon;
}

public String getUbicacion() {
    return ubicacion;
}

public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
}


}
