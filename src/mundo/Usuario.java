package mundo;

/**
 * Clase que representa un usuario del sistema.
 *
 * Modela la información básica de un usuario, incluyendo su nombre
 * y su saldo disponible para realizar compras dentro del sistema.
 * Garantiza la validez de sus atributos mediante invariantes.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
 */
public class Usuario 
{
    /** Nombre del usuario */
    private String nombre;
    
    /** Saldo disponible del usuario */
    private double saldo;
    
    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye un usuario con nombre y saldo inicial.
     *
     * @pre nombre != null && !nombre.equals("") && saldo >= 0
     * @post Se crea un usuario con los valores de nombre y saldo especificados
     *
     * @param nombre Nombre del usuario
     * @param saldo Saldo inicial del usuario
     */
    public Usuario(String nombre, double saldo) 
    {
        this.nombre = nombre;
        this.saldo = saldo;
        
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    /**
     * Obtiene el nombre del usuario.
     *
     * @pre true
     * @post Se retorna el nombre del usuario
     *
     * @return Nombre del usuario
     */
    public String getNombre() 
    {
        return nombre;
    }

    /**
     * Obtiene el saldo actual del usuario.
     *
     * @pre true
     * @post Se retorna el saldo actual
     *
     * @return Saldo del usuario
     */
    public double getSaldo() 
    {
        return saldo;
    }

    // -------------------------------------------------------------------------
    // Setters
    // -------------------------------------------------------------------------

    /**
     * Establece el nombre del usuario.
     *
     * @pre nombre != null && !nombre.equals("")
     * @post El nombre del usuario se actualiza con el valor dado
     *
     * @param nombre Nuevo nombre del usuario
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
        validarInvariantes();
    }

    /**
     * Establece el saldo del usuario.
     *
     * @pre saldo >= 0
     * @post El saldo del usuario se actualiza con el valor dado
     *
     * @param saldo Nuevo saldo del usuario
     */
    public void setSaldo(double saldo) 
    {
        this.saldo = saldo;
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------------------

    /**
     * Descuenta un monto del saldo del usuario.
     *
     * @pre monto >= 0 && monto <= saldo
     * @post El saldo se reduce en el monto especificado
     *
     * @param monto Cantidad a descontar del saldo
     */
    public void descontarSaldo(double monto)
    {
        this.saldo -= monto;
        validarInvariantes();
    }
    
    /**
     * Verifica si el usuario tiene saldo suficiente para un monto dado.
     *
     * @pre monto >= 0
     * @post Se retorna true si el saldo es mayor o igual al monto
     *
     * @param monto Monto a verificar
     * @return true si tiene saldo suficiente, false en caso contrario
     */
    public boolean tieneSaldoSuficiente(double monto)
    {
        return saldo >= monto;
    }

    /**
     * Retorna una representación en texto del usuario.
     *
     * @pre true
     * @post Se retorna una cadena con la información del usuario
     *
     * @return Representación textual del usuario
     */
    @Override
    public String toString() 
    {
        return "Usuario [nombre=" + nombre + ", saldo=" + saldo + "]";
    }
    
    // -------------------------------------------------------------------------
    // Invariantes
    // -------------------------------------------------------------------------

    /**
     * Verifica que el nombre sea válido.
     *
     * @pre true
     * @post Retorna true si el nombre no es null ni vacío
     *
     * @return true si el nombre es válido
     */
    private boolean validarNombre()
    {
        return nombre != null && !nombre.equals("");
    }
    
    /**
     * Verifica que el saldo sea válido.
     *
     * @pre true
     * @post Retorna true si el saldo es mayor o igual a 0
     *
     * @return true si el saldo es válido
     */
    private boolean validarSaldo()
    {
        return saldo >= 0;
    }
    
    /**
     * Valida las invariantes de la clase.
     *
     * @pre true
     * @post Se garantiza que el nombre y el saldo sean válidos
     */
    private void validarInvariantes()
    {
        assert validarNombre() : "El nombre debe ser válido";
        assert validarSaldo()  : "El saldo debe ser válido";
    }
}