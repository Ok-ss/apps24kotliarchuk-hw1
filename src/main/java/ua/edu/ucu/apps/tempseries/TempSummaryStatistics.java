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
    public TempSummaryStatistics(double[] args) {
        avgTemp = args[0];
        devTemp = args[1];
        minTemp = args[2];
        maxTemp = args[3];
    }

    public String ToString() {
        String res = "Statistics:\n - average temperature: " + avgTemp + 
        "\n - deviation of temperatures: " + devTemp + 
        "\n - minimal temperature: " + minTemp +
        "\n - maximal temperature: " + maxTemp;
        return res;
    }
}