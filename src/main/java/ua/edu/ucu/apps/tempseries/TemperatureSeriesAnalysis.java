package ua.edu.ucu.apps.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int size;
    private int IMPOSIBLE_TEMPERATURE = -273;

    //default consrtructor
    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[0];
        size = 0;
    }

    //constructor that accepts initial temperatureSeries
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] <= IMPOSIBLE_TEMPERATURE) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = new double[temperatureSeries.length];
        size = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            this.temperatureSeries[i] = temperatureSeries[i];
            size++;
        }

    }

    public double[] series() {
        double[] showcase = new double[size];
        for (int i = 0; i < size; i++) {
            showcase[i] = temperatureSeries[i];
        }
        return showcase;
    }

    public int getSize() {
        return size;
    }

    public double average() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += temperatureSeries[i];
        }
        return sum/size;
    }

    public double deviation() { 
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        double av = average();
        for (int i = 0; i < size; i++) {
            sum += (temperatureSeries[i]-av) * (temperatureSeries[i]-av);
        }

        return Math.sqrt(sum/size);
    }

    public double min() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double min = temperatureSeries[0];
        for (int i = 0; i < size; i++) {
            if (temperatureSeries[i] < min) {
                min = temperatureSeries[i];
            }
        }
        return min;
    }

    public double max() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double max = temperatureSeries[0];
        for (int i = 0; i < size; i++) {
            if (temperatureSeries[i] > max) {
                max = temperatureSeries[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        //returns the bigger of 2 values if result is tied
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double closestVal = temperatureSeries[0];
        double distance = Math.abs(closestVal-tempValue);
        for (int i = 0; i < size; i++) {
            if (Math.abs(temperatureSeries[i]-tempValue) < distance 
            || (Math.abs(temperatureSeries[i]-tempValue) == distance 
            && temperatureSeries[i] > 0)) {
                closestVal = temperatureSeries[i];
                distance = Math.abs(closestVal-tempValue);
            }
        }
        return closestVal;
    }

    public double[] findTempsLessThen(double tempValue) {
        //returns nothing in case of an empty array
        double[] results = new double[size];
        int pointer = 0;
        for (int i = 0; i < size; i++) {
            if (temperatureSeries[i] < tempValue) {
                results[pointer] = temperatureSeries[i];
                pointer++;
            }
        }
        double[] res = new double[pointer];
        for (int i = 0; i < res.length; i++) {
            res[i] = results[i];
        }
        return res;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        //returns nothing in case of an empty array
        double[] results = new double[size];
        int pointer = 0;
        for (int i = 0; i < size; i++) {
            if (temperatureSeries[i] >= tempValue) {
                results[pointer] = temperatureSeries[i];
                pointer++;
            }
        }
        double[] res = new double[pointer];
        for (int i = 0; i < res.length; i++) {
            res[i] = results[i];
        }
        return res;
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        double[] results = new double[size];
        int pointer = 0;
        for (int i = 0; i < size; i++) {
            if (temperatureSeries[i] <= upperBound 
            && temperatureSeries[i] >= lowerBound) {
                results[pointer] = temperatureSeries[i];
                pointer++;
            }
        }
        double[] res = new double[pointer];
        for (int i = 0; i < pointer; i++) {
            res[i] = results[i];
        }
        return res;
    }

    public void reset() {
        this.temperatureSeries = new double[0];
        size = 0;
    }

    public double[] sortTemps() {
        double[] res = new double[temperatureSeries.length];
        for (int i = 0; i < size; i++) {
            double current = temperatureSeries[i];
            int idx = 0;
            for (int j = 0; j < size; j++) {
                if (temperatureSeries[j] < current) {
                    idx++;
                }
            }
            res[idx] = current;
        }

        return res;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        //if original array isn`t big enough, new size is old size times 2
        //if original array is empty new size is the size of temps times 2
        
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] <= IMPOSIBLE_TEMPERATURE) {
                throw new InputMismatchException();
            }
        }

        if (temperatureSeries.length < size + temps.length && size != 0) {
            double[] newTemps = new double[size*2];
            for (int i = 0; i < size; i++) {
                newTemps[i] = temperatureSeries[i];
            }
            temperatureSeries = newTemps;
        }
        if (size == 0) {
            temperatureSeries = new double[temps.length*2];
        }
        for (int i = 0; i < temps.length; i++) {
            temperatureSeries[size+i] = temps[i];
            size++;
        }
        return size;
    }
}
