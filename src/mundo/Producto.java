package mundo;

public abstract class Producto 
{

	private String codigo; 
	private String titulo;
	private String nombreAutor;
	private double precio;
	private String categoria;
	private String rutaPortada;
	private String sinopsis;
	private String editorial;
	private String numeroPaginas;
	private String idioma;
	private String fechaPublicacion;
	private boolean tieneDescuento;
	private double porcentajeDescuento;
	private int numeroVentas;
	
	public Producto(String codigo, String titulo, String nombreAutor, double precio, String categoria,
			String rutaPortada, String sinopsis, String editorial, String numeroPaginas, String idioma,
			String fechaPublicacion, boolean tieneDescuento, double porcentajeDescuento, int numeroVentas) 
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
	}
	
	
	
	
}
