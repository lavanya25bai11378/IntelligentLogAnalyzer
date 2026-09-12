package detection;

import model.LogEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternDetector {

    public Map<String, Integer> countErrorsByService(
            List<LogEvent> events) {

        Map<String, Integer> errorCounts = new HashMap<>();

        for (LogEvent event : events) {

            if ("ERROR".equalsIgnoreCase(event.getLevel())) {

                String service = event.getService();

                errorCounts.put(
                        service,
                        errorCounts.getOrDefault(service, 0) + 1
                );
            }
        }

        return errorCounts;
    }

    public boolean hasRepeatedErrors(
            List<LogEvent> events,
            String service,
            int threshold) {

        Map<String, Integer> errorCounts =
                countErrorsByService(events);

        return errorCounts.getOrDefault(service, 0) >= threshold;
    }

    public boolean containsCriticalFailure(List<LogEvent> events) {

        for (LogEvent event : events) {

            String message = event.getMessage().toLowerCase();

            if (message.contains("database connection failed")
                    || message.contains("server crash")
                    || message.contains("system failure")) {

                return true;
            }
        }

        return false;
    }

    public int countCriticalEvents(List<LogEvent> events) {

        int count = 0;

        for (LogEvent event : events) {

            String message = event.getMessage().toLowerCase();

            if (message.contains("database connection failed")
                    || message.contains("server crash")
                    || message.contains("system failure")) {

                count++;
            }
        }

        return count;
    }
}
