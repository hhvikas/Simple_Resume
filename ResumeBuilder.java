package com.simpleapp.resume;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringJoiner;

/**
 * Fills a tiny template and writes a plain-text resume.
 * Template placeholders:
 *  {{FULL_NAME}} {{EMAIL}} {{PHONE}} {{LOCATION}} {{SUMMARY}} {{EXPERIENCES}}
 */
public class ResumeBuilder {
    private final String templatePath;
    private final String outputPath;

    public ResumeBuilder(String templatePath, String outputPath) {
        this.templatePath = templatePath;
        this.outputPath = outputPath;
    }

    public boolean generate(Profile p) {
        try {
            String template = Files.readString(Path.of(templatePath));

            StringJoiner exJoiner = new StringJoiner("\n\n");
            for (Experience e : p.getExperiences()) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.getRole()).append(" • ").append(e.getCompany()).append("\n");
                sb.append(e.getDates()).append("\n");
                for (String r : e.getResponsibilities()) {
                    sb.append("- ").append(r).append("\n");
                }
                exJoiner.add(sb.toString().trim());
            }

            String filled = template
                    .replace("{{FULL_NAME}}", safe(p.getFullName()))
                    .replace("{{EMAIL}}", safe(p.getEmail()))
                    .replace("{{PHONE}}", safe(p.getPhone()))
                    .replace("{{LOCATION}}", safe(p.getLocation()))
                    .replace("{{SUMMARY}}", safe(p.getSummary()))
                    .replace("{{EXPERIENCES}}", exJoiner.toString());

            Files.writeString(Path.of(outputPath), filled);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private String safe(String s) { return s == null ? "" : s; }
}
