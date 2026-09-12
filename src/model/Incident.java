package model;

import java.util.ArrayList;
import java.util.List;

public class Incident {

    private int incidentId;
    private String type;
    private String severity;
    private String status;
    private List<LogEvent> relatedEvents;

    public Incident(int incidentId, String type) {
        this.incidentId = incidentId;
        this.type = type;
        this.severity = "LOW";
        this.status = "OPEN";
        this.relatedEvents = new ArrayList<>();
    }

    public void addEvent(LogEvent event) {
        relatedEvents.add(event);
    }

    public int getIncidentId() {
        return incidentId;
    }

    public String getType() {
        return type;
    }

    public String getSeverity() {
        return severity;
    }

    public String getStatus() {
        return status;
    }

    public List<LogEvent> getRelatedEvents() {
        return relatedEvents;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Incident #" + incidentId
                + " | Type: " + type
                + " | Severity: " + severity
                + " | Status: " + status
                + " | Events: " + relatedEvents.size();
    }
}
