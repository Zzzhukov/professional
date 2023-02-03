package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.DrivingSchool;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.DrivingSchoolRepository;

public class EditDrivingSchoolService {
    private static final EditDrivingSchoolService EDIT_DRIVING_SCHOOL_SERVICE = new EditDrivingSchoolService();

    private EditDrivingSchoolService() {
    }

    public static EditDrivingSchoolService getInstance() {
        return EDIT_DRIVING_SCHOOL_SERVICE;
    }

    private final DrivingSchoolRepository drivingSchoolRepository = DrivingSchoolRepository.getInstance();

    private DrivingSchool drivingSchool;

    public void updateDrivingSchool(String id, String name, String price,
                                 String services, String address, String codeBoss) {
        drivingSchool.setCodeSchool(Long.parseLong(id));
        drivingSchool.setName(name);
        drivingSchool.setPrice(Double.parseDouble(price));
        drivingSchool.setServices(services);
        drivingSchool.setAddress(address);
        drivingSchool.setCodeBoss(Long.parseLong(codeBoss));

        if (id.equals("0")){
            drivingSchoolRepository.insertDrivingSchool(drivingSchool);
        }
        else {
            drivingSchoolRepository.updateDrivingSchool(drivingSchool);
        }
    }

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
    }

    public void deleteDrivingSchool() {
        drivingSchoolRepository.deleteDrivingSchool(drivingSchool.getCodeSchool());
    }
}
