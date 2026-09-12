package correlation;

import model.Incident;
import model.LogEvent;

import java.util.ArrayList;
import java.util.List;

public class IncidentCorrelator {

    public List<Incident> createIncidents(List<LogEvent> events) {

        List<Incident> incidents = new ArrayList<>();

        if (events == null || events.isEmpty()) {
            return incidents;
        }

        int incidentId = 1;

        for (LogEvent event : events) {

            if (!"ERROR".equalsIgnoreCase(event.getLevel())) {
                continue;
            }

            Incident incident = findMatchingIncident(
                    incidents,
                    event
            );

            if (incident == null) {

                String type = getIncidentType(event);

                incident = new Incident(
                        incidentId++,
                        type
                );

                incidents.add(incident);
            }

            incident.addEvent(event);
        }

        return incidents;
    }

    private Incident findMatchingIncident(
            List<Incident> incidents,
            LogEvent event) {

        for (Incident incident : incidents) {

            if (incident.getType().equals(
                    getIncidentType(event))) {

                return incident;
            }
        }

        return null;
    }

    private String getIncidentType(LogEvent event) {

        String message = event.getMessage().toLowerCase();

        if (message.contains("database connection failed")) {
            return "Database Connectivity Failure";
        }

        if (message.contains("server crash")) {
            return "Server Crash";
        }

        if (message.contains("system failure")) {
            return "System Failure";
        }

        return "Repeated Service Error";
    }
}
