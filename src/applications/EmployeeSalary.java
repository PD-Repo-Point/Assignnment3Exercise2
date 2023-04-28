package applications;

public class EmployeeSalary {
    private int emplId;
    private String jobTitle;
    private int Salary;

    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public EmployeeSalary() {
    }

    @Override
    public String toString() {
        return "EmployeeSalary{" +
                "emplId=" + emplId +
                ", jobTitle='" + jobTitle + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
