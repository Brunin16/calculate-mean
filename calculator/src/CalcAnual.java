public class CalcAnual {
    private CalcSemetre cs;
    public Double MediaMensal(Double primeiroSem, Double segundoSem){
        return (primeiroSem * 0.4) + (segundoSem * 0.6);
    }
    public Double MediaMensal(){
        return (cs.CalcularSemestre() * 0.4) + (cs.CalcularSemestre() * 0.6);
    }
}
