import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlador{
    public static boolean comprobarRegistro(String email){
        ArrayList<User> temp = Modelo.getInstaceModelo();
        //Comprobar si el usuario ya está registrado
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getEmail().equals(email)){
               // System.out.println("Error, el usuario ya está registrado"); //capaz que va en la vista
                return false;
            }
        }
        return true;
    }

    public static boolean comprobarEdad(String edadString){
        int edad = Integer.parseInt(edadString);
        if (edad <= 0){
            return false;
        }else{
            return true;
        }
    }

    public static boolean comprobarEmail(String email){
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean comprobarContrasenia(String contrasenia){
    // Contraseña de 8-16 caracteres con al menos un dígito, al menos uno
    // letra minúscula, al menos una letra mayúscula, al menos una
    // caracter especial sin espacios en blanco
        String caracteres = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
        Pattern pattern = Pattern.compile(caracteres);

        // Validar una contraseña
        if (pattern.matcher(contrasenia).matches()) {
            return true;
        }
        else {
            return false;
        }
    }
}
