import javax.swing.*;

public class Dates {
    private int day;
    private int month;
    private int year;

    public Dates() {
        this.day = 1;
        this.month = 1;
        this.year = 1920;
    }
    public Dates(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    protected boolean lead() {
        return (this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0;
    }

    public boolean correctDate() {
        boolean correctDay = false, correctMonth = false, correctYear = false;

        correctMonth = (month >= 1 && month <= 12);
        correctYear = (year >= 1920);

        switch (month) {
            case 2:
                if (lead()) {
                    correctDay = (day >= 1 && day <= 29);
                } else
                    correctDay = (day >= 1 && day <= 28);
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                correctDay = (day >= 1 && day <= 31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                correctDay = (day >= 1 && day <= 30);
                break;
        }
        if (correctDay && correctMonth && correctYear) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La fecha es incorrecta", "Fecha incorrecta", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public String getDate() {
        return day + "/" + month + "/" + year;
    }
}
