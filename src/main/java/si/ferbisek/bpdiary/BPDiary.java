package si.ferbisek.bpdiary;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("bpDiary") @RequestScoped
public class BPDiary {

    private List<DiaryEntry> diaries;

    @Inject
    private DiaryService diaryService;

    @PostConstruct
    private void init() {
        diaries = diaryService.list();
    }

    public List<DiaryEntry> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<DiaryEntry> diaries) {
        this.diaries = diaries;
    }
}
