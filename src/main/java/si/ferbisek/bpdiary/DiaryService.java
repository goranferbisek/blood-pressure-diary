package si.ferbisek.bpdiary;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DiaryService {

    private List<DiaryEntry> diaries = new ArrayList<>();

    @PostConstruct
    public void init() {
        diaries.add(new DiaryEntry(LocalDate.now(), 127, 87, "Pressure is OK."));
        diaries.add(new DiaryEntry(LocalDate.of(2023,1,4), 147, 99, "Very high blood pressure!"));
        diaries.add(new DiaryEntry(LocalDate.of(2022,12,24), 135, 95, "Pressure is a little high."));
    }

    public List<DiaryEntry> list() {
        return diaries;
    }
}
