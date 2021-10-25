package ar.com.ada.api.aladas.models.request;

public class ErrorItemInfo {
    public ErrorItemInfo(String field, String message){
        this.field =field;
        this.message = message;
    }

    String field;
    String message;
    
}
