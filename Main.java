public class Main {
    public static void main(String[] args) {
        // La App del celular mira las reglas actuales
        ReglasGeneralesBanco reglasApp = ReglasGeneralesBanco.getInstancia();
        reglasApp.mostrarReglas();

        // Gerencia actualiza el interés y el monto máximo
        System.out.println("\n[Gerencia] Actualizando reglas del banco...");
        ReglasGeneralesBanco reglasGerencia = ReglasGeneralesBanco.getInstancia();
        reglasGerencia.cambiarInteresPlazoFijo(41.0);
        reglasGerencia.cambiarMontoMaximoTransferencia(8000000.00);

        // La App vuelve a mirar y ya tiene los valores nuevos
        System.out.println("\n[App Celular] Viendo reglas actualizadas:");
        reglasApp.mostrarReglas();
        System.out.println("¿Usan la misma pizarra?: " + (reglasApp == reglasGerencia));
    }
}