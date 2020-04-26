package DTO;

import java.util.Objects;

public class JobOfferDTO {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobOfferDTO that = (JobOfferDTO) o;
        return Objects.equals(jobTittle, that.jobTittle) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(jobLocation, that.jobLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobTittle, companyName, jobLocation);
    }

    public JobOfferDTO(String jobTittle, String companyName, String jobLocation) {
        this.jobTittle = jobTittle;
        this.companyName = companyName;
        this.jobLocation = jobLocation;
    }

    public String getJobTittle() {
        return jobTittle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJoblocation() {
        return jobLocation;
    }

    public void setJobTittle(String jobTittle) {
        this.jobTittle = jobTittle;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setJoblocation(String joblocation) {
        jobLocation = joblocation;
    }

    private String jobTittle;
    private String companyName;
    private String jobLocation;


}
