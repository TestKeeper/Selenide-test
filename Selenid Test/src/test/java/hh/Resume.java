package hh;

/**
 * Class for describing the attributes of a candidate from a resume page on hh
 */
public class Resume {
    /**
     * Candidate Attributes
     */
    private final String gender;
    private final String city;
    private final int age;
    private final boolean isNumberConfirmed;
    private final boolean isReadyToRelocate;


    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public boolean isNumberConfirmed() {
        return isNumberConfirmed;
    }

    public boolean isReadyToRelocate() {
        return isReadyToRelocate;
    }

    public String getCity() {
        return city;
    }

    /**
     * Конструктор класса
     * @param gender gender of the candidate
     * @param city candidate's city
     * @param age candidate's age
     * @param isNumberConfirmed is the number confirmed
     * @param isReadyToRelocate Is the candidate ready to move?
     */
    public Resume(String gender, String city, int age, boolean isNumberConfirmed, boolean isReadyToRelocate) {
        this.gender = gender;
        this.city = city;
        this.age = age;
        this.isNumberConfirmed = isNumberConfirmed;
        this.isReadyToRelocate = isReadyToRelocate;
    }
}
