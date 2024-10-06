package ua.edu.ucu.apps.tempseries;

public final class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis temps) {
        avgTemp = temps.average();
        devTemp = temps.deviation();
        minTemp = temps.min();
        maxTemp = temps.max();
    }

    //for testing
    public TempSummaryStatistics(double av, double dev, 
    double min, double max) {
        avgTemp = av;
        devTemp = dev;
        minTemp = min;
        maxTemp = max;
    }

    public String toString() {
        String res = "Statistics:\n - average temperature: " + avgTemp 
        + "\n - deviation of temperatures: " + devTemp
        + "\n - minimal temperature: " + minTemp
        + "\n - maximal temperature: " + maxTemp;
        return res;
    }
}