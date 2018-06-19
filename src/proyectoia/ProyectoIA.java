/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class ProyectoIA {

    float[][] vecCaminos = new float[100][27]; //Matriz de los caminos y su distancia
    int[][] vecCiudades = new int[25][2]; //Matriz de las posiciones de las ciudades 
    float[][] vec50Mejores = new float[50][27];//Mateiz que almacena los 50 mejores

    public ProyectoIA() {

    }

    private void agregaCuidades() { //Se agregan las coordendas X y Y de las ciudades
        //Cuidad 1
        vecCiudades[0][0] = 5; //posicion X
        vecCiudades[0][1] = 4; //posicion Y
        //Cuidad 2
        vecCiudades[1][0] = 7; //posicion X
        vecCiudades[1][1] = 4; //posicion Y
        //Cuidad 3
        vecCiudades[2][0] = 5; //posicion X
        vecCiudades[2][1] = 6; //posicion Y
        //Cuidad 4
        vecCiudades[3][0] = 4; //posicion X
        vecCiudades[3][1] = 3; //posicion Y
        //Cuidad 5
        vecCiudades[4][0] = 3; //posicion X
        vecCiudades[4][1] = 6; //posicion Y
        //Cuidad 6
        vecCiudades[5][0] = 4; //posicion X
        vecCiudades[5][1] = 5; //posicion Y
        //Cuidad 7
        vecCiudades[6][0] = 2; //posicion X
        vecCiudades[6][1] = 4; //posicion Y
        //Cuidad 8
        vecCiudades[7][0] = 1; //posicion X
        vecCiudades[7][1] = 3; //posicion Y
        //Cuidad 9
        vecCiudades[8][0] = 1; //posicion X
        vecCiudades[8][1] = 5; //posicion Y
        //Cuidad 10
        vecCiudades[9][0] = 3; //posicion X
        vecCiudades[9][1] = 2; //posicion Y
        //Cuidad 11
        vecCiudades[10][0] = 6; //posicion X
        vecCiudades[10][1] = 3; //posicion Y
        //Cuidad 12
        vecCiudades[11][0] = 7; //posicion X
        vecCiudades[11][1] = 7; //posicion Y
        //Cuidad 13
        vecCiudades[12][0] = 6; //posicion X
        vecCiudades[12][1] = 1; //posicion Y
        //Cuidad 14
        vecCiudades[13][0] = 4; //posicion X
        vecCiudades[13][1] = 1; //posicion Y
        //Cuidad 15
        vecCiudades[14][0] = 1; //posicion X
        vecCiudades[14][1] = 1; //posicion Y
        //Cuidad 16
        vecCiudades[15][0] = 1; //posicion X
        vecCiudades[15][1] = 7; //posicion Y
        //Cuidad 17
        vecCiudades[16][0] = 4; //posicion X
        vecCiudades[16][1] = 7; //posicion Y
        //Cuidad 18
        vecCiudades[17][0] = 7; //posicion X
        vecCiudades[17][1] = 2; //posicion Y
        //Cuidad 19
        vecCiudades[18][0] = 9; //posicion X
        vecCiudades[18][1] = 2; //posicion Y
        //Cuidad 20
        vecCiudades[19][0] = 8; //posicion X
        vecCiudades[19][1] = 5; //posicion Y
        //Cuidad 21
        vecCiudades[20][0] = 10; //posicion X
        vecCiudades[20][1] = 4; //posicion Y
        //Cuidad 22
        vecCiudades[21][0] = 11; //posicion X
        vecCiudades[21][1] = 1; //posicion Y
        //Cuidad 23
        vecCiudades[22][0] = 10; //posicion X
        vecCiudades[22][1] = 7; //posicion Y
        //Cuidad 24
        vecCiudades[23][0] = 13; //posicion X
        vecCiudades[23][1] = 6; //posicion Y
        //Cuidad 25
        vecCiudades[24][0] = 12; //posicion X
        vecCiudades[24][1] = 8; //posicion Y
    }

    private void agregaCaminos() { //Hace las distintas combinaciones de ciudades
        /*Random rand = new Random();*/
        for (int i = 0; i < 100; i++) {
            vecCaminos[i][0] = 1;
            vecCaminos[i][25] = 1;
        }
        //muestraCaminos();
        int j = 0, aux = 0;
        for (int i = 0; i < 100; i++) {
            j = 1;
            while (j < 25) {
                aux = (int) (Math.random() * 25) + 1;//rand.nextInt(25) + 1; //rand.nextInt(max - min + 1) + min
                if (verifica(aux, i, j)) {//Verifica que la ciudad no se repita
                    vecCaminos[i][j] = aux;
                    j++;
                }
            }
            //vecCaminos[i][25] = vecCaminos[i][0];//El primer elemento se pasa al ultimo para cerrar el ciclo
        }
    }

    private boolean verifica(int rand, int i, int j) { //Verifica que la ciudad no se repita
        for (int x = 0; x < j; x++) {
            if (rand == vecCaminos[i][x]) {
                return false; //Si la ciudad se repite manda un false 
            }
        }
        return true; //Si llegó aquí quiere decir que ningun elemento se repitió
    }

    public void muestraCaminos(float vecCaminos[][]) { //Muestra los 100 caminos
        System.out.println("\t\t\t\tRUTAS\t\t\t\t\t\tDISTANCIA");
        for (int i = 0; i < 100; i++) {
            System.out.print((i + 1) + ".- ["); //Muesta la enumeración del camino y abre el vecCamino "["
            for (int j = 0; j < 27; j++) {
                if (j == 26) {
                    System.out.print("\t[" + vecCaminos[i][j] + "] "); //Muestra la distancia
                } else {
                    if (j == 25) {
                        System.out.print((int) vecCaminos[i][j] + "]"); //Final del camino
                    } else {
                        System.out.print((int) vecCaminos[i][j] + ","); //Indica que hay mas elementos aun
                    }
                }
            }
            System.out.println();
        }
    }

    private float[][] distanciaCaminos(float vecCaminos[][]) { //Saca la distancia total del recorrido
        float suma = 0;
        for (int i = 0; i < 100; i++) {
            suma = 0;
            for (int j = 0; j < 25; j++) {
                suma += dEntreCiudades(vecCaminos[i][j], vecCaminos[i][j + 1]);//Saca la distancia entre ciudades
            }
            vecCaminos[i][26] = suma; //Asigna la suma total a la ultima columna de la fila
        }
        return vecCaminos;
    }

    private float dEntreCiudades(float c1, float c2) { //Saca la distancia entre ciudades
        int xp1 = (int) (c1 - 1); //Ciudad X1/Y2 - Se le resto 1 para que concordara con la matriz
        int xp2 = (int) (c2 - 1); //Ciudad X2/Y2 - Se le resto 1 para que concordara con la matriz
        float restX = (float) Math.pow((vecCiudades[xp2][0] - vecCiudades[xp1][0]), 2);//(X1-X2)^2
        float restY = (float) Math.pow((vecCiudades[xp2][1] - vecCiudades[xp1][1]), 2);//(Y1-Y2)^2
        float raiz = (float) Math.sqrt(restX + restY); //sqrt((X1-X2)^2 + (Y1-Y2)^2)
        return raiz;
    }

    private void ordenaMenorMayor(float vecCaminos[][]) { //Ordena todos los caminos del menor al mayor
        int p;
        float aux;
        for (int i = 0; i < 100; i++) {
            p = i;
            aux = vecCaminos[i][26];
            for (int j = i + 1; j < 100; j++) {
                if (aux > vecCaminos[j][26]) { //Identifica cual es el mas pequeño del arreglo
                    p = j;
                    aux = vecCaminos[j][26];
                }
            }
            cambiaCaminos(i, p, vecCaminos); //Se le manda las dos filas a intercambiar
        }
    }

    private void cambiaCaminos(int ap, int dp, float vecCaminos[][]) { //Cambia los vectores dentro de la matriz
        float aux = 0;
        for (int i = 0; i < 27; i++) {
            aux = vecCaminos[ap][i];
            vecCaminos[ap][i] = vecCaminos[dp][i];
            vecCaminos[dp][i] = aux;
        }
    }

    public void muestraPrimeros50(float vecCaminos[][]) {
        ordenaMenorMayor(vecCaminos);
        System.out.println("\t\t\t\tRUTAS\t\t\t\t\t\tDISTANCIA");
        for (int i = 0; i < 50; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1) + ".- [");
            } else {
                System.out.print((i + 1) + ".- [");
            }
            for (int j = 0; j < 27; j++) {
                vec50Mejores[i][j] = vecCaminos[i][j];
                if (j == 26) {
                    System.out.print("\t[" + vecCaminos[i][j] + "] ");
                } else {
                    if (j == 25) {
                        if (vecCaminos[i][j] < 10) {
                            System.out.print(" " + (int) vecCaminos[i][j] + "]\t->");
                        } else {
                            System.out.print((int) vecCaminos[i][j] + "]\t->");
                        }
                    } else {

                        if (vecCaminos[i][j] < 10) {
                            System.out.print(" " + (int) vecCaminos[i][j] + " , ");
                        } else {
                            System.out.print((int) vecCaminos[i][j] + " , ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
    
    public void muestraPrimeros50SinImprimir(float vecCaminos[][]) {
        ordenaMenorMayor(vecCaminos);        
        for (int i = 0; i < 50; i++) {            
            for (int j = 0; j < 27; j++) {
                vec50Mejores[i][j] = vecCaminos[i][j];               
            }            
        }
    }
    
    public void muestraPrimeros50SinOrdenar(float vecCaminos[][]) {        
        System.out.println("\t\t\t\tRUTAS\t\t\t\t\t\tDISTANCIA");
        for (int i = 0; i < 50; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1) + ".- [");
            } else {
                System.out.print((i + 1) + ".- [");
            }
            for (int j = 0; j < 27; j++) {
                vec50Mejores[i][j] = vecCaminos[i][j];
                if (j == 26) {
                    System.out.print("\t[" + vecCaminos[i][j] + "] ");
                } else {
                    if (j == 25) {
                        if (vecCaminos[i][j] < 10) {
                            System.out.print(" " + (int) vecCaminos[i][j] + "]\t->");
                        } else {
                            System.out.print((int) vecCaminos[i][j] + "]\t->");
                        }
                    } else {

                        if (vecCaminos[i][j] < 10) {
                            System.out.print(" " + (int) vecCaminos[i][j] + " , ");
                        } else {
                            System.out.print((int) vecCaminos[i][j] + " , ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public void agregaCaminos_2() {
        ArrayList<Integer> nodosUsados = new ArrayList();
        vecCaminos = new float[100][27];
        int nodoActual = 0;
        int salto = 1;

        for (int nodo = 0; nodo < 100; nodo++) {

            int nodoAux = nodoActual + salto;

            if (nodoAux > 49) {
                nodoAux = salto - 1;
            }

            nodosUsados.add(nodoActual);
            nodosUsados.add(nodoAux);

            for (int i = 0; i < 27; i++) {
                vecCaminos[nodo][i] = 0;
            }

            /*Paso 1*/
            vecCaminos[nodo][0] = vec50Mejores[nodoActual][0];
            vecCaminos[nodo][1] = vec50Mejores[nodoActual][1];
            vecCaminos[nodo][24] = vec50Mejores[nodoActual][24];
            vecCaminos[nodo][25] = vec50Mejores[nodoActual][25];

            float valAux = vec50Mejores[nodoAux][1];
            float breakVal = vecCaminos[nodo][24];
            float breakVal_2 = vecCaminos[nodo][1];
            int posicion = 0;
            ArrayList<PosValor> posicionesBajar = new ArrayList();

            while (valAux != breakVal && valAux != breakVal_2 && !containValue(valAux, posicionesBajar)) {
                posicion = getPosicion(nodoActual, valAux);
                vecCaminos[nodo][posicion] = valAux;
                posicionesBajar.add(new PosValor(posicion, valAux));
                valAux = vec50Mejores[nodoAux][posicion];
            }

            for (int i = 2; i < 25; i++) {
                if (vecCaminos[nodo][i] == 0) {
                    if (vec50Mejores[nodoAux][i] == breakVal || vec50Mejores[nodoAux][i] == breakVal_2) {
                        vecCaminos[nodo][i] = vec50Mejores[nodoAux][24];
                    } else {
                        vecCaminos[nodo][i] = vec50Mejores[nodoAux][i];
                    }
                }
            }

            while (nodosUsados.contains(nodoActual)) {
                nodoActual++;
            }

            if ((nodo + 1) % 25 == 0) {
                salto++;
                nodoActual = 0;
                nodosUsados.clear();
            }

        }
    }

    public int getPosicion(int nodo, float valor) {
        for (int i = 0; i < 26; i++) {
            if (vec50Mejores[nodo][i] == valor) {
                return i;
            }
        }
        System.out.println("No se encontro: " + valor);
        return -1;
    }

    public void intercambioPosiciones(float vecCaminos[][]) {
        float aux = vec50Mejores[0][4];
        vec50Mejores[0][4] = vec50Mejores[0][9];
        vec50Mejores[0][9] = aux;
        
        aux = vecCaminos[0][4];
        vecCaminos[0][4] = vecCaminos[0][9];
        vecCaminos[0][9] = aux;
    }

    public void imprimeUsados(ArrayList<PosValor> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("posicion: " + lista.get(i).getPosicion() + "  valor: " + lista.get(i).getValor());
        }
    }

    public boolean containValue(float value, ArrayList<PosValor> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getValor() == value) {
                return true;
            }
        }
        return false;
    }
    
    public void muestraPrimerCamino() {
        for (int j = 0; j < 27; j++) {                        
            if (j == 26) {                
                System.out.print("\t[" + vec50Mejores[0][j] + "] ");
            } else {
                if (j == 25) {
                    if (vec50Mejores[0][j] < 10) {
                        System.out.print(" " + (int) vec50Mejores[0][j] + "]\t->");
                    } else {
                        System.out.print((int) vec50Mejores[0][j] + "]\t->");
                    }
                } else if(j == 0){
                    if (vec50Mejores[0][j] < 10) {
                        System.out.print("[" + (int) vec50Mejores[0][j] + " , ");
                    } else {
                        System.out.print((int) vec50Mejores[0][j] + " , ");
                    }
                }else {
                    if (vec50Mejores[0][j] < 10) {
                        System.out.print(" " + (int) vec50Mejores[0][j] + " , ");
                    } else {
                        System.out.print((int) vec50Mejores[0][j] + " , ");
                    }
                }
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
        a.intercambioPosiciones(a.vecCaminos);
        a.muestraPrimeros50(a.vecCaminos);
        System.out.println("\nULTIMA Entrega---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Generacion Cromosoma\t\t\t\t\t\t\t\t\tContenido\t\t\t\t\t\t\t\t\tRecorrido");
        for (int i = 0; i < 100; i++) {
            a.intercambioPosiciones(a.vecCaminos);
            a.agregaCaminos_2();
            a.vecCaminos = a.distanciaCaminos(a.vecCaminos);
            a.muestraPrimeros50SinImprimir(a.vecCaminos);
            System.out.print("    "+i+"\t       "+(i+1)+"\t");
            a.muestraPrimerCamino();
            System.out.println("");
        }
    }
}
