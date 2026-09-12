package model;

public class Anomaly {

    private String type;
    private String description;
    private String severity;

    public Anomaly(String type, String description, String severity) {
        this.type = type;
        this.description = description;
        this.severity = severity;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return type + " | " + severity + " | " + description;
    }
}
