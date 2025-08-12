public class Main {
    public static void main(String[] args) {
        CalcAnual ca = new CalcAnual();
        CalcSemetre cs = new CalcSemetre();
        Double primeiroSemestre = cs.calcularSemestre();

        System.out.println("Media Mensal do Primeiro Semestre: " + primeiroSemestre);

        Double segundoSemestre = cs.calcularSemestre();
        System.out.println("Media Mensal do Segundo Semestre: " + segundoSemestre);

        Double mediaAnual = ca.mediaAnual(primeiroSemestre, segundoSemestre);
        System.out.println("Media Anual: " + mediaAnual);
    }
}