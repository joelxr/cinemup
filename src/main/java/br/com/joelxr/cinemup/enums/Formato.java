package br.com.joelxr.cinemup.enums;

/**
 * Enums para diversos formatos.
 */
public enum Formato {
    HORA_FORMATO ("hh:mm"),
    DATA_FORMATO ("dd/MM/yyyy"),
    DATAHORA_FORMATO ("dd/MM/yyyy hh:mm");

    private final String formato;

    private Formato(String formato) {
        this.formato = formato;
    }
    
    public String getFormato () {
    	return formato;
    }
}
