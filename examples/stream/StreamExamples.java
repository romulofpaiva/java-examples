package examples.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExamples {
    public StreamExamples() {

    }

    public void execute() {
        map();
    }

    private void map() {
        List<Test> test1 = Arrays.asList(new Test("Romulo", 4), 
        new Test("Cristiane", 7), 
        new Test("Samuel", 10),
        new Test("Mateus", 9));
        
        List<Test> test2 = Arrays.asList(new Test("Romulo", 10), 
        new Test("Cristiane", 9), 
        new Test("Samuel", 9),
        new Test("Mateus", 10));
        
        List<Test> average = test1.stream()
                            .map(n1 -> new Test(n1.getNome(), 
                                                 (n1.getNota() + test2.stream()
                                                                     .filter(n2 -> n2.getNome().equalsIgnoreCase(n1.getNome()))
                                                                     .findFirst()
                                                                     .orElse(new Test(n1.getNome(), 0))
                                                                     .getNota()) / 2))
                            .toList();

        System.out.println("Averages\n========");
        average.forEach(m -> System.out.println(m.getNome() + ": " + m.getNota()));
                                                            
    }
}
