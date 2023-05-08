import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Interfaz extends Frame {
    private Label labelNombre, labelEdad, labelMail, labelContrasena;
    private TextField campoNombre, campoEdad, campoMail, campoContrasena;
    private Button botonEnviar;
    private Button botonMostrar;

    public Interfaz() {
        setLayout(new GridLayout(5, 2));
        
        setTitle("Registro de Datos");
       
        labelNombre = new Label("Nombre:");
        add(labelNombre);
        campoNombre = new TextField();
        add(campoNombre);

        labelEdad = new Label("Edad:");
        add(labelEdad);
        campoEdad = new TextField();
        add(campoEdad);

        labelMail = new Label("Correo electrónico:");
        add(labelMail);
        campoMail = new TextField();
        add(campoMail);

        labelContrasena = new Label("Contraseña:");
        add(labelContrasena);
        campoContrasena = new TextField();
        add(campoContrasena);

        // Botón
        botonEnviar = new Button("Enviar");
        add(botonEnviar);

        botonMostrar = new Button("Mostrar Usuarios");
        add(botonMostrar);

        botonEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();

                String edad = campoEdad.getText();

                String email = campoMail.getText();

                String contrasenia = campoContrasena.getText();

                String mensaje = "Nombre: " + nombre + "\nEdad: " + edad + "\nCorreo electrónico: " + email + "\nContraseña: " + contrasenia;

                JOptionPane.showMessageDialog(null, mensaje);
                //El controlador haciendo de las suyas
                if (Controlador.comprobarEdad(edad)) {
                    if (Controlador.comprobarEmail(email)) {
                        if (Controlador.comprobarContrasenia(contrasenia)) {
                            if(Controlador.comprobarRegistro(email)){
                                User usuario = new User(nombre, edad, email, contrasenia);
                                Modelo.agregarUsuario(usuario);
                                JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
                               // System.out.println("Usuario agregado correctamente"); //Mover a interfaz
                            }else{
                                JOptionPane.showMessageDialog(null, "Error: El usuario ya está registrado");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error: El usuario no se pudo cargar, la contraseña debe ser una contraseña valida");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: El usuario no se pudo cargar, el email debe ser un email valido");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error: El usuario no se pudo cargar, la edad ingresada debe ser un numero valido");
                }
            }
        });

        botonMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<User> temp = Modelo.getInstaceModelo();
                for (int i = 0; i < temp.size(); i++) {

                    String nombre = temp.get(i).getNombre();
                    int edad = temp.get(i).getEdad();
                    String email = temp.get(i).getEmail();
                    String contrasenia = temp.get(i).getContrasenia();

                    String mensaje = "Nombre: " + nombre + "\nEdad: " + edad + "\nCorreo electrónico: " + email + "\nContraseña: " + contrasenia;
                    JOptionPane.showMessageDialog(null, mensaje);
                   
                }
            }
        });

        // Cierra la aplicación al cerrar la ventana principal
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        // Hace visible la ventana principal
        //setVisible(true);
    }
}
