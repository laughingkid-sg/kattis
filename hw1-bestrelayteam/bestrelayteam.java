import java.util.Arrays;
import java.util.*;

class bestrelayteam {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while (io.hasMoreTokens()) {

            int runnerCount = io.getInt();
            Runner[] runnersArr = new Runner[runnerCount];

            for (int i = 0; i < runnerCount; i++) {
                Runner runner = new Runner(io.getWord(), io.getDouble(), io.getDouble());
                runnersArr[i] = runner;
            }
            
            Arrays.sort(runnersArr, new SortByOtherLeg());

            double minTime = Double.MAX_VALUE;
            Runner leadRunner = null;
                 
            for (Runner runner : runnersArr) {

                double time = runner.getFirstLeg();
                int slots = 3;
                
                for (Runner otherRunner : runnersArr) {
                    if (!otherRunner.equals(runner)) {
                        time += otherRunner.getOtherLeg();
                        slots--;
                    }

                    if (slots == 0) 
                        break;
                }

                if (minTime > time) {
                    minTime = time;
                    leadRunner = runner;
                }
            }
            
            StringBuilder result = new StringBuilder();
            result.append(String.valueOf(minTime) + "\n");
            result.append(String.valueOf(leadRunner) + "\n");

            int slots = 3;
            for (Runner otherRunner : runnersArr) {
                if (!otherRunner.equals(leadRunner)) {
                    result.append(otherRunner.getName() + "\n");
                    slots--;
                }
                if (slots == 0)
                    break;
            }
            io.println(result);
        }
        io.close();
    }
}

class Runner {
    protected String runnerName;
    protected double firstLeg;
    protected double otherLeg;

    public Runner(String runnerName, double firstLeg, double otherLeg) {
        this.runnerName = runnerName;
        this.firstLeg = firstLeg;
        this.otherLeg = otherLeg;
    }

    public String getName() {
        return this.runnerName;
    }

    public double getFirstLeg() {
        return this.firstLeg;
    }

    public double getOtherLeg() {
        return this.otherLeg;
    }

    @Override
    public String toString() {
        return this.runnerName;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Runner) {
            Runner runner = (Runner) o;
            return this.runnerName == runner.getName();
        } else {
            return false;
        }
    }
}

class SortByOtherLeg implements Comparator<Runner> {
    
    public int compare(Runner a, Runner b) {
        return a.getOtherLeg() - b.getOtherLeg() > 0
            ? 1
            : a.getOtherLeg() - b.getOtherLeg() < 0
                ? -1
                : 0;
    }
}



