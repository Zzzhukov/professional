package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Inspector;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.InspectorRepository;

public class EditInspectorService {
    private static final EditInspectorService EDIT_INSPECTOR_SERVICE = new EditInspectorService();

    private EditInspectorService() {
    }

    public static EditInspectorService getInstance() {
        return EDIT_INSPECTOR_SERVICE;
    }

    private final InspectorRepository inspectorRepository = InspectorRepository.getInstance();

    private Inspector inspector;

    public void updateInspector(String id, String fullName, String phone, String jobTitle) {
        inspector.setIdInspector(Long.parseLong(id));
        inspector.setFullName(fullName);
        inspector.setPhone(phone);
        inspector.setJobTitle(jobTitle);

        if (id.equals("0")){
            inspectorRepository.insertInspector(inspector);
        }
        else {
            inspectorRepository.updateInspector(inspector);
        }
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public void deleteInspector() {
        inspectorRepository.deleteInspector(inspector.getIdInspector());
    }
}
