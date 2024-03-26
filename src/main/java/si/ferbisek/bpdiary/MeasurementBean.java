package si.ferbisek.bpdiary;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Named("measurementBean") @ViewScoped
public class MeasurementBean implements Serializable {

    private Integer systolic;
    private Integer diastolic;
    private String note;
    private List<MeasurementRecord> measurementRecords;

    @Inject
    private MeasurementService measurementService;

    @PostConstruct
    private void init() {
        measurementRecords = measurementService.list();
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

    public void add() {
        if (!FacesContext.getCurrentInstance().isValidationFailed()) {
            PrimeFaces.current().executeScript("PF('addEditDialog').hide()");

            MeasurementRecord measurementRecord = new MeasurementRecord();
            measurementRecord.setDate(LocalDate.now());
            measurementRecord.setSystolic(systolic);
            measurementRecord.setDiastolic(diastolic);
            measurementRecord.setNote(note);
            measurementService.create(measurementRecord);
            measurementRecords.add(measurementRecord);

            resetForm();
        }
    }

    public void get(Long measurementRecordId) {
        MeasurementRecord measurementRecord = measurementService.read(measurementRecordId);
        if (measurementRecord != null) {
            systolic = measurementRecord.getSystolic();
            diastolic = measurementRecord.getDiastolic();
            note = measurementRecord.getNote();
            PrimeFaces.current().executeScript("PF('addEditDialog').show()");
        }
    }

    public void remove(MeasurementRecord measurementRecord) {
        measurementService.delete(measurementRecord);
        measurementRecords.remove(measurementRecord);
    }

    public void resetForm() {
        systolic = null;
        diastolic = null;
        note = null;
    }

}
