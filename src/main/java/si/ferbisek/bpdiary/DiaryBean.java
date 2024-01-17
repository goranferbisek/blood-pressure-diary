package si.ferbisek.bpdiary;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDate;
import java.util.List;

@Named("diaryBean") @RequestScoped
public class DiaryBean {

    private Integer systolic;
    private Integer diastolic;
    private String note;
    private List<DiaryEntry> diaries;

    @Inject
    private DiaryService diaryService;

    private DiaryEntry diaryEntry;

    @PostConstruct
    private void init() {
        diaries = diaryService.list();
        diaryEntry = new DiaryEntry();
    }

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<DiaryEntry> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<DiaryEntry> diaries) {
        this.diaries = diaries;
    }

    public DiaryEntry getDiaryEntry() {
        return diaryEntry;
    }

    public void setDiaryEntry(DiaryEntry diaryEntry) {
        this.diaryEntry = diaryEntry;
    }

    public void add() {
        diaryEntry = new DiaryEntry();
        diaryEntry.setDate(LocalDate.now());
        diaryEntry.setSystolic(systolic);
        diaryEntry.setDiastolic(diastolic);
        diaryEntry.setNote(note);
        diaryService.create(diaryEntry);
        resetForm();
    }

    private void resetForm() {
        systolic = null;
        diastolic = null;
        note = null;
    }

}
