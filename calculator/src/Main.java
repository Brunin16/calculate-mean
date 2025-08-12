public class Main {
    public static void main(String[] args) {
        CalcAnual ca = new CalcAnual();
        CalcSemetre cs = new CalcSemetre();
        Double primeiroSemestre = cs.CalcularSemestre();

        System.out.println("Media Mensal do Primeiro Semestre: " + primeiroSemestre);

        Double segundoSemestre = cs.CalcularSemestre();
        System.out.println("Media Mensal do Segundo Semestre: " + segundoSemestre);

        Double mediaAnual = ca.MediaMensal(primeiroSemestre, segundoSemestre);
        System.out.println("Media Anual: " + mediaAnual);
    }
}