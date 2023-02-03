package system.of_accounting.for_the_activities.of_the_driving_school.professional.service;

import system.of_accounting.for_the_activities.of_the_driving_school.professional.entity.Teacher;
import system.of_accounting.for_the_activities.of_the_driving_school.professional.repository.TeacherRepository;

public class EditTeacherService {
    private static final EditTeacherService EDIT_TEACHER_SERVICE = new EditTeacherService();

    private EditTeacherService() {
    }

    public static EditTeacherService getInstance() {
        return EDIT_TEACHER_SERVICE;
    }

    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();

    private Teacher teacher;

    public void updateTeacher(String code, String fullName, String phone, String experience, String contract) {
        teacher.setCodeTeacher(Long.parseLong(code));
        teacher.setFullName(fullName);
        teacher.setPhone(phone);
        teacher.setExperience(experience);
        teacher.setContract(contract);

        if (code.equals("0")){
            teacherRepository.insertTeacher(teacher);
        }
        else {
            teacherRepository.updateTeacher(teacher);
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void deleteTeacher() {
        teacherRepository.deleteTeacher(teacher.getCodeTeacher());
    }
}
