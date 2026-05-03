package excepciones;

/**
 * Excepción que se lanza cuando el usuario ingresa un dato
 * inválido en alguno de los campos de búsqueda del sistema.
 *
 * Esta excepción indica que el valor ingresado no cumple con
 * los requisitos esperados para realizar la operación solicitada.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class DatoInvalidoException extends Exception
{
    /**
     * Construye una excepción con un mensaje descriptivo.
     *
     * @param mensaje Mensaje que describe el dato inválido ingresado
     *
     * @pre mensaje != null
     * @post Se crea una excepción con el mensaje especificado
     */
    public DatoInvalidoException(String mensaje)
    {
        super(mensaje);
    }

    /**
     * Construye una excepción con un mensaje descriptivo y una causa.
     *
     * @param mensaje Mensaje que describe el dato inválido ingresado
     * @param causa   Causa original de la excepción
     *
     * @pre mensaje != null
     * @post Se crea una excepción con el mensaje y la causa especificados
     */
    public DatoInvalidoException(String mensaje, Throwable causa)
    {
        super(mensaje, causa);
    }
}