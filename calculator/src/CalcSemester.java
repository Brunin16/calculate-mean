import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcSemester {
    Scanner sc = new Scanner(System.in);

    private Double calculatePcc(List<Double> cpsGrades,List<Double> sprintsGrades ){
        Double meanCps = cpsGrades.stream()
                            .mapToDouble(Double::doubleValue)
                            .average()
                            .orElse(0.0);
        Double meanSprints = sprintsGrades.stream()
                                    .mapToDouble(Double::doubleValue)
                                    .average()
                                    .orElse(0.0);

        return (meanCps + meanSprints) / 2;
    }

    private void removingLowestGrade(List<Double> cpsGrades){
        double lowestGrade = cpsGrades.stream()
                            .min(Double::compare)
                            .orElseThrow();
        
        cpsGrades.remove((Double) lowestGrade);
    }

    public Double calculateSemester(){
        List<Double> cps = new ArrayList<>();
        Double CP;
        List<Double> sprints = new ArrayList<>();
        Double sprint;
        Double GS;

        for (int i = 1; i <= 3; i++) {
            while (true) {
                try {
                    System.out.println("What is your CP grade?" + i + ":");
                    CP = sc.nextDouble();
                    if (CP < 0 || CP > 10) {
                        throw new Exception("Invalid grade! Grade must be between 0 and 10.");
                    }
                    cps.add(CP);
                    break;
                } catch (Exception e) {
                    String msg = (e.getMessage() != null)? e.getMessage() : "Invalid input!";
                    System.out.println(msg + " Try again.");
                    sc.nextLine();
                }
            }
        }
        removingLowestGrade(cps);

        for (int i = 1; i <= 2; i++) {
            while (true) {
                try {
                    System.out.println("What is your sprint grade" + i + ":");
                    sprint = sc.nextDouble();
                    if (sprint < 0 || sprint > 10) {
                        throw new Exception("Invalid grade! Grade must be between 0 and 10.");
                    }
                    sprints.add(sprint);
                    break;
                } catch (Exception e) {
                    String msg = (e.getMessage() != null)? e.getMessage() : "Invalid input!";
                    System.out.println(msg + " Try again.");
                    sc.nextLine();
                }
            }
        }
        while (true) {
            try {
                System.out.println("What is your GS grade");
                GS = sc.nextDouble();
                if (GS < 0 || GS > 10) {
                    throw new Exception("Invalid grade! Grade must be between 0 and 10.");
                }
                break;
            } catch (Exception e) {
                    String msg = (e.getMessage() != null)? e.getMessage() : "Invalid input!";
                    System.out.println(msg + " Try again.");
                    sc.nextLine();
                }
        }
        Double pcc = calculatePcc(cps, sprints);
        return (pcc * 0.4) + (GS* 0.6);
    }
}
