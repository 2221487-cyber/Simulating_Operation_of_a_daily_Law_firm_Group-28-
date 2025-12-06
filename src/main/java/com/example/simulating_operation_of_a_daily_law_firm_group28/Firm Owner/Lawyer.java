package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

public class Lawyer {
    private String Id;
    private String name;
    private String email;
    private long billableRateInCentsPerHour;
    private String calenderDate;

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getBillableRateInCentsPerHour() {
        return billableRateInCentsPerHour;
    }

    public String getCalenderDate() {
        return calenderDate;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBillableRateInCentsPerHour(long billableRateInCentsPerHour) {
        this.billableRateInCentsPerHour = billableRateInCentsPerHour;
    }

    public void setCalenderDate(String calenderDate) {
        this.calenderDate = calenderDate;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", billableRateInCentsPerHour=" + billableRateInCentsPerHour +
                ", calenderDate='" + calenderDate + '\'' +
                '}';
    }

    public Lawyer(String id, String name, String email, long billableRateInCentsPerHour, String calenderDate) {
        Id = id;
        this.name = name;
        this.email = email;
        this.billableRateInCentsPerHour = billableRateInCentsPerHour;
        this.calenderDate = calenderDate;
    }
}
