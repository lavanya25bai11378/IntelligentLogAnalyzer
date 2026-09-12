package analysis;

import model.Incident;

public class SeverityAnalyzer {

    public void assignSeverity(Incident incident) {

        if (incident == null) {
            return;
        }

        int eventCount = incident.getRelatedEvents().size();

        if (incident.getType().equals("Database Connectivity Failure")
                || incident.getType().equals("Server Crash")
                || incident.getType().equals("System Failure")) {

            incident.setSeverity("CRITICAL");

        } else if (eventCount >= 5) {

            incident.setSeverity("HIGH");

        } else if (eventCount >= 3) {

            incident.setSeverity("MEDIUM");

        } else {

            incident.setSeverity("LOW");
        }
    }
}
