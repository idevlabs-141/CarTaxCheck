package com.cartaxcheck.model;

public class VehicleIdentity {
    private String registration;
    private String make;
    private String model;
    private String colour;
    private String year;

    @Override
    public String toString() {
        return "VehicleIdentity{" +
                "registration='" + registration + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public VehicleIdentity(String registration, String make, String model, String colour, String year) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;

        return this.getRegistration().equalsIgnoreCase(((VehicleIdentity) obj). getRegistration()) &&
                this.getModel().equalsIgnoreCase(((VehicleIdentity) obj). getModel()) &&
                this.getMake().equalsIgnoreCase(((VehicleIdentity) obj). getMake()) &&
                this.getColour().equalsIgnoreCase(((VehicleIdentity) obj). getColour()) &&
                this.getYear().equalsIgnoreCase(((VehicleIdentity) obj). getYear());
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
