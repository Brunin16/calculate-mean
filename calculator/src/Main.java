public class Main {
    public static void main(String[] args) {
        CalcAnnual ca = new CalcAnnual();
        CalcSemester cs = new CalcSemester();
        Double primeiroSemestre = cs.calculateSemester();

        System.out.println("First semester mean: " + primeiroSemestre);

        Double segundoSemestre = cs.calculateSemester();
        System.out.println("Second semester mean: " + segundoSemestre);

        Double mediaAnual = ca.meanAnnual(primeiroSemestre, segundoSemestre);
        System.out.println("Annual Mean: " + mediaAnual);
    }
}