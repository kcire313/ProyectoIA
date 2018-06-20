/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia;

/**
 *
 * 
 * 
 * Erick Sanches Ruiz Esparza
 * Juan Manuel Arzate 
 * 
 */
public class Principal {
    public static void main(String[] args) {     
        ProyectoIA a = new ProyectoIA();
        a.agregaCuidades(); //Carga las coordenadas de las ciudades
        System.out.println("1era Entrega---------------------------------------------------------------------------------------------------------------------------");
        a.agregaCaminos(); //Hace las distintas combinaciones de ciudades   
        a.vecCaminos = a.distanciaCaminos(a.vecCaminos); //Saca la distancia total del recorrido
        a.muestraPrimeros50(a.vecCaminos); //Muestra los primeros 50 caminos y ordena todos los caminos del m al M
        System.out.println("\n2da Entrega---------------------------------------------------------------------------------------------------------------------------");
        a.agregaCaminos_2();
        a.vecCaminos = a.distanciaCaminos(a.vecCaminos);
        System.out.println("\nSin Ordenar---------------------------------------------------------------------------------------------------------------------------");
        a.muestraPrimeros50SinOrdenar(a.vecCaminos);
        System.out.println("\nOrdenados---------------------------------------------------------------------------------------------------------------------------");
        a.muestraPrimeros50(a.vecCaminos);
        System.out.println("");
        System.out.println("\n Permutacion---------------------------------------------------------------------------------------------------------------------------");
        a.intercambioPosiciones();
        a.muestraPrimeros50(a.vecCaminos);
        System.out.println("\nULTIMA Entrega---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Generacion Cromosoma\t\t\t\t\t\t\t\t\tContenido\t\t\t\t\t\t\t\t\tRecorrido");
        for (int i = 0; i < 100; i++) {
            a.intercambioPosiciones();
            a.agregaCaminos_2();
            a.vecCaminos = a.distanciaCaminos(a.vecCaminos);
            a.muestraPrimeros50SinImprimir(a.vecCaminos);
            System.out.print("    "+i+"\t       "+(i+1)+"\t");
            a.muestraPrimerCamino(a.vecCaminos);
            System.out.println("");
        }
    }
}
