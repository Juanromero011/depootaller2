package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SandboxListas
{
    private List<Integer> listaEnteros;
    private List<String> listaCadenas;

    public SandboxListas()
    {
        listaEnteros = new ArrayList<>();
        listaCadenas = new LinkedList<>();
    }

    public List<Integer> getCopiaEnteros()
    {
        return new ArrayList<>(listaEnteros);
    }

    public List<String> getCopiaCadenas()
    {
        return new ArrayList<>(listaCadenas);
    }

    public int[] getEnterosComoArreglo()
    {
        int[] arreglo = new int[listaEnteros.size()];
        for (int i = 0; i < listaEnteros.size(); i++)
        {
            arreglo[i] = listaEnteros.get(i);
        }
        return arreglo;
    }

    public int getCantidadEnteros()
    {
        return listaEnteros.size();
    }

    public int getCantidadCadenas()
    {
        return listaCadenas.size();
    }

    public void agregarEntero(int entero)
    {
        listaEnteros.add(entero);
    }

    public void agregarCadena(String cadena)
    {
        listaCadenas.add(cadena);
    }

    public void eliminarEntero(int valor)
    {
        listaEnteros.removeIf(n -> n == valor);
    }

    public void eliminarCadena(String cadena)
    {
        listaCadenas.removeIf(s -> s.equals(cadena));
    }

    public void insertarEntero(int entero, int posicion)
    {
        if (posicion < 0) posicion = 0;
        if (posicion > listaEnteros.size()) posicion = listaEnteros.size();
        listaEnteros.add(posicion, entero);
    }

    public void eliminarEnteroPorPosicion(int posicion)
    {
        if (posicion >= 0 && posicion < listaEnteros.size())
        {
            listaEnteros.remove(posicion);
        }
    }

    public void reiniciarArregloEnteros(double[] valores)
    {
        listaEnteros.clear();
        for (double valor : valores)
        {
            listaEnteros.add((int) valor);
        }
    }

    public void reiniciarArregloCadenas(List<Object> objetos)
    {
        listaCadenas.clear();
        for (Object obj : objetos)
        {
            listaCadenas.add(obj.toString());
        }
    }

    public void volverPositivos()
    {
        for (int i = 0; i < listaEnteros.size(); i++)
        {
            if (listaEnteros.get(i) < 0)
            {
                listaEnteros.set(i, -listaEnteros.get(i));
            }
        }
    }

    public void organizarEnteros()
    {
        listaEnteros.sort((a, b) -> b - a);
    }

    public void organizarCadenas()
    {
        listaCadenas.sort(String::compareTo);
    }

    public int contarApariciones(int valor)
    {
        int count = 0;
        for (int num : listaEnteros)
        {
            if (num == valor)
            {
                count++;
            }
        }
        return count;
    }

    public int contarApariciones(String cadena)
    {
        int count = 0;
        for (String s : listaCadenas)
        {
            if (s.equalsIgnoreCase(cadena))
            {
                count++;
            }
        }
        return count;
    }

    public int contarEnterosRepetidos()
    {
        List<Integer> vistos = new ArrayList<>();
        int count = 0;
        for (int num : listaEnteros)
        {
            if (vistos.contains(num))
            {
                count++;
            }
            else
            {
                vistos.add(num);
            }
        }
        return count;
    }

    public boolean compararArregloEnteros(int[] otroArreglo)
    {
        if (otroArreglo.length != listaEnteros.size()) return false;
        for (int i = 0; i < otroArreglo.length; i++)
        {
            if (otroArreglo[i] != listaEnteros.get(i)) return false;
        }
        return true;
    }

    public void generarEnteros(int cantidad, int minimo, int maximo)
    {
        listaEnteros.clear();
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++)
        {
            listaEnteros.add(rand.nextInt(maximo - minimo + 1) + minimo);
        }
    }
}
