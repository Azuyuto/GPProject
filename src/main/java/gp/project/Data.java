package gp.project;

import java.util.ArrayList;
import java.util.List;
@lombok.Data
public class Data {
    List<List<Integer>> INPUTS;
    List<Integer> OUTPUTS;

    public Data() {
        INPUTS = new ArrayList<>();
        OUTPUTS = new ArrayList<>();
    }
}
