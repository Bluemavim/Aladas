package ar.com.ada.api.aladas.models.request;

import java.util.Date;
import javax.validation.constraints.*;
import ar.com.ada.api.aladas.entities.Pais.TipoDocuEnum;
import ar.com.ada.api.aladas.entities.Usuario.TipoUsuarioEnum;

public class RegistrationRequest {

    @NotBlank(message = "No puede estar vacío")
    @Min(3)
    public String fullName; 

    @Positive
    public int country; 

    //Valida contra los enums que hayamos creado.
    public TipoDocuEnum identificationType; 

    @NotBlank
    public String identification; 

    @Past(message = "Fecha inválida.")
    public Date birthDate; 
    
    @Email
    public String email; 

    public TipoUsuarioEnum userType;

    @NotBlank(message = "La contraseña no puede estar vacía.")
    @Size(min=8, max=15)
    public String password; 

}
