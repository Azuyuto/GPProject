package gp.project;

import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

@NoArgsConstructor
public class DataReader {

    public Data read() throws IOException {
        Data data = new Data();
        File file = new File("data.dat");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer tokens = new StringTokenizer(line);
            int tokensInLine = tokens.countTokens();
            List<Integer> input = new ArrayList<>();
            for (int i = 0; i < tokensInLine - 1; i++) {
                input.add(Integer.parseInt(tokens.nextToken()));
            }
            data.getINPUTS().add(input);
            Integer o = Integer.parseInt(tokens.nextToken());
            data.getOUTPUTS().add(o);
        }
        return data;
    }
}
