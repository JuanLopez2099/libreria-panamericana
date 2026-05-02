package mundo;

/**
 * Clase que representa un usuario del sistema con nombre y saldo.
 * <p>
 * Esta clase encapsula la información básica de un usuario, garantizando que
 * el nombre sea válido (no nulo y no vacío) y el saldo sea no negativo mediante
 * la validación de invariantes.
 * </p>
 */
public class Usuario 
{
	/** Nombre del usuario. Debe ser no nulo y no vacío. */
	private String nombre;
	
	/** Saldo actual del usuario. Debe ser mayor o igual a cero. */
	private double saldo;
	
	/**
	 * Constructor de la clase Usuario.
	 * 
	 * @param nombre Nombre del usuario
	 * @param saldo Saldo inicial del usuario
	 * 
	 * <pre>
	 * PRE: nombre != null && !nombre.equals("")
	 *      saldo >= 0
	 * POST: this.nombre == nombre
	 *       this.saldo == saldo
	 * </pre>
	 */
	public Usuario(String nombre, double saldo) 
	{
		this.nombre = nombre;
		this.saldo = saldo;
		
		validarInvariantes();
	}

	/**
	 * Obtiene el nombre del usuario.
	 * 
	 * @return El nombre del usuario
	 * 
	 * <pre>
	 * POST: resultado == this.nombre
	 * </pre>
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 * 
	 * @param nombre Nuevo nombre del usuario
	 * 
	 * <pre>
	 * PRE: nombre != null && !nombre.equals("")
	 * POST: this.nombre == nombre
	 * </pre>
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
		validarInvariantes();
	}

	/**
	 * Obtiene el saldo actual del usuario.
	 * 
	 * @return El saldo del usuario
	 * 
	 * <pre>
	 * POST: resultado == this.saldo
	 * </pre>
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Establece el saldo del usuario.
	 * 
	 * @param saldo Nuevo saldo del usuario
	 * 
	 * <pre>
	 * PRE: saldo >= 0
	 * POST: this.saldo == saldo
	 * </pre>
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
		validarInvariantes();
	}

	/**
	 * Descuenta un monto del saldo del usuario.
	 * 
	 * @param monto Monto a descontar del saldo
	 * 
	 * <pre>
	 * PRE: monto >= 0 && monto <= this.saldo
	 * POST: this.saldo == saldo_anterior - monto
	 * </pre>
	 */
	public void descontarSaldo(double monto)
	{
		this.saldo -= monto;
		validarInvariantes();
	}
	
	public boolean tieneSaldoSuficiente(double monto)
	{
	    return saldo >= monto;
	}

	/**
	 * Retorna una representación en cadena del usuario.
	 * 
	 * @return Cadena con formato "Usuario [nombre=nombre, saldo=saldo]"
	 * 
	 * <pre>
	 * POST: resultado.equals("Usuario [nombre=" + this.nombre + ", saldo=" + this.saldo + "]")
	 * </pre>
	 */
	@Override
	public String toString() 
	{
		return "Usuario [nombre=" + nombre + ", saldo=" + saldo + "]";
	}
	
	/**
	 * Valida que el nombre del usuario sea válido.
	 * 
	 * @return true si el nombre es no nulo y no vacío, false en caso contrario
	 * 
	 * <pre>
	 * POST: resultado == (nombre != null && !nombre.equals(""))
	 * </pre>
	 */
	private boolean validarNombre()
	{
		return nombre != null && !nombre.equals("");
	}
	
	/**
	 * Valida que el saldo del usuario sea válido.
	 * 
	 * @return true si el saldo es mayor o igual a cero, false en caso contrario
	 * 
	 * <pre>
	 * POST: resultado == (saldo >= 0)
	 * </pre>
	 */
	private boolean validarSaldo()
	{
		return saldo >= 0;
	}
	
	/**
	 * Valida los invariantes de la clase (nombre válido y saldo no negativo).
	 * Lanza una AssertionError si alguna validación falla.
	 * 
	 * <pre>
	 * PRE: true
	 * POST: (validarNombre() && validarSaldo()) || se lanza AssertionError
	 * </pre>
	 */
	private void validarInvariantes()
	{
		assert validarNombre(): "El nombre debe ser válido";
		assert validarSaldo(): "El saldo debe ser válido";
	}
}