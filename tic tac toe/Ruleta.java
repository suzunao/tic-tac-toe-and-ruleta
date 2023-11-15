public class Ruleta {
    // asignamos numero saleatorios a el jugador entrante//
    public int  naleatorio(){
        int naleatorio = (int) (Math.random() * 11);
        return naleatorio;
    }
    public int resultado(){
        int nasignado = naleatorio() * 2;
        return nasignado;
    }
    // le asignamos las ganancias//
    public double calcularGanancias() {
        if (naleatorio() == resultado()) {
            return naleatorio() * 2.0;
        } else if (naleatorio() % 2 == resultado() % 2) {
            return naleatorio() * 1.0;
        } else {
            return -naleatorio();
        }
    }
}