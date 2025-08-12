import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcSemetre {
    Scanner sc = new Scanner(System.in);

    Double calculaPCC(List<Double> cps,List<Double> sprints ){
        Double mediaCps = 0.0;
        Double mediaSprints = 0.0;
        for(int i = 0; i < cps.size(); i++){
            mediaCps += cps.get(i);
        }
        mediaCps /= cps.size();
        for(int i = 0; i < sprints.size(); i++){
            mediaSprints += sprints.get(i);
        }
        mediaSprints /= sprints.size();
        return (mediaCps + mediaSprints) / 2;
    }

    void excluirMenorNota(List<Double> cps){
        double menorNota = 100;
        int indexMenorNota = 0;
        for(int i =0 ; i < cps.size() ; i++){
            if (cps.get(i) < menorNota){
                menorNota = cps.get(i);
                indexMenorNota = i;
            }
        }
        cps.remove(indexMenorNota);
    }
    Double CalcularSemestre(){
        List<Double> cps = new ArrayList<>();
        Double cp;
        List<Double> sprints = new ArrayList<>();
        Double sprint;
        Double gs;

        for (int i = 1; i <= 3; i++) {
            while (true) {
                try {
                    System.out.println("Qual sua nota do cp" + i + ":");
                    cp = sc.nextDouble();
                    if (cp < 0 || cp > 10) {
                        throw new Exception("Nota inválida! A nota deve estar entre 0 e 10.");
                    }
                    cps.add(cp);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage() + " Tente novamente.");
                    sc.nextLine();
                }
            }
        }
        excluirMenorNota(cps);

        for (int i = 1; i <= 2; i++) {
            while (true) {
                try {
                    System.out.println("Qual sua nota do sprint" + i + ":");
                    sprint = sc.nextDouble();
                    if (sprint < 0 || sprint > 10) {
                        throw new Exception("Nota inválida! A nota deve estar entre 0 e 10.");
                    }
                    sprints.add(sprint);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage() + " Tente novamente.");
                    sc.nextLine();
                }
            }
        }
        while (true) {
            try {
                System.out.println("Qual sua nota da gs");
                gs = sc.nextDouble();
                if (gs < 0 || gs > 10) {
                    throw new Exception("Nota inválida! A nota deve estar entre 0 e 10.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Tente novamente.");
                sc.nextLine();
            }
        }
        Double pcc = calculaPCC(cps, sprints);
        return (pcc * 0.4) + (gs* 0.6);
    }
}
