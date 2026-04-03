class BirdWatcher {

    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return this.birdsPerDay;
    }

    public int getToday() {
        return this.birdsPerDay[this.birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.birdsPerDay.length - 1] += 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int i : this.birdsPerDay) {
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int totalBirds = 0;

        numberOfDays = Math.min(numberOfDays, birdsPerDay.length);

        for (int i = 0; i < numberOfDays; i++) {
            totalBirds += this.birdsPerDay[i];
        }

        return totalBirds;
    }

    public int getBusyDays() {
        int busyDays = 0;

        for (int i : this.birdsPerDay) {
            if (i >= 5) {
                busyDays += 1;
            }
        }

        return busyDays;
    }
}
