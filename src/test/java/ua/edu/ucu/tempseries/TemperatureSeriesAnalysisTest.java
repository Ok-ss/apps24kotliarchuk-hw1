package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

import ua.edu.ucu.apps.tempseries.TempSummaryStatistics;
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

    //CONSTRUCTOR
    @Test
    public void testEmptyConstructor() {
        TemperatureSeriesAnalysis temps = new TemperatureSeriesAnalysis();
        double[] empty = {};
        assertArrayEquals(empty, temps.series(), 0);
        assertEquals(0, temps.getSize());
    }

    @Test(expected = InputMismatchException.class)
    public void testIncorrectInputConstructor() {
        double[] temperatureSeries = {-1.0, 4.6, -275};
        new TemperatureSeriesAnalysis(temperatureSeries);
    }

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

        //LESS THAN VALUE
        @Test
        public void testNoElementLessThan() {
            double[] temperatureSeries = {};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {};
    
            double[] actualResult = seriesAnalysis.findTempsLessThen(6.0);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testOneElementLessThan() {
            double[] temperatureSeries = {3.6};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {3.6};
    
            double[] actualResult = seriesAnalysis.findTempsLessThen(6.0);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testLessThan() {
            double[] temperatureSeries = {-4.0, -0.5, 16.2, 11.4, 2.0};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {-4.0, -0.5, 2.0};
    
            double[] actualResult = seriesAnalysis.findTempsLessThen(6.0);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        //GREATER THAN VALUE
        @Test
        public void testNoElementGreaterThan() {
            double[] temperatureSeries = {};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {};
    
            double[] actualResult = seriesAnalysis.findTempsGreaterThen(6.0);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testOneElementGreaterThan() {
            double[] temperatureSeries = {3.6};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {};
    
            double[] actualResult = seriesAnalysis.findTempsGreaterThen(6.0);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testGreaterThan() {
            double[] temperatureSeries = {-4.0, -0.5, 16.2, 11.4, 2.0};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {16.2, 11.4};
    
            double[] actualResult = seriesAnalysis.findTempsGreaterThen(6.0);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testEqualsGreaterThan() {
            double[] temperatureSeries = {-4.0, -0.5, 16.2, 11.4, 2.0, 10.8};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {16.2, 11.4, 10.8};
    
            double[] actualResult = seriesAnalysis.findTempsGreaterThen(10.8);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }


        
        //VALUES IN RANGE
        @Test
        public void testNoElementRange() {
            double[] temperatureSeries = {};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {};
    
            double[] actualResult = seriesAnalysis.findTempsInRange(6.0, 100);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testOneElementRange() {
            double[] temperatureSeries = {3.6};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {3.6};
    
            double[] actualResult = seriesAnalysis.findTempsInRange(3.0, 6.0);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testRange() {
            double[] temperatureSeries = {-4.0, -0.5, 16.2, 11.4, 2.0};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {11.4, 2.0};
    
            double[] actualResult = seriesAnalysis.findTempsInRange(0, 12);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testEqualsRange() {
            double[] temperatureSeries = {-4.0, -0.5, 16.2, 11.4, 2.0, 10.8};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {-0.5, 11.4, 2.0, 10.8};
    
            double[] actualResult = seriesAnalysis.findTempsInRange(-0.5, 11.4);
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        //RESET
        @Test
        public void testEmptyReset() {
            double[] temperatureSeries = {};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {};
    
            seriesAnalysis.reset();
            double[] actualResult = seriesAnalysis.series();
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testReset() {
            double[] temperatureSeries = {-4.0, -0.5, 16.2, 11.4, 2.0, 10.8};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {};
    
            seriesAnalysis.reset();
            double[] actualResult = seriesAnalysis.series();
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        //SORT
        @Test
        public void testEmptySort() {
            double[] temperatureSeries = {};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {};
    
            double[] actualResult = seriesAnalysis.sortTemps();
    
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testOneElementSort() {
            double[] temperatureSeries = {-0.5};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {-0.5};
    
            double[] actualResult = seriesAnalysis.sortTemps();
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        @Test
        public void testSort() {
            double[] temperatureSeries = {-0.5, 16.2, -4.0, 11.4, 2.0, 10.8};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] expResult = {-4.0, -0.5, 2.0, 10.8, 11.4, 16.2};
    
            double[] actualResult = seriesAnalysis.sortTemps();
            assertArrayEquals(expResult, actualResult, 0.00001);
        }

        //STATISICS

        @Test(expected = IllegalArgumentException.class)
        public void testEmptyArrayStatistic() {
            double[] temperatureSeries = {};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        
            seriesAnalysis.summaryStatistics();
        }

        @Test
        public void testOneElementStatistics() {
            double[] temperatureSeries = {4.6};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] setOfVals = {4.6, 0, 4.6, 4.6};
            TempSummaryStatistics expResult = new TempSummaryStatistics(setOfVals);

            TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();


            assertEquals(expResult.ToString(), actualResult.ToString());
        }

        @Test
        public void testStatistics() {
            double[] temperatureSeries = {-6.0, -2.0, 0, 2.0, 6.0};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] setOfVals = {0, 4.0, -6, 6};
            TempSummaryStatistics expResult = new TempSummaryStatistics(setOfVals);

            TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

            assertEquals(expResult.ToString(), actualResult.ToString());
        }

        //TEST ADDING NEW TEMPS
        @Test
        public void testAddingEmpty() {
            double[] temperatureSeries = {-6.0, -2.0, 0, 2.0, 6.0};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] newTemps = {};
            int expResult = 5;

            int actualResult = seriesAnalysis.addTemps(newTemps);

            assertEquals(expResult, actualResult);
        }

        @Test
        public void testAddingToEmpty() {
            double[] temperatureSeries = {};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] newTemps = {-6.0, -2.0, 0, 2.0, 6.0};
            int expResult = 5;

            int actualResult = seriesAnalysis.addTemps(newTemps);

            assertEquals(expResult, actualResult);
        }

        @Test
        public void testAddingWithEnlargening() {
            double[] temperatureSeries = {-0.5, 16.2, -4.0, 11.4, 2.0, 10.8};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] newTemps = {-2.0, 0, 6.0};
            int expResult = 9;

            int actualResult = seriesAnalysis.addTemps(newTemps);

            assertEquals(expResult, actualResult);
        }

        @Test
        public void testAddingWithoutEnlargening() {
            double[] temperatureSeries = {-0.5, 16.2, -4.0, 11.4, 2.0, 10.8};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] newTemps = {-2.0, 0, 6.0};
            seriesAnalysis.addTemps(newTemps);


            double[] moreTemps = {-6.0};
            int expResult = 10;

            int actualResult = seriesAnalysis.addTemps(moreTemps);

            assertEquals(expResult, actualResult);
        }

        @Test(expected = InputMismatchException.class)
        public void testAddingInvalidInput() {
            double[] temperatureSeries = {-0.5, 16.2, -4.0, 11.4, 2.0, 10.8};
            TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
            double[] newTemps = {-2.0, 0, 6.0, -290};
            seriesAnalysis.addTemps(newTemps);
        }
}
