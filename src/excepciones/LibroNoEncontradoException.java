package excepciones;

/**
 * Excepción que se lanza cuando no se encuentra un libro
 * en la colección del sistema.
 */
public class LibroNoEncontradoException extends Exception 
{
    /**
     * Construye la excepción con un mensaje descriptivo.
     * 
     * @param mensaje Descripción del error.
     */
    public LibroNoEncontradoException(String mensaje) 
    {
        super(mensaje);
    }

    /**
     * Construye la excepción con mensaje y causa.
     * 
     * @param mensaje Descripción del error.
     * @param causa Causa original de la excepción.
     */
    public LibroNoEncontradoException(String mensaje, Throwable causa) 
    {
        super(mensaje, causa);
    }
}