package Models;

public class Usuarios {

    private int id;
    private String varchar;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String telefono;
    private int sanciones;
    private int dineroSanciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVarchar() {
        return varchar;
    }

    public void setVarchar(String varchar) {
        this.varchar = varchar;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getSanciones() {
        return sanciones;
    }

    public void setSanciones(int sanciones) {
        this.sanciones = sanciones;
    }

    public int getDineroSanciones() {
        return dineroSanciones;
    }

    public void setDineroSanciones(int dineroSanciones) {
        this.dineroSanciones = dineroSanciones;
    }

}
