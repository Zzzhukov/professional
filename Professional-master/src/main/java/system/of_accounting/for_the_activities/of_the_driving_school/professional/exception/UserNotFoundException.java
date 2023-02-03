package system.of_accounting.for_the_activities.of_the_driving_school.professional.exception;

public class UserNotFoundException extends Exception{
    @Override
    public String getMessage(){
        return "user not found";
    }
}
