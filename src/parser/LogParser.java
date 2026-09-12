package parser;

import model.LogEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogParser {

    public List<LogEvent> parse(String fileName) throws IOException {

        List<LogEvent> events = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\|", 4);

                if (parts.length != 4) {
                    System.out.println(
                            "Warning: Invalid log entry skipped: " + line);
                    continue;
                }

                String timestamp = parts[0].trim();
                String level = parts[1].trim();
                String service = parts[2].trim();
                String message = parts[3].trim();

                LogEvent event = new LogEvent(
                        timestamp,
                        level,
                        service,
                        message
                );

                events.add(event);
            }
        }

        return events;
    }
}
