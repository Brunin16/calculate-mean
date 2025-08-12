public class CalcAnual {
    private CalcSemetre cs;
    public Double mediaAnual(Double primeiroSem, Double segundoSem){
        return (primeiroSem * 0.4) + (segundoSem * 0.6);
    }
    public Double mediaAnual(){
        return (cs.calcularSemestre() * 0.4) + (cs.calcularSemestre() * 0.6);
    }
}
