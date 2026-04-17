package excepciones;

/**
 * Excepción que se lanza cuando no se encuentra un libro
 * dentro de la colección del sistema.
 * <p>
 * Esta excepción indica que una operación de búsqueda no pudo
 * completarse exitosamente debido a que el libro solicitado
 * no existe en la biblioteca.
 * </p>
 */
public class LibroNoEncontradoException extends Exception 
{
    /**
     * Construye una excepción con un mensaje descriptivo.
     * 
     * @param mensaje Mensaje que describe la causa de la excepción
     * 
     * @pre mensaje != null
     * @post Se crea una excepción con el mensaje especificado
     */
    public LibroNoEncontradoException(String mensaje) 
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
    public LibroNoEncontradoException(String mensaje, Throwable causa) 
    {
        super(mensaje, causa);
    }
}