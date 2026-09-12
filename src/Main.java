import analysis.SeverityAnalyzer;
import correlation.IncidentCorrelator;
import detection.AnomalyDetector;
import model.Anomaly;
import model.Incident;
import model.LogEvent;
import parser.LogParser;
import reporting.ReportGenerator;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String fileName = "data/sample.log";

        try {

            LogParser parser = new LogParser();
            List<LogEvent> events = parser.parse(fileName);

            System.out.println("Log Analysis Started");
            System.out.println("--------------------");
            System.out.println("Total log events: "
                    + events.size());

            AnomalyDetector detector =
                    new AnomalyDetector();

            List<Anomaly> anomalies =
                    detector.detect(events);

            System.out.println("Anomalies detected: "
                    + anomalies.size());

            IncidentCorrelator correlator =
                    new IncidentCorrelator();

            List<Incident> incidents =
                    correlator.createIncidents(events);

            SeverityAnalyzer severityAnalyzer =
                    new SeverityAnalyzer();

            for (Incident incident : incidents) {
                severityAnalyzer.assignSeverity(incident);
            }

            System.out.println("\nIncidents");
            System.out.println("---------");

            for (Incident incident : incidents) {
                System.out.println(incident);
            }

            ReportGenerator reportGenerator =
                    new ReportGenerator();

            reportGenerator.generateReport(
                    incidents,
                    "output/incident_report.txt"
            );

            System.out.println(
                    "\nReport generated successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error reading or writing file: "
                    + e.getMessage()
            );
        }
    }
}
