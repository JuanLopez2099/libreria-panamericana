package excepciones;

/**
 * Excepción que se lanza cuando se intenta realizar una compra
 * con el carrito vacío.
 */
public class CarritoVacioException extends Exception 
{
    /**
     * Construye la excepción con un mensaje descriptivo.
     * 
     * @param mensaje Descripción del error.
     */
    public CarritoVacioException(String mensaje) 
    {
        super(mensaje);
    }

    /**
     * Construye la excepción con mensaje y causa.
     * 
     * @param mensaje Descripción del error.
     * @param causa Causa original de la excepción.
     */
    public CarritoVacioException(String mensaje, Throwable causa) 
    {
        super(mensaje, causa);
    }
}