import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcSemetre {
    Scanner sc = new Scanner(System.in);

    private Double calculaPCC(List<Double> cps,List<Double> sprints ){
        Double mediaCps = cps.stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .orElse(0.0);
        Double mediaSprints = sprints.stream()
                                    .mapToDouble(Double::doubleValue)
                                    .average()
                                    .orElse(0.0);

        return (mediaCps + mediaSprints) / 2;
    }

    private void excluirMenorNota(List<Double> cps){
        double menorNota = cps.stream()
                            .min(Double::compare)
                            .orElseThrow();
        
        cps.remove((Double) menorNota);
    }

    private Double pegarNota(String nome, List<Double> lista, Integer i) {
        Double nota;
        String msg = (i != null)?"Qual sua nota do " + nome + i + ":": "Qual sua nota do " + nome + ":";
        while (true) {
            try {
                System.out.println(msg);
                nota = sc.nextDouble();
                if (nota < 0 || nota > 10) {
                    throw new Exception("Nota inválida! A nota deve estar entre 0 e 10.");
                }
                lista.add(nota);
                break;
            } catch (Exception e) {
                String msge = (e.getMessage() != null)? e.getMessage() : "Entrada inválida!";
                System.out.println(msge + " Tente novamente.");
                sc.nextLine();
            }
        }
        return nota;
    }

    public Double calcularSemestre(){
        List<Double> cps = new ArrayList<>();
        List<Double> sprints = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            pegarNota("cp", cps, i);
        }
        excluirMenorNota(cps);

        for (int i = 1; i <= 2; i++) {
            pegarNota("sprints", sprints, i);
        }
        
        Double gs = pegarNota("gs", new ArrayList<>(), null);
        Double pcc = calculaPCC(cps, sprints);
        return (pcc * 0.4) + (gs* 0.6);
    }
}
