package main.annotations;

import java.util.ArrayList;
import java.util.List;

public class SomeClassSafeVarargs {
    private List<String> versions = new ArrayList<>();

    @SafeVarargs
    public final void safe(String... toAdd) {
        for (String version : toAdd) {
            versions.add(version);
        }
    }
}
class Main{
    public static void main(String[] args) {
        SomeClassSafeVarargs someClassSafeVarargs = new SomeClassSafeVarargs();
        someClassSafeVarargs.safe("One","two","...");
    }
}