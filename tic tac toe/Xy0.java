public class Xy0 {
    public char[][] tablero = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    // esto es en caso de que el jugador desee volver a jugar//
    public void reiniciarJuego() {
        tablero = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    }
    // variables utilizadas en los metodos//
    public char j1 = 'X';
    public char j2 = 'O';
    public boolean turno = true;
    
    public char turno(int jugador){
        if (jugador == 1){
            return j1;
        }else if(jugador == 2){
            return j2;
        } else {
            return ' ';
        }
    }

    public void cambiaTurno() {
        turno = !turno;
    }
    
    public  void movimiento(int posicion, int jugador) {
        int f = (posicion - 1) / 3;
        int c = (posicion - 1) % 3;
        
        try {
            if (tablero[f][c] == 'X' || tablero[f][c] == 'O') {
                System.out.println("movimiento invalido.intente nuevamente");
            } else {
                tablero[f][c] = turno(jugador);
            }
        }catch(Exception e){
            System.out.println("pocicion ocupada intente nuevamente");
        }
    }

    public boolean Win(int turno) {
        // evaluamos en en tres direcioenes si hay ganador//
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == turno(turno) && tablero[i][1] == turno(turno) && tablero[i][2] == turno(turno)) ||
                (tablero[0][i] == turno(turno) && tablero[1][i] == turno(turno) && tablero[2][i] == turno(turno))) {
                return true;
            }
        }
        return (tablero[0][0] == turno(turno) && tablero[1][1] == turno(turno) && tablero[2][2] == turno(turno)) ||
            (tablero[0][2] == turno(turno) && tablero[1][1] == turno(turno) && tablero[2][0] == turno(turno));
    }

    public boolean tableroFull() {
        // vemos si el tabelero esata lleno ( si ya no hay espacios libres para colocar una X o un O) //
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] != 'X' && tablero[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
    // imprimimos el tablero//
    public void printablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j]);
                if (j < tablero[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < tablero[1].length -1) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }
}