package reporting;

import model.Incident;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {

    public void generateReport(
            List<Incident> incidents,
            String fileName) throws IOException {

        try (FileWriter writer = new FileWriter(fileName)) {

            writer.write("LOG ANOMALY ANALYSIS REPORT\n");
            writer.write("==========================\n\n");

            if (incidents == null || incidents.isEmpty()) {
                writer.write("No incidents detected.\n");
                return;
            }

            writer.write("Total Incidents: "
                    + incidents.size() + "\n\n");

            for (Incident incident : incidents) {

                writer.write("Incident #" +
                        incident.getIncidentId() + "\n");

                writer.write("Type: "
                        + incident.getType() + "\n");

                writer.write("Severity: "
                        + incident.getSeverity() + "\n");

                writer.write("Status: "
                        + incident.getStatus() + "\n");

                writer.write("Related Events: "
                        + incident.getRelatedEvents().size() + "\n");

                writer.write("--------------------------\n");
            }
        }
    }
}
