package main.java.ua.edu.ucu.tempseries;


import java.util.Arrays;
import java.util.InputMismatchException;
import main.java.ua.edu.ucu.tempseries.TempSummaryStatistics;

public class TemperatureSeriesAnalysis {
    private int capacity = 50;
    private int absMinTemp = -273;
    private double[] tempSeries;

    public TemperatureSeriesAnalysis() {
        this.tempSeries = new double[capacity];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        tempSeries = new double[temperatureSeries.length];
        for (double temp : temperatureSeries) {
            if (temp < absMinTemp) {
                tempSeries = new double[capacity];
                throw new InputMismatchException("Wrong values in given series!");
            }
        }
        this.tempSeries = temperatureSeries;
    }

    public double average() {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException("The series is empty!");
        }
        int length = tempSeries.length;
        double sum = 0.0;
        double averageTemp;
        for (double temp : tempSeries) {
            sum += temp;
        }
        averageTemp = sum/length;
        return averageTemp;
    }

    public double deviation() {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException("The series is empty!");
        }
        double deviationTemp;
        double standardDeviation = 0.0;
        double averageTemp = this.average();
        int length = tempSeries.length;
        for (double temp : tempSeries) {
            double difference = temp - averageTemp;
            double tempValue = Math.pow(difference, 2);
            standardDeviation += tempValue;
        }
        deviationTemp = Math.sqrt(standardDeviation/length);
        return deviationTemp;
    }

    public double min() {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double minTemp = Double.MAX_VALUE;

        for (double temp : tempSeries) {
            if (temp < minTemp) {
                minTemp = temp;
            }
        }
        return minTemp;
    }

    public double max() {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double maxTemp = (-1)*Double.MAX_VALUE;

        for (double temp : tempSeries) {
            if (temp > maxTemp) {
                maxTemp = temp;
            }
        }
        return maxTemp;
    }

    public double findTempClosestToZero() {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double minTempDiff = Double.MAX_VALUE;
        double closest = tempSeries[0];
        for (double temp : tempSeries) {
            double tempDiff = Math.abs(tempValue - temp);
            if (tempDiff <= minTempDiff) {
                minTempDiff = tempDiff;
                closest = temp;
            }
        }
        return closest;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] lesserTemps = new double[0];
        int i = 0;
        int length = lesserTemps.length;
        for (double temp : tempSeries) {
            if (temp < tempValue) {
                lesserTemps = Arrays.copyOf(lesserTemps, length+1);
                length++;
                lesserTemps[i] = temp;
                i++;
            }
        }
        return lesserTemps;
    }

    /** Error */
    public double[] findTempsGreaterThen(double tempValue) {
        double[] biggerEqualTemps = new double[0];
        int i = 0;
        int length = biggerEqualTemps.length;
        for (double temp : tempSeries) {
            if (temp > tempValue) {
                biggerEqualTemps = Arrays.copyOf(biggerEqualTemps, length+1);
                length++;
                biggerEqualTemps[i] = temp;
                i++;
            }
        }
        return biggerEqualTemps;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        TempSummaryStatistics tempStats = new TempSummaryStatistics(this.average(), this.deviation(), this.min(), this.max());
        return tempStats;
    }

    /** Error */
    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < absMinTemp) {
                throw new InputMismatchException("Wrong values in input series!");
            }
        }
        int total;
        int numOfTemps = temps.length;
        int i = tempSeries.length;
        int diff = tempSeries.length - numOfTemps;
        if (diff < numOfTemps) {
            double[] copy = new double[2*tempSeries.length];
            int length = tempSeries.length;
            System.arraycopy(tempSeries, 0, copy, 0, length);
            tempSeries = copy;
        }
        for (double temp : temps) {
            tempSeries[i] = temp;
            i++;
        }
        total =  tempSeries.length + numOfTemps;
        return total;
    }
}
