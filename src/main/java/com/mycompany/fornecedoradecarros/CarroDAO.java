/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fornecedoradecarros;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pronatec
 */
public class CarroDAO {

    private static CarroDAO instance;

    private ArrayList<Carro> carros;

    private CarroDAO() {
        this.carros = new ArrayList<Carro>();
    }

    public static CarroDAO getInstance() {
        if (instance == null) {
            instance = new CarroDAO();
        }

        return instance;
    }

    public boolean adicionar(Carro carro) {
        return this.carros.add(carro);
    }

    public boolean deletar(Carro carro) {
        return this.carros.remove(carro);
    }

    public Carro recuperar(Integer codigo) {
        for (Carro carro : this.carros) {
            if (carro.getChassi() == (codigo)) {
                return carro;
            }
        }
        return null;
    }

    public void alterar(Carro t) {
        for (Carro carro : this.carros) {
            if (carro.getChassi() == t.getChassi()) {
                this.carros.remove(carro);
                this.carros.add(t);
            }
        }
    }

    public List<Carro> recuperarTodos() {
        return this.carros;
    }
}
