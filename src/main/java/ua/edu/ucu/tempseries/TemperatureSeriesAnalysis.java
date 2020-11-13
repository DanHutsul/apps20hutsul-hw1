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
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < absMinTemp) {
                tempSeries = new double[0];
                throw new InputMismatchException();
            }
            else {
                tempSeries[i] = temperatureSeries[i];
            }
        }
    }

    public double average() {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        double sum = 0.0;
        double deviationTemp;
        double standardDeviation = 0.0;
        int length = tempSeries.length;

        for(double temp : tempSeries) {
            sum += temp;
        }

        double mean = sum/length;

        for(double temp: tempSeries) {
            standardDeviation += Math.pow(temp - mean, 2);
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
        double minTempDiff = Double.MAX_VALUE;

        for (double temp : tempSeries) {
            if (Math.abs(temp) <= minTempDiff) {
                if (Math.abs(temp) == minTempDiff) {
                    if (temp > minTempDiff) {
                        minTempDiff = temp;
                    }
                } else {
                    minTempDiff = temp;
                }
            }
        }
        return minTempDiff;
    }

    public double findTempClosestToValue(double tempValue) {
        if (tempSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double minTempDiff = Double.MAX_VALUE;

        for (double temp : tempSeries) {
            if (Math.abs(temp) - tempValue <= minTempDiff) {
                if (Math.abs(temp) - tempValue == minTempDiff) {
                    if (temp > minTempDiff) {
                        minTempDiff = temp - tempValue;
                    }
                } else {
                    minTempDiff = temp - tempValue;
                }
            }
        }
        return minTempDiff;
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

    public double[] findTempsGreaterThen(double tempValue) {
        double[] biggerEqualTemps = new double[0];
        int i = 0;
        int length = biggerEqualTemps.length;
        for (double temp : tempSeries) {
            if (temp < tempValue) {
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

    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < absMinTemp) {
                throw new InputMismatchException("Wrong values in series!");
            }
        }
        int sum = 0, i = 0;
        int length = tempSeries.length;
        for(double temp : temps) {
            while (i < length) {
                if (tempSeries[i] == 0.0) {
                    tempSeries[i] = temp;
                    sum += temp;
                    break;
                } else {
                    sum += tempSeries[i];
                }
                i++;
            }
            if (i == length) {
                // Increase length
                tempSeries = Arrays.copyOf(tempSeries, length*2);
            }
        }
        return sum;
    }
}
