package main.java.ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;
    
    TempSummaryStatistics(TemperatureSeriesAnalysis analysis) {
        avgTemp = analysis.average();
        devTemp = analysis.deviation();
        minTemp = analysis.min();
        maxTemp = analysis.max();
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }
}
