package com.simpleapp.resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple profile holder.
 */
public class Profile {
    private String fullName = "";
    private String email = "";
    private String phone = "";
    private String location = "";
    private String summary = "";

    private final List<Experience> experiences = new ArrayList<>();

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setLocation(String location) { this.location = location; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getLocation() { return location; }
    public String getSummary() { return summary; }

    public List<Experience> getExperiences() { return experiences; }

    public void addExperience(String company, String role, String dates, List<String> responsibilities) {
        experiences.add(new Experience(company, role, dates, responsibilities));
    }
}
