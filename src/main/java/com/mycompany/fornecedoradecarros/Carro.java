/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fornecedoradecarros;

import java.util.Objects;

/**
 *
 * @author pronatec
 */
public class Carro {

    int chassi;
    String marca;
    String modelo;

    public Carro(int chassi, String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
    }

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Carro(int chassi) {
        this.chassi = chassi;
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.chassi, other.chassi)) {
            return false;
        }
        return true;
    }

}
