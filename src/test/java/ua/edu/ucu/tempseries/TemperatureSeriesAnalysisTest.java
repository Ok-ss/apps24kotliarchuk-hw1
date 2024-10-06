package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {


    // @Test
    // public void testAv() {
    //     double[] temperatureSeries = {-1.0};
    //     TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    //     double expResult = -1.0;

    //     double actualResult = seriesAnalysis.average();
    //     assertEquals(expResult, actualResult, 0.00001);
    // }

    //AVERAGE
   @Test
   public void testAverageWithOneElementArray() {
       // setup input data and expected result
       double[] temperatureSeries = {-1.0};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = -1.0;

       // call tested method
       double actualResult = seriesAnalysis.average();

       // compare expected result with actual result
       assertEquals(expResult, actualResult, 0.00001);
    }

   @Test(expected = IllegalArgumentException.class)
   public void testAverageWithEmptyArray() {
       double[] temperatureSeries = {};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

       // expect exception here
       seriesAnalysis.average();
    }

   @Test
   public void testAverage() {
       double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = 1.0;

       double actualResult = seriesAnalysis.average();

       assertEquals(expResult, actualResult, 0.00001);
    }
    
   //DEVIATION
   @Test
    public void testOneElementDeviation() {
        double[] temperatureSeries = {12.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoElenemtDeviation() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double actualResult = seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {-6.0, -2.0, 0, 2.0, 6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 4.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

}
