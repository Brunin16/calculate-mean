public class CalcAnnual {
    private CalcSemester cs;
    public Double meanAnnual(Double firstSemester, Double secondSemester){
        return (firstSemester * 0.4) + (secondSemester * 0.6);
    }
    public Double meanAnnual(){
        return (cs.calculateSemester() * 0.4) + (cs.calculateSemester() * 0.6);
    }
}
