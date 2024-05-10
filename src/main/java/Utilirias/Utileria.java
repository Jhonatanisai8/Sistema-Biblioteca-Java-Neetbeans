package Utilirias;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utileria {

    //meetodo para combrar si es un string es un numero
    public static boolean esNumero(String numero) {
        if (numero == null) {
            return false;
        }
        try {
            double num;
            num = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static String obtenerFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formatearFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatearFecha.format(ahora);
    }

    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas
    public static synchronized int diferenciasFechas(Date fechaInicial, Date fechaFinal) throws ParseException {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaFinal = df.parse(fechaInicioString);
        } catch (ParseException e) {
        }
        String fechaFinalString = df.format(fechaFinal);
        fechaFinal = df.parse(fechaFinalString);

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();

        long diferencia = fechaFinalMs - fechaInicialMs;

        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public static synchronized Date stringtoDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;

        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
