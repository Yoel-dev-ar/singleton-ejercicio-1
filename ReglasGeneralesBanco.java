public class ReglasGeneralesBanco {
    private static ReglasGeneralesBanco instancia;

    private String nombreBanco;
    private double montoMaximoTransferencia;
    private double interesPlazoFijo;

    private ReglasGeneralesBanco() {
        this.nombreBanco = "Banco Andino";
        this.montoMaximoTransferencia = 5000000.00;
        this.interesPlazoFijo = 38.5;
    }

    public static ReglasGeneralesBanco getInstancia() {
        if (instancia == null) {
            instancia = new ReglasGeneralesBanco();
        }
        return instancia;
    }

    public void cambiarMontoMaximoTransferencia(double nuevoMonto) {
        this.montoMaximoTransferencia = nuevoMonto;
    }

    public void cambiarInteresPlazoFijo(double nuevoInteres) {
        this.interesPlazoFijo = nuevoInteres;
    }

    public void mostrarReglas() {
        System.out.println("=== REGLAS GENERALES DEL BANCO ===");
        System.out.println("Banco: " + nombreBanco);
        System.out.println("Máximo para transferir por día: $" + montoMaximoTransferencia);
        System.out.println("Interés anual Plazo Fijo: " + interesPlazoFijo + "%");
    }
}