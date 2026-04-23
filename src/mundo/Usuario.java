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
	private double Saldo;
	
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
	 *       this.Saldo == saldo
	 * </pre>
	 */
	public Usuario(String nombre, double saldo) 
	{
		this.nombre = nombre;
		Saldo = saldo;
		
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
	 * POST: resultado == this.Saldo
	 * </pre>
	 */
	public double getSaldo() {
		return Saldo;
	}

	/**
	 * Establece el saldo del usuario.
	 * 
	 * @param saldo Nuevo saldo del usuario
	 * 
	 * <pre>
	 * PRE: saldo >= 0
	 * POST: this.Saldo == saldo
	 * </pre>
	 */
	public void setSaldo(double saldo) {
		Saldo = saldo;
		validarInvariantes();
	}

	/**
	 * Retorna una representación en cadena del usuario.
	 * 
	 * @return Cadena con formato "Usuario [nombre=nombre, Saldo=saldo]"
	 * 
	 * <pre>
	 * POST: resultado.equals("Usuario [nombre=" + this.nombre + ", Saldo=" + this.Saldo + "]")
	 * </pre>
	 */
	@Override
	public String toString() 
	{
		return "Usuario [nombre=" + nombre + ", Saldo=" + Saldo + "]";
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
	 * POST: resultado == (Saldo >= 0)
	 * </pre>
	 */
	private boolean validarSaldo()
	{
		return Saldo >= 0;
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