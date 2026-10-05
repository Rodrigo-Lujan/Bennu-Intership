package com.bennu.metodos;

import java.util.Arrays;

import com.bennu.IOrdenador;

public class ArraysSort implements IOrdenador{

    @Override
    public void ordenar(double[] lista) {
        Arrays.sort(lista);
    }
    
}
