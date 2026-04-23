package mundo;

/**
 * Clase abstracta que representa un producto del sistema.
 * <p>
 * Define los atributos y comportamientos comunes a todos los tipos de productos,
 * como libros físicos, audiolibros o ebooks. No puede ser instanciada directamente,
 * sino a través de sus subclases.
 * </p>
 *
 * @author Juan Camilo Lopez, Estefania Rodriguez Gutierrez
 * @version 1.0
 */
public abstract class Producto 
{

	/** Código único identificador del producto. */
	private String codigo;

	/** Título del producto. */
	private String titulo;

	/** Nombre del autor del producto. */
	private String nombreAutor;

	/** Precio base del producto en la moneda del sistema. */
	private double precio;

	/** Categoría a la que pertenece el producto. */
	private String categoria;

	/** Ruta de la imagen de portada del producto. */
	private String rutaPortada;

	/** Sinopsis o descripción breve del producto. */
	private String sinopsis;

	/** Editorial que publicó el producto. */
	private String editorial;

	/** Número de páginas del producto. */
	private String numeroPaginas;

	/** Idioma en el que está disponible el producto. */
	private String idioma;

	/** Fecha de publicación del producto. */
	private String fechaPublicacion;

	/** Indica si el producto tiene descuento activo. */
	private boolean tieneDescuento;

	/** Porcentaje de descuento aplicable al producto (entre 0 y 100). */
	private double porcentajeDescuento;

	/** Número de veces que el producto ha sido vendido. */
	private int numeroVentas;

	// -------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------

	/**
	 * Construye un nuevo producto con todos sus atributos.
	 * <p>
	 * Al finalizar la construcción se verifican las invariantes del objeto
	 * para garantizar que nace en un estado válido.
	 * </p>
	 *
	 * @param codigo              Código único del producto.
	 * @param titulo              Título del producto.
	 * @param nombreAutor         Nombre del autor.
	 * @param precio              Precio base del producto.
	 * @param categoria           Categoría del producto.
	 * @param rutaPortada         Ruta de la imagen de portada.
	 * @param sinopsis            Sinopsis o descripción del producto.
	 * @param editorial           Editorial del producto.
	 * @param numeroPaginas       Número de páginas.
	 * @param idioma              Idioma del producto.
	 * @param fechaPublicacion    Fecha de publicación.
	 * @param tieneDescuento      Indica si tiene descuento activo.
	 * @param porcentajeDescuento Porcentaje de descuento (0-100).
	 * @param numeroVentas        Número de veces vendido.
	 *
	 * @pre codigo != null &amp;&amp; !codigo.isEmpty()
	 * @pre titulo != null &amp;&amp; !titulo.isEmpty()
	 * @pre precio > 0 &amp;&amp; !Double.isNaN(precio) &amp;&amp; !Double.isInfinite(precio)
	 * @pre categoria != null &amp;&amp; !categoria.isEmpty()
	 * @pre rutaPortada != null &amp;&amp; !rutaPortada.isEmpty()
	 * @pre idioma != null &amp;&amp; !idioma.isEmpty()
	 * @pre porcentajeDescuento >= 0 &amp;&amp; porcentajeDescuento &lt;= 100
	 * @pre numeroVentas >= 0
	 *
	 * @post getCodigo().equals(codigo)
	 * @post getTitulo().equals(titulo)
	 * @post getPrecio() == precio
	 * @post getNumeroVentas() == numeroVentas
	 * @post getPorcentajeDescuento() == porcentajeDescuento
	 */
	public Producto(String codigo, String titulo, String nombreAutor, double precio, String categoria, String rutaPortada, String sinopsis, String editorial, String numeroPaginas, String idioma, String fechaPublicacion, boolean tieneDescuento, double porcentajeDescuento, int numeroVentas) 
	{
		this.codigo = codigo;
		this.titulo = titulo;
		this.nombreAutor = nombreAutor;
		this.precio = precio;
		this.categoria = categoria;
		this.rutaPortada = rutaPortada;
		this.sinopsis = sinopsis;
		this.editorial = editorial;
		this.numeroPaginas = numeroPaginas;
		this.idioma = idioma;
		this.fechaPublicacion = fechaPublicacion;
		this.tieneDescuento = tieneDescuento;
		this.porcentajeDescuento = porcentajeDescuento;
		this.numeroVentas = numeroVentas;
		
		validarInvariantes();
	}

	// -------------------------------------------------------------------------
	// Getters
	// -------------------------------------------------------------------------

	/**
	 * Retorna el código único del producto.
	 *
	 * @return El código del producto.
	 *
	 * @pre true
	 * @post El valor retornado no es nulo ni vacío.
	 */
	public String getCodigo() 
	{
		return codigo;
	}

	/**
	 * Retorna el título del producto.
	 *
	 * @return El título del producto.
	 *
	 * @pre true
	 * @post El valor retornado no es nulo ni vacío.
	 */
	public String getTitulo() 
	{
		return titulo;
	}

	/**
	 * Retorna el nombre del autor del producto.
	 *
	 * @return El nombre del autor.
	 *
	 * @pre true
	 * @post El valor retornado puede ser nulo si no fue especificado.
	 */
	public String getNombreAutor() 
	{
		return nombreAutor;
	}

	/**
	 * Retorna el precio base del producto.
	 *
	 * @return El precio base.
	 *
	 * @pre true
	 * @post El valor retornado es mayor que 0.
	 */
	public double getPrecio() 
	{
		return precio;
	}

	/**
	 * Calcula y retorna el precio final del producto.
	 * <p>
	 * Si el producto tiene descuento activo, aplica el porcentaje de descuento
	 * sobre el precio base. De lo contrario, retorna el precio original.
	 * </p>
	 *
	 * @return El precio final con o sin descuento aplicado.
	 *
	 * @pre true
	 * @post isTieneDescuento() ==> result == getPrecio() * (1 - getPorcentajeDescuento() / 100)
	 * @post !isTieneDescuento() ==> result == getPrecio()
	 * @post result > 0
	 */
	public double getPrecioFinal()
	{
		if(tieneDescuento)
		{
			return precio * (1 - porcentajeDescuento / 100);
		}
		
		return precio;
	}

	/**
	 * Retorna la categoría del producto.
	 *
	 * @return La categoría del producto.
	 *
	 * @pre true
	 * @post El valor retornado no es nulo ni vacío.
	 */
	public String getCategoria() 
	{
		return categoria;
	}

	/**
	 * Retorna la ruta de la imagen de portada del producto.
	 *
	 * @return La ruta de la portada.
	 *
	 * @pre true
	 * @post El valor retornado no es nulo ni vacío.
	 */
	public String getRutaPortada() 
	{
		return rutaPortada;
	}

	/**
	 * Retorna la sinopsis del producto.
	 *
	 * @return La sinopsis del producto.
	 *
	 * @pre true
	 * @post El valor retornado puede ser nulo si no fue especificado.
	 */
	public String getSinopsis() 
	{
		return sinopsis;
	}

	/**
	 * Retorna la editorial del producto.
	 *
	 * @return La editorial del producto.
	 *
	 * @pre true
	 * @post El valor retornado puede ser nulo si no fue especificado.
	 */
	public String getEditorial() 
	{
		return editorial;
	}

	/**
	 * Retorna el número de páginas del producto.
	 *
	 * @return El número de páginas.
	 *
	 * @pre true
	 * @post El valor retornado puede ser nulo si no fue especificado.
	 */
	public String getNumeroPaginas() 
	{
		return numeroPaginas;
	}

	/**
	 * Retorna el idioma del producto.
	 *
	 * @return El idioma del producto.
	 *
	 * @pre true
	 * @post El valor retornado no es nulo ni vacío.
	 */
	public String getIdioma() 
	{
		return idioma;
	}

	/**
	 * Retorna la fecha de publicación del producto.
	 *
	 * @return La fecha de publicación.
	 *
	 * @pre true
	 * @post El valor retornado puede ser nulo si no fue especificado.
	 */
	public String getFechaPublicacion() 
	{
		return fechaPublicacion;
	}

	/**
	 * Indica si el producto tiene descuento activo.
	 *
	 * @return {@code true} si tiene descuento, {@code false} en caso contrario.
	 *
	 * @pre true
	 * @post true
	 */
	public boolean isTieneDescuento() 
	{
		return tieneDescuento;
	}

	/**
	 * Retorna el porcentaje de descuento del producto.
	 *
	 * @return El porcentaje de descuento (entre 0 y 100).
	 *
	 * @pre true
	 * @post result >= 0 &amp;&amp; result &lt;= 100
	 */
	public double getPorcentajeDescuento() 
	{
		return porcentajeDescuento;
	}

	/**
	 * Retorna el número de veces que el producto ha sido vendido.
	 *
	 * @return El número de ventas.
	 *
	 * @pre true
	 * @post result >= 0
	 */
	public int getNumeroVentas() 
	{
		return numeroVentas;
	}

	// -------------------------------------------------------------------------
	// Setters
	// -------------------------------------------------------------------------

	/**
	 * Establece el código del producto.
	 *
	 * @param codigo El nuevo código del producto.
	 *
	 * @pre codigo != null &amp;&amp; !codigo.isEmpty()
	 * @post getCodigo().equals(codigo)
	 *
	 * @throws AssertionError Si las precondiciones no se cumplen y las aserciones están habilitadas.
	 */
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
		validarInvariantes();
	}

	/**
	 * Establece el título del producto.
	 *
	 * @param titulo El nuevo título del producto.
	 *
	 * @pre titulo != null &amp;&amp; !titulo.isEmpty()
	 * @post getTitulo().equals(titulo)
	 *
	 * @throws AssertionError Si las precondiciones no se cumplen y las aserciones están habilitadas.
	 */
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
		validarInvariantes();
	}

	/**
	 * Establece el nombre del autor del producto.
	 *
	 * @param nombreAutor El nuevo nombre del autor.
	 *
	 * @pre true
	 * @post getNombreAutor().equals(nombreAutor)
	 */
	public void setNombreAutor(String nombreAutor)
	{
		this.nombreAutor = nombreAutor;
		validarInvariantes();
	}

	/**
	 * Establece el precio base del producto.
	 *
	 * @param precio El nuevo precio base. Debe ser mayor que 0.
	 *
	 * @pre precio > 0 &amp;&amp; !Double.isNaN(precio) &amp;&amp; !Double.isInfinite(precio)
	 * @post getPrecio() == precio
	 *
	 * @throws AssertionError Si el precio no es un número finito positivo y las aserciones están habilitadas.
	 */
	public void setPrecio(double precio)
	{
		this.precio = precio;
		validarInvariantes();
	}

	/**
	 * Establece la categoría del producto.
	 *
	 * @param categoria La nueva categoría del producto.
	 *
	 * @pre categoria != null &amp;&amp; !categoria.isEmpty()
	 * @post getCategoria().equals(categoria)
	 *
	 * @throws AssertionError Si las precondiciones no se cumplen y las aserciones están habilitadas.
	 */
	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
		validarInvariantes();
	}

	/**
	 * Establece la ruta de la imagen de portada del producto.
	 *
	 * @param rutaPortada La nueva ruta de la portada.
	 *
	 * @pre rutaPortada != null &amp;&amp; !rutaPortada.isEmpty()
	 * @post getRutaPortada().equals(rutaPortada)
	 *
	 * @throws AssertionError Si las precondiciones no se cumplen y las aserciones están habilitadas.
	 */
	public void setRutaPortada(String rutaPortada)
	{
		this.rutaPortada = rutaPortada;
		validarInvariantes();
	}

	/**
	 * Establece la sinopsis del producto.
	 *
	 * @param sinopsis La nueva sinopsis del producto.
	 *
	 * @pre true
	 * @post getSinopsis().equals(sinopsis)
	 */
	public void setSinopsis(String sinopsis)
	{
		this.sinopsis = sinopsis;
		validarInvariantes();
	}

	/**
	 * Establece la editorial del producto.
	 *
	 * @param editorial La nueva editorial del producto.
	 *
	 * @pre true
	 * @post getEditorial().equals(editorial)
	 */
	public void setEditorial(String editorial)
	{
		this.editorial = editorial;
		validarInvariantes();
	}

	/**
	 * Establece el número de páginas del producto.
	 *
	 * @param numeroPaginas El nuevo número de páginas.
	 *
	 * @pre true
	 * @post getNumeroPaginas().equals(numeroPaginas)
	 */
	public void setNumeroPaginas(String numeroPaginas)
	{
		this.numeroPaginas = numeroPaginas;
		validarInvariantes();
	}

	/**
	 * Establece el idioma del producto.
	 *
	 * @param idioma El nuevo idioma del producto.
	 *
	 * @pre idioma != null &amp;&amp; !idioma.isEmpty()
	 * @post getIdioma().equals(idioma)
	 *
	 * @throws AssertionError Si las precondiciones no se cumplen y las aserciones están habilitadas.
	 */
	public void setIdioma(String idioma)
	{
		this.idioma = idioma;
		validarInvariantes();
	}

	/**
	 * Establece la fecha de publicación del producto.
	 *
	 * @param fechaPublicacion La nueva fecha de publicación.
	 *
	 * @pre true
	 * @post getFechaPublicacion().equals(fechaPublicacion)
	 */
	public void setFechaPublicacion(String fechaPublicacion)
	{
		this.fechaPublicacion = fechaPublicacion;
		validarInvariantes();
	}

	/**
	 * Establece el porcentaje de descuento del producto.
	 *
	 * @param porcentajeDescuento El nuevo porcentaje de descuento (entre 0 y 100).
	 *
	 * @pre porcentajeDescuento >= 0 &amp;&amp; porcentajeDescuento &lt;= 100
	 * @post getPorcentajeDescuento() == porcentajeDescuento
	 *
	 * @throws AssertionError Si el porcentaje está fuera del rango [0, 100] y las aserciones están habilitadas.
	 */
	public void setPorcentajeDescuento(double porcentajeDescuento)
	{
		this.porcentajeDescuento = porcentajeDescuento;
		validarInvariantes();
	}

	/**
	 * Establece el número de ventas del producto.
	 *
	 * @param numeroVentas El nuevo número de ventas. Debe ser mayor o igual a 0.
	 *
	 * @pre numeroVentas >= 0
	 * @post getNumeroVentas() == numeroVentas
	 *
	 * @throws AssertionError Si el número de ventas es negativo y las aserciones están habilitadas.
	 */
	public void setNumeroVentas(int numeroVentas)
	{
		this.numeroVentas = numeroVentas;
		validarInvariantes();
	}

	// -------------------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------------------

	/**
	 * Incrementa el número de ventas del producto en la cantidad indicada.
	 *
	 * @param veces Cantidad de ventas a agregar. Se espera que sea un valor positivo.
	 *
	 * @pre veces > 0
	 * @post getNumeroVentas() == old(getNumeroVentas()) + veces
	 */
	public void incrementarVecesVendido(int veces)
	{
		this.numeroVentas += veces;
	}

	/**
	 * Retorna el tipo de producto.
	 * <p>
	 * Cada subclase debe implementar este método retornando
	 * una cadena que identifique su tipo (por ejemplo: "Libro", "Audiolibro").
	 * </p>
	 *
	 * @return Una cadena con el tipo de producto.
	 *
	 * @pre true
	 * @post result != null &amp;&amp; !result.isEmpty()
	 */
	public abstract String getTipo();

	/**
	 * Indica si el producto está disponible para su compra.
	 * <p>
	 * Cada subclase define sus propias condiciones de disponibilidad.
	 * </p>
	 *
	 * @return {@code true} si el producto está disponible, {@code false} en caso contrario.
	 *
	 * @pre true
	 * @post true
	 */
	public abstract boolean estaDisponible();

	/**
	 * Retorna una representación en texto del producto con todos sus atributos.
	 *
	 * @return Una cadena con la información completa del producto.
	 *
	 * @pre true
	 * @post result != null &amp;&amp; !result.isEmpty()
	 */
	@Override
	public String toString() 
	{
		return "Producto [codigo=" + codigo + ", titulo=" + titulo + ", nombreAutor=" + nombreAutor + ", precio="
				+ precio + ", categoria=" + categoria + ", rutaPortada=" + rutaPortada + ", sinopsis=" + sinopsis
				+ ", editorial=" + editorial + ", numeroPaginas=" + numeroPaginas + ", idioma=" + idioma
				+ ", fechaPublicacion=" + fechaPublicacion + ", tieneDescuento=" + tieneDescuento
				+ ", porcentajeDescuento=" + porcentajeDescuento + ", numeroVentas=" + numeroVentas + "]";
	}

	// -------------------------------------------------------------------------
	// Invariantes
	// -------------------------------------------------------------------------

	/**
	 * Verifica que el código del producto sea válido.
	 *
	 * @return {@code true} si el código no es nulo ni vacío.
	 */
	private boolean codigoValido() 
	{
		return codigo != null && !codigo.equals("");
	}

	/**
	 * Verifica que el título del producto sea válido.
	 *
	 * @return {@code true} si el título no es nulo ni vacío.
	 */
	private boolean tituloValido()
	{
		return titulo != null && !titulo.equals("");
	}

	/**
	 * Verifica que el precio del producto sea válido.
	 * <p>
	 * El precio es válido si no es NaN, no es infinito y es mayor que 0.
	 * </p>
	 *
	 * @return {@code true} si el precio es un número finito y positivo.
	 */
	private boolean precioValido()
	{
		return !Double.isNaN(precio) && !Double.isInfinite(precio) && precio > 0; 
	}

	/**
	 * Verifica que la categoría del producto sea válida.
	 *
	 * @return {@code true} si la categoría no es nula ni vacía.
	 */
	private boolean categoriaValido()
	{
		return categoria != null && !categoria.equals("");
	}

	/**
	 * Verifica que la ruta de la portada sea válida.
	 *
	 * @return {@code true} si la ruta no es nula ni vacía.
	 */
	private boolean rutaPortadaValida()
	{
		return rutaPortada != null && !rutaPortada.equals("");
	}

	/**
	 * Verifica que el idioma del producto sea válido.
	 *
	 * @return {@code true} si el idioma no es nulo ni vacío.
	 */
	private boolean idiomaValido()
	{
		return idioma != null && !idioma.equals("");
	}

	/**
	 * Verifica que el porcentaje de descuento sea válido.
	 * <p>
	 * El porcentaje es válido si está entre 0 y 100 inclusive.
	 * </p>
	 *
	 * @return {@code true} si el porcentaje está en el rango [0, 100].
	 */
	private boolean porcentajeDescuentoValido()
	{
		return porcentajeDescuento >= 0 && porcentajeDescuento <= 100;
	}

	/**
	 * Verifica que el número de ventas sea válido.
	 *
	 * @return {@code true} si el número de ventas es mayor o igual a 0.
	 */
	private boolean numeroVentasValido()
	{
		return numeroVentas >= 0;
	}

	/**
	 * Verifica todas las invariantes de la clase.
	 * <p>
	 * Este método es llamado al final del constructor y en cada setter
	 * para garantizar que el objeto siempre se encuentre en un estado válido.
	 * </p>
	 */
	private void validarInvariantes()
	{
		assert codigoValido()             : "El codigo es invalido";
		assert tituloValido()             : "El titulo es invalido";
		assert precioValido()             : "El precio base es invalido";
		assert categoriaValido()          : "La categoria debe ser valida";
		assert rutaPortadaValida()        : "La ruta de la portada debe ser valida";
		assert idiomaValido()             : "El idioma debe ser valido";
		assert porcentajeDescuentoValido(): "El porcentaje de descuento debe ser valido";
		assert numeroVentasValido()       : "El numero de ventas debe ser valido";
	}
}