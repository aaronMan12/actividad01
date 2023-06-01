package com.escuela.Escuela;

public class Salones {
   
    String ubicacion;
    int numero;
    int piso;

    public Salones(String ubicacion, int numero, int piso) {
        this.ubicacion = ubicacion;
        this.numero = numero;
        this.piso = piso;
    }
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }
    public void setPiso(int piso) {
        this.piso = piso;
    }
    

}
