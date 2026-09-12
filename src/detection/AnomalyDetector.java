package detection;

import model.Anomaly;
import model.LogEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnomalyDetector {

    private static final int REPEATED_ERROR_THRESHOLD = 3;

    private final PatternDetector patternDetector;

    public AnomalyDetector() {
        this.patternDetector = new PatternDetector();
    }

    public List<Anomaly> detect(List<LogEvent> events) {

        List<Anomaly> anomalies = new ArrayList<>();

        if (events == null || events.isEmpty()) {
            return anomalies;
        }

        // Detect repeated errors for each service
        Map<String, Integer> errorCounts =
                patternDetector.countErrorsByService(events);

        for (Map.Entry<String, Integer> entry : errorCounts.entrySet()) {

            if (entry.getValue() >= REPEATED_ERROR_THRESHOLD) {

                String description =
                        entry.getValue()
                        + " errors detected in service: "
                        + entry.getKey();

                anomalies.add(
                        new Anomaly(
                                "Repeated Error",
                                description,
                                "HIGH"
                        )
                );
            }
        }

        // Detect critical system failures
        for (LogEvent event : events) {

            String message = event.getMessage().toLowerCase();

            if (message.contains("database connection failed")
                    || message.contains("server crash")
                    || message.contains("system failure")) {

                anomalies.add(
                        new Anomaly(
                                "Critical Failure",
                                event.getService()
                                + ": "
                                + event.getMessage(),
                                "CRITICAL"
                        )
                );
            }
        }

        return anomalies;
    }
}
