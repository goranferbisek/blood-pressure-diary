package si.ferbisek.bpdiary;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDate;
import java.util.List;

@Named("bpDiary") @RequestScoped
public class BPDiary {

    private List<DiaryEntry> diaries;

    @Inject
    private DiaryService diaryService;

    private DiaryEntry diaryEntry;

    @PostConstruct
    private void init() {
        diaries = diaryService.list();
        diaryEntry = new DiaryEntry();
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
//        diaries.add(diaryEntry);
        diaryEntry.setDate(LocalDate.now());
        diaryService.create(diaryEntry);
        diaryEntry = new DiaryEntry();
    }


}
