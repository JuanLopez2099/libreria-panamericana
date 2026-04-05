package mundo;

public class ItemCarrito 
{
	private Producto producto;
	private int cantidad;
	
	public ItemCarrito(Producto producto) 
	{
		this.producto = producto;
		this.cantidad = 1;
	}

	public Producto getProducto() 
	{
		return producto;
	}


	public int getCantidad() 
	{
		return cantidad;
	}

	public void setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
	}
	
	public void setProducto(Producto producto) 
	{
		this.producto = producto;
	}
	
	public void incrementarCantidad()
	{
		this.cantidad++;
	}
	
	public void decrementarCantidad()
	{
		if(cantidad > 1)
		{
			this.cantidad--;
		}
	}
	
	public double getSubtotal()
	{
		return producto.getPrecioFinal() * cantidad;
	}
	
	
	
	
}
