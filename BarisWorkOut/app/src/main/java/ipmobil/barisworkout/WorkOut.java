package ipmobil.barisworkout;

/**
 * Created by Barre on 2017-11-19.
 */

public class WorkOut {
    String workout;
    int reps;
    int weight;

    public WorkOut(String str, int reps, int weight){
        workout=str;
        this.reps=reps;
        this.weight=weight;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "workout= " + workout +
                "\nreps= " + reps +
                "\nweight= " + weight+ " Kg";
    }
}
