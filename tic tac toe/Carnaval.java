import java.io.*;
public class Carnaval {
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        //llamada de clases//
        Xy0 objXy0 = new Xy0();
        Ruleta objRuleta = new Ruleta();
        //variables
        int opcion;
        // bucle while para repetir el menu//
        while (true){
            try{
                //menu//
                System.out.println("Menu de Juegos");
                System.out.println("1. Jugar a X y 0");
                System.out.println("2. Jugar a la ruleta");
                System.out.println("3. Salir");
                opcion = Integer.parseInt(leer.readLine());
                if (opcion == 1){
                    // valiables para esta opcion//
                    int jugador;
                    int posicion;
                    System.out.println("Turno a jugar");
                    jugador = Integer.parseInt(leer.readLine());
                    //while para el juego//
                    while (true) {
                        objXy0.printablero();
                        try {
                            System.out.print("jugador " + jugador + ", ingrese un numeor del 1 al 9 para hacer el movimiendo: ");
                            posicion = Integer.parseInt(leer.readLine());
                        } catch (Exception e) {
                            System.out.println("Entrada invalida. porvor ingrese un numero del 1 al 9");
                            continue;
                        }
                        try{
                            // se realiza el movimiento del juego y demas aciones//
                            objXy0.movimiento(posicion,jugador);
                            System.out.println("Después de movimiento:");
                            objXy0.printablero();   
                            if (objXy0.Win(jugador)) {
                                System.out.println("Después de victoria:");
                                objXy0.printablero();
                                System.out.println("jugador " + objXy0.turno(jugador) + " a ganado!");
                                objXy0.reiniciarJuego();
                                break;
                                // aqui es para ver si el tablero esta lleno//
                            } else if (objXy0.tableroFull()) {
                                System.out.println("Tablero lleno:");
                                objXy0.printablero();
                                System.out.println("nadie gana!");
                                objXy0.reiniciarJuego();
                                break;
                            }
                            // esto cambia el turo ademas de anunciar el siguiente jugador// 
                            objXy0.cambiaTurno();
                            jugador = (jugador == 1) ? 2 : 1;
                            System.out.println("siguiente jugador: " + jugador);
                        } catch ( Exception e){
                            System.out.println("Error: " + e.getMessage());
                            continue;
                        }
                    }
                } else if (opcion == 2){
                    //vairables de la opcion 2//
                    double saldoInicial = 100.00;
                    double saldoActual = saldoInicial;
                    // imprimimos el saldo inicial//
                    System.out.println("¡Bienvenido a la ruleta!");
                    System.out.println("Saldo inicial: $" + saldoInicial);
                    //entramos al bucle siendo el saldo inicial simpere mayor a 0 //
                    while (saldoActual > 0) {
                        System.out.print("precione enter para continuar o  escriba'salir' para salir): ");
                        String entrada = leer.readLine();
                        if (entrada.equalsIgnoreCase("salir")) {
                            System.out.println("saliendo al menu");
                            break; 
                        }
                        //imprimimos los resultados etc//
                        System.out.println("Número aleatorio:" + objRuleta.naleatorio() );
                        // se agrega la ganancia al saldo inicia//
                        saldoActual += objRuleta.calcularGanancias();
                        System.out.println("Resultado de la ruleta: "+ objRuleta.resultado());
                        System.out.println("Ganancias acumuladas: $" + objRuleta.calcularGanancias());
                        System.out.println("Saldo actual: $" + saldoActual);
                    }
                    System.out.println("¡Gracias por jugar!");
                } else if (opcion == 3){
                    System.out.println("saliendo del programa");
                    break;
                }else {
                    System.out .println("opcion no valida, intente denuevo");
                }
            } catch (Exception error){
                System.out.println("error de tipo:"+ error +"Redirigiendo al menu");
                continue;
            }
        }
    }
}