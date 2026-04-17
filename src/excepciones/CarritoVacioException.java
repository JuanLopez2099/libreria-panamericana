package excepciones;

/**
 * Excepción que se lanza cuando se intenta realizar una compra
 * con el carrito de compras vacío.
 * <p>
 * Esta excepción indica que no es posible completar la operación
 * debido a la ausencia de productos en el carrito.
 * </p>
 */
public class CarritoVacioException extends Exception 
{
    /**
     * Construye una excepción con un mensaje descriptivo.
     * 
     * @param mensaje Mensaje que describe la causa de la excepción
     * 
     * @pre mensaje != null
     * @post Se crea una excepción con el mensaje especificado
     */
    public CarritoVacioException(String mensaje) 
    {
        super(mensaje);
    }

    /**
     * Construye una excepción con un mensaje descriptivo y una causa.
     * 
     * @param mensaje Mensaje que describe la causa de la excepción
     * @param causa Causa original de la excepción
     * 
     * @pre mensaje != null
     * @post Se crea una excepción con el mensaje y la causa especificados
     */
    public CarritoVacioException(String mensaje, Throwable causa) 
    {
        super(mensaje, causa);
    }
}