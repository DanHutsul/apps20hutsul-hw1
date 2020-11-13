package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.InputMismatchException;
import main.java.ua.edu.ucu.tempseries.TemperatureSeriesAnalysis;
import main.java.ua.edu.ucu.tempseries.TempSummaryStatistics;

public class TemperatureSeriesAnalysisTest {
    /** Needed Variables*/
    private TemperatureSeriesAnalysis tempSeriesOneElement;
    private TemperatureSeriesAnalysis tempSeriesEmpty;
    private TemperatureSeriesAnalysis tempSeriesSame;
    private TemperatureSeriesAnalysis tempSeriesNormal1;
    private TemperatureSeriesAnalysis tempSeriesNormal2;
    private TemperatureSeriesAnalysis tempSeriesOppositeValues;


    @Before
    public void setUp(){
        double[] temperatureSeriesOne = {2.0};
        double[] temperatureSeriesEmpty = {};
        double[] temperatureSeriesSame = {5.0, 5.0, 5.0};
        double[] temperatureSeriesNormal = {3.0, -4.0, 1.0, 4.0};
        double[] temperatureSeriesSecondNormal = {5.0, 30.0};
        double[] temperatureSeriesOpposite = {10.0, -10.0, 1.0, -1.0, 5.0, -5.0};
        this.tempSeriesOneElement = new TemperatureSeriesAnalysis(temperatureSeriesOne);
        this.tempSeriesEmpty = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);
        this.tempSeriesSame = new TemperatureSeriesAnalysis(temperatureSeriesSame);
        this.tempSeriesNormal1 = new TemperatureSeriesAnalysis(temperatureSeriesNormal);
        this.tempSeriesNormal2 = new TemperatureSeriesAnalysis(temperatureSeriesSecondNormal);
        this.tempSeriesOppositeValues = new TemperatureSeriesAnalysis(temperatureSeriesOpposite);
    }

    /** Average Tests*/
    @Test
    public void testAverageOneElementArray() {
        double expResult = 2.0;
        double actualResult = tempSeriesOneElement.average();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageEmptyArray() {
        tempSeriesEmpty.average();
    }

    @Test
    public void testAverageSameTemperatures() {
        double expResult = 5.0;
        double actualResult = tempSeriesSame.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAverage() {
        double expResult = 1.0;
        double actualResult = tempSeriesNormal1.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /** Deviation Tests*/
    @Test
    public void testDeviationOneElementArray() {
        double expResult = 0.0;
        double actualResult = tempSeriesOneElement.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDeviationEmptyArray() {
        tempSeriesEmpty.deviation();
    }

    @Test
    public void testDeviationSameTemperatures() {
        double expResult = 0.0;
        double actualResult = tempSeriesSame.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviation() {
        double expResult = 12.5;
        double actualResult = tempSeriesNormal2.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /** Min Tests*/
    @Test
    public void testMinOneElementArray() {
        double expResult = 2.0;
        double actualResult = tempSeriesOneElement.min();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMinEmptyArray() {
        tempSeriesEmpty.min();
    }

    @Test
    public void testMinSameTemperatures() {
        double expResult = 5.0;
        double actualResult = tempSeriesSame.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        double expResult = -4.0;
        double actualResult = tempSeriesNormal1.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /** Max Tests*/
    @Test
    public void testMaxOneElementArray() {
        double expResult = 2.0;
        double actualResult = tempSeriesOneElement.max();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMaxEmptyArray() {
        tempSeriesEmpty.max();
    }

    @Test
    public void testMaxSameTemperatures() {
        double expResult = 5.0;
        double actualResult = tempSeriesSame.max();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testMax() {
        double expResult = 4.0;
        double actualResult = tempSeriesNormal1.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /** findTempClosestToZero Tests*/
    @Test
    public void testFindTempClosestToZeroElementArray() {
        double expResult = 2.0;
        double actualResult = tempSeriesOneElement.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroEmptyArray() {
        tempSeriesEmpty.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZeroSameTemperatures() {
        double expResult = 5.0;
        double actualResult = tempSeriesSame.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroSameDistanceValuesOppositeSigns(){
        double expResult = -1.0;
        double actualResult = tempSeriesOppositeValues.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero() {
        double expResult = 1.0;
        double actualResult = tempSeriesNormal1.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    /** findTempClosestToValue Tests*/
    @Test
    public void testFindTempClosestToValueElementArray() {
        double expResult = 2.0;
        double actualResult = tempSeriesOneElement.findTempClosestToValue(2.0);

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueEmptyArray() {
        tempSeriesEmpty.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToValueSameTemperatures() {
        double expResult = 5.0;
        double actualResult = tempSeriesSame.findTempClosestToValue(100.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueSameDistanceValuesOppositeSigns(){
        double expResult = 10.0;
        double actualResult = tempSeriesOppositeValues.findTempClosestToValue(10.5);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue() {
        double expResult = 4.0;
        double actualResult = tempSeriesNormal1.findTempClosestToValue(100.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    /** findTempsLessThen Tests*/
    @Test
    public void testFindTempsLessThenElementArray() {
        double[] expResult = {2.0};
        double[] actualResult = tempSeriesOneElement.findTempsLessThen(3.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testFindTempsLessThenSameTemperatures() {
        double[] expResult = {5.0, 5.0, 5.0};
        double[] actualResult = tempSeriesSame.findTempsLessThen(100.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenEmpty() {
        double[] expResult = {};
        double[] actualResult = tempSeriesNormal1.findTempsLessThen(-15.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] expResult = {-4.0, 1.0};
        double[] actualResult = tempSeriesNormal1.findTempsLessThen(2.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    /** findTempsGreaterThen Tests*/
    @Test
    public void testFindTempsGreaterThenElementArray() {
        double[] expResult = {2.0};
        double[] actualResult = tempSeriesOneElement.findTempsGreaterThen(-3.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenSameTemperatures() {
        double[] expResult = {5.0, 5.0, 5.0};
        double[] actualResult = tempSeriesSame.findTempsGreaterThen(1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenEmpty() {
        double[] expResult = {};
        double[] actualResult = tempSeriesNormal1.findTempsGreaterThen(15.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] expResult = {3.0, 4.0};
        double[] actualResult = tempSeriesNormal1.findTempsGreaterThen(3.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    /** summaryStatistics Tests*/
    @Test
    public void testSummaryStatisticsOneElementArray() {
        TempSummaryStatistics expResult = new TempSummaryStatistics(2, 0.0,
                2, 2);
        TempSummaryStatistics actualResult = tempSeriesOneElement.summaryStatistics();


        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.00001);
        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.00001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.00001);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsEmptyArray() {
        tempSeriesEmpty.summaryStatistics();
    }

    @Test
    public void testSummaryStatisticsSameTemperatures() {
        TempSummaryStatistics expResult = new TempSummaryStatistics(5.0, 0.0, 5.0, 5.0);
        TempSummaryStatistics actualResult = tempSeriesSame.summaryStatistics();

        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.00001);
        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.00001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.00001);
    }


    @Test
    public void testSummaryStatistics() {
        TempSummaryStatistics expResult = new TempSummaryStatistics(17.5, 12.5, 5.0, 30.0);
        TempSummaryStatistics actualResult = tempSeriesNormal2.summaryStatistics();

        assertEquals(expResult.getAvgTemp(), actualResult.getAvgTemp(), 0.00001);
        assertEquals(expResult.getDevTemp(), actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult.getMinTemp(), actualResult.getMinTemp(), 0.00001);
        assertEquals(expResult.getMaxTemp(), actualResult.getMaxTemp(), 0.00001);
    }

    /** addTemps Tests */
    @Test
    public void testAddTempsOneElementArray() {
        double expResult = 2;
        double actualResult = tempSeriesOneElement.addTemps(-1.0);

        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = InputMismatchException.class)
    public void testAddTempsWrongValues() {
        tempSeriesEmpty.addTemps(-330.0, 100.0, -299.0);
    }

    @Test
    public void testAddTempsSameTemperatures() {
        double expResult = 5;
        double actualResult = tempSeriesSame.addTemps(25.0, 25.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTemps() {
        double expResult = 7;
        double actualResult = tempSeriesNormal1.addTemps(44.0, 99.7, 32.9);

        assertEquals(expResult, actualResult, 0.00001);
    }
}
