//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CalcAnual ca = new CalcAnual();
        CalcSemetre cs = new CalcSemetre();

        System.out.println(ca.MediaMensal(cs.CalcularSemestre(), cs.CalcularSemestre()));
    }
}