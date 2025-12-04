package com.simpleapp.resume;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Minimal CLI: collect profile + experiences and produce a plain-text resume.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Profile profile = new Profile();

        System.out.print("Full name: ");
        profile.setFullName(in.nextLine().trim());

        System.out.print("Email: ");
        profile.setEmail(in.nextLine().trim());

        System.out.print("Phone (optional): ");
        profile.setPhone(in.nextLine().trim());

        System.out.print("Location (City, State): ");
        profile.setLocation(in.nextLine().trim());

        System.out.print("Short professional summary (one line): ");
        profile.setSummary(in.nextLine().trim());

        System.out.println("\nNow add experiences. You can add multiple. Leave company blank to finish.");
        while (true) {
            System.out.print("\nCompany (leave blank to stop): ");
            String company = in.nextLine().trim();
            if (company.isEmpty()) break;

            System.out.print("Role/Title: ");
            String role = in.nextLine().trim();

            System.out.print("Dates (e.g. Jan 2020 - Present): ");
            String dates = in.nextLine().trim();

            System.out.println("Enter responsibility (single line). Leave blank to finish this experience:");
            List<String> responsibilities = new ArrayList<>();
            while (true) {
                System.out.print("- ");
                String resp = in.nextLine().trim();
                if (resp.isEmpty()) break;
                responsibilities.add(resp);
            }

            profile.addExperience(company, role, dates, responsibilities);
            System.out.println("Experience added.");
        }

        // ensure output directory
        try {
            Files.createDirectories(Path.of("output"));
        } catch (Exception ignored) {}

        ResumeBuilder builder = new ResumeBuilder("templates/resume_template.txt", "output/resume.txt");
        boolean ok = builder.generate(profile);
        if (ok) {
            System.out.println("\nResume generated: output/resume.txt");
        } else {
            System.out.println("\nFailed to generate resume. Make sure templates/resume_template.txt exists.");
        }

        in.close();
    }
}
