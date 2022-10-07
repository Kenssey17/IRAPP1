package Entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String uid;
    private String usuario;
    private String correo;
    private String contrasena;

    public Usuario(){

    }


    public Usuario(String uid, String usuario, String correo, String contrasena) {
        this.uid = uid;
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
