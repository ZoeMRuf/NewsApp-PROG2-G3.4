package at.ac.fhcampuswien;

public class NewAPIException extends Exception{

    String errorMessage;

    public NewAPIException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public NewAPIException(){
        super();
    }

    @Override
    public String getMessage(){
        return this.errorMessage + " There is an Error. Please don't ask us we have no clue why!";
    }
}
