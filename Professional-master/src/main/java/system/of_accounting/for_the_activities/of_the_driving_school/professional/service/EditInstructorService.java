package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Instructor;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.InstructorRepository;

public class EditInstructorService {
    private static final EditInstructorService INSTRUCTOR_SERVICE = new EditInstructorService();

    private EditInstructorService() {
    }

    public static EditInstructorService getInstance() {
        return INSTRUCTOR_SERVICE;
    }

    private final InstructorRepository instructorRepository = InstructorRepository.getInstance();

    private Instructor instructor;

    public void updateInstructor(String id, String fullName, String phone,
                                 String experience, String category, String contract) {
        instructor.setIdInstructor(Long.parseLong(id));
        instructor.setFullName(fullName);
        instructor.setPhone(phone);
        instructor.setExperience(experience);
        instructor.setCategory(category);
        instructor.setContract(contract);

        if (id.equals("0")){
            instructorRepository.insertInstructor(instructor);
        }
        else {
            instructorRepository.updateInstructor(instructor);
        }
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void deleteInstructor() {
        instructorRepository.deleteInstructor(instructor.getIdInstructor());
    }
}
