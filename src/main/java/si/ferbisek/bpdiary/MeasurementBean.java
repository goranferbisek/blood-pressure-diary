package si.ferbisek.bpdiary;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDate;
import java.util.List;

@Named("measurementBean") @RequestScoped
public class MeasurementBean {

    private Integer systolic;
    private Integer diastolic;
    private String note;
    private List<MeasurementRecord> measurementRecords;

    @Inject
    private MeasurementService measurementService;

    private MeasurementRecord measurementRecord;

    @PostConstruct
    private void init() {
        measurementRecords = measurementService.list();
        measurementRecord = new MeasurementRecord();
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

    public List<MeasurementRecord> getMeasurementRecords() {
        return measurementRecords;
    }

    public void setMeasurementRecords(List<MeasurementRecord> measurementRecords) {
        this.measurementRecords = measurementRecords;
    }

    public MeasurementRecord getMeasurementRecord() {
        return measurementRecord;
    }

    public void setMeasurementRecord(MeasurementRecord measurementRecord) {
        this.measurementRecord = measurementRecord;
    }

    public void add() {
        measurementRecord = new MeasurementRecord();
        measurementRecord.setDate(LocalDate.now());
        measurementRecord.setSystolic(systolic);
        measurementRecord.setDiastolic(diastolic);
        measurementRecord.setNote(note);
        measurementService.create(measurementRecord);
        resetForm();
    }

    private void resetForm() {
        systolic = null;
        diastolic = null;
        note = null;
    }

}
