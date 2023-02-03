package system.of_accounting.for_the_activities.of_the_driving_school.professional.exception;

public class IncorrectPasswordException extends Exception{
    @Override
    public String getMessage(){
        return "incorrect password";
    }
}
