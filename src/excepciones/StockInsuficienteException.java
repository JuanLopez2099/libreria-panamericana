package excepciones;



/**
 * Excepción que se lanza cuando no hay suficiente stock
 * de un libro físico para realizar una operación.
 */
public class StockInsuficienteException extends Exception 
{
    /**
     * Construye la excepción con un mensaje descriptivo.
     * 
     * @param mensaje Descripción del error.
     */
    public StockInsuficienteException(String mensaje) 
    {
        super(mensaje);
    }

    /**
     * Construye la excepción con mensaje y causa.
     * 
     * @param mensaje Descripción del error.
     * @param causa Causa original de la excepción.
     */
    public StockInsuficienteException(String mensaje, Throwable causa) 
    {
        super(mensaje, causa);
    }
}
