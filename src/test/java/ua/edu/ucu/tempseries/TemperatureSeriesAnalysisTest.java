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

        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {-6.0, -2.0, 0, 2.0, 6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 4.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    //MIN
    @Test
    public void testOneElementMin() {
        double[] temperatureSeries = {6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 6.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {-2.0, 0, 2.0, -3.0, 6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -3.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoElementMin() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.min();
    }

    //MAX
    @Test
    public void testOneElementMax() {
        double[] temperatureSeries = {6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 6.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {-2.0, 0, 2.0, -3.0, 6.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 6.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoElementMax() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.max();
    }

    //CLOSEST TO ZERO
    @Test(expected = IllegalArgumentException.class)
    public void testNoElementClosestToZero() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempClosestToZero();
    }

    @Test 
    public void testOneElementClosestToZero() {
        double[] temperatureSeries = {3.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.5;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZero() {
        double[] temperatureSeries = {-6.0, -2.0, 3.5, 24.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -2.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTwoValuesClosestToZero() {
        double[] temperatureSeries = {-6.0, -2.4, 2.4, 16.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.4;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

        //CLOSEST TO VALUE
        @Test(expected = IllegalArgumentException.class)
        public void testNoElementClosestToValue() {
            double[] temperatureSeries = {};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    
            seriesAnalysis.findTempClosestToValue(24.6);
        }
    
        @Test 
        public void testOneElementClosestToValue() {
            double[] temperatureSeries = {3.5};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double expResult = 3.5;
    
            double actualResult = seriesAnalysis.findTempClosestToValue(16.2);
    
            assertEquals(expResult, actualResult, 0.00001);
        }
    
        @Test
        public void testClosestToValue() {
            double[] temperatureSeries = {-6.0, -2.0, 3.5, 24.0};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double expResult = 3.5;
    
            double actualResult = seriesAnalysis.findTempClosestToValue(6.0);
    
            assertEquals(expResult, actualResult, 0.00001);
        }
    
        @Test
        public void testTwoValuesClosestToValue() {
            double[] temperatureSeries = {-6.0, -2.4, 4.0, 16.0};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double expResult = 16.0;
    
            double actualResult = seriesAnalysis.findTempClosestToValue(10.0);
    
            //Returns bigger of 2 values
            assertEquals(expResult, actualResult, 0.00001);
        }
}
