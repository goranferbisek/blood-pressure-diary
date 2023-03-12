package si.ferbisek.bpdiary;

import java.time.LocalDate;

public class DiaryEntry {

    private long id;
    private LocalDate date;
    private int systolic;
    private int diastolic;
    private String note;

    public DiaryEntry() {
    }

    public DiaryEntry(long id, LocalDate date, int systolic, int diastolic, String note) {
        this.id = id;
        this.date = date;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
