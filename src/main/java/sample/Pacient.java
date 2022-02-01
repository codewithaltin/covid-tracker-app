package sample;


public class Pacient { // Telescoping Constructor Design Pattern
    public String fullName;
    public String dateOfBirth;
    public String city;
    public String timeStamp;
    public String medCondition;
    public String gender;
    public String diseases;

    //Giving all the possible data when construting
    public Pacient(String fullName, String dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }
    public Pacient(String fullName, String dateOfBirth, String city) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
    }
    public Pacient(String fullName, String dateOfBirth, String city, String timeStamp) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.timeStamp = timeStamp;
    }


    public Pacient(String fullName, String dateOfBirth, String city, String timeStamp, String medCondition) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.timeStamp = timeStamp;
        this.medCondition = medCondition;
    }
    public Pacient(String fullName, String dateOfBirth, String city, String timeStamp, String medCondition, String gender) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.timeStamp = timeStamp;
        this.medCondition = medCondition;
        this.gender = gender;
    }
    public Pacient(String fullName, String dateOfBirth, String city, String timeStamp, String medCondition, String gender,String diseases) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.timeStamp = timeStamp;
        this.medCondition = medCondition;
        this.gender = gender;
        this.diseases = diseases;
    }
}