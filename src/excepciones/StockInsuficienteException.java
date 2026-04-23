package excepciones;

/**
 * Excepción que se lanza cuando no hay suficiente stock
 * de un libro físico para realizar una operación.
 * <p>
 * Esta excepción indica que no es posible completar una acción,
 * como una compra, debido a que la cantidad solicitada excede
 * el stock disponible del producto.
 * </p>
 */
public class StockInsuficienteException extends Exception 
{
    /**
     * Construye una excepción con un mensaje descriptivo.
     * 
     * @param mensaje Mensaje que describe la causa de la excepción
     * 
     * @pre mensaje != null
     * @post Se crea una excepción con el mensaje especificado
     */
    public StockInsuficienteException(String mensaje) 
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
    public StockInsuficienteException(String mensaje, Throwable causa) 
    {
        super(mensaje, causa);
    }
}