package si.ferbisek.bpdiary;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DiaryService {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        //TODO: get data from database
        MeasurementRecord mr = new MeasurementRecord();
        mr.setDate(LocalDate.now());
        mr.setSystolic(127);
        mr.setDiastolic(87);
        mr.setNote("Pressure is OK.");

        entityManager.persist(mr);
        /*measurementRecords.add(new MeasurementRecord(LocalDate.now(), 127, 87, "Pressure is OK."));
        measurementRecords.add(new MeasurementRecord(LocalDate.of(2022,5,8), 127, 87, "Pressure is OK."));
        measurementRecords.add(new MeasurementRecord(LocalDate.of(2023,1,4), 147, 99, "Very high blood pressure!"));
        measurementRecords.add(new MeasurementRecord(LocalDate.of(2022,12,24), 135, 95, "Pressure is a little high."));*/
    }

    public List<MeasurementRecord> list() {
        return entityManager
                .createQuery("SELECT m FROM MeasurementRecord m", MeasurementRecord.class)
                .getResultList();
    }

    public void create(MeasurementRecord measurementRecord) {
        entityManager.persist(measurementRecord);
    }

}
