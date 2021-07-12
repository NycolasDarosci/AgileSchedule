package br.com.agileschedule.config;

public class ExceptionBaseDTO extends RuntimeException {
    
    private String message;


    public ExceptionBaseDTO(String message) {
        this.message = message;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
