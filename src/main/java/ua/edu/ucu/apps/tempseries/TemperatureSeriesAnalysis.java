package ua.edu.ucu.apps.tempseries;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = new double[temperatureSeries.length];
        for (int i = 0; i < temperatureSeries.length; i++) {
            this.temperatureSeries[i] = temperatureSeries[i];
        }
    }

    public double average() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            sum += temperatureSeries[i];
        }
        return sum/temperatureSeries.length;
    }

    public double deviation() { 
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        double av = average();
        for (int i = 0; i < temperatureSeries.length; i++) {
            sum += (temperatureSeries[i]-av) * (temperatureSeries[i]-av);
        }

        return Math.sqrt(sum/temperatureSeries.length);
    }

    public double min() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double min = temperatureSeries[0];
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < min) {
                min = temperatureSeries[i];
            }
        }
        return min;
    }

    public double max() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double max = temperatureSeries[0];
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] > max) {
                max = temperatureSeries[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double cl_val = temperatureSeries[0];
        double distance = Math.abs(cl_val);
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (Math.abs(temperatureSeries[i]) < distance || 
            (Math.abs(temperatureSeries[i]) == distance && temperatureSeries[i] > 0)) {
                cl_val = temperatureSeries[i];
                distance = Math.abs(cl_val);
            }
        }
        return cl_val;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        return null;
    }

    public void reset() {

    }

    public double[] sortTemps() {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
