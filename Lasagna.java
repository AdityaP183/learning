public class Lasagna {

    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int minutes) {
        return expectedMinutesInOven() - minutes;
    }

    public int preparationTimeInMinutes(int numberOfLayers) {
        return 2 * numberOfLayers;
    }

    public int totalTimeInMinutes(int numberOfLayers, int timeInOven) {
        return (
            preparationTimeInMinutes(numberOfLayers) +
            remainingMinutesInOven(timeInOven)
        );
    }
}
