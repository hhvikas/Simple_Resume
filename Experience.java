package com.simpleapp.resume;

import java.util.List;

/**
 * Very small experience data class.
 */
public class Experience {
    private final String company;
    private final String role;
    private final String dates;
    private final List<String> responsibilities;

    public Experience(String company, String role, String dates, List<String> responsibilities) {
        this.company = company;
        this.role = role;
        this.dates = dates;
        this.responsibilities = responsibilities;
    }

    public String getCompany() { return company; }
    public String getRole() { return role; }
    public String getDates() { return dates; }
    public List<String> getResponsibilities() { return responsibilities; }
}
