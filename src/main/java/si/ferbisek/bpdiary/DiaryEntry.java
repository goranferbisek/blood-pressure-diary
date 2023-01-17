package si.ferbisek.bpdiary;

import java.time.LocalDate;

public class DiaryEntry {

    private LocalDate date;
    private int systolic;
    private int diastolic;
    private String note;

    public DiaryEntry(LocalDate date, int systolic, int diastolic, String note) {
        this.date = date;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
