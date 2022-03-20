package modelo;

public class Survey {
    private int grade;
    private boolean rentAgain;

    public Survey(int grade, boolean rentAgain) {
        this.grade = grade;
        this.rentAgain = rentAgain;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isRentAgain() {
        return rentAgain;
    }

    public void setRentAgain(boolean rentAgain) {
        this.rentAgain = rentAgain;
    }
}
