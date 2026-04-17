package mundo;

import java.util.ArrayList;

import excepciones.LibroNoEncontradoException;

/**
 * Clase que representa la biblioteca del sistema.
 * <p>
 * Administra una colección de productos (libros físicos y digitales),
 * permitiendo agregarlos, buscarlos, ordenarlos y filtrarlos.
 * </p>
 */
public class Biblioteca 
{
    /** Lista de productos almacenados en la biblioteca */
    private ArrayList<Producto> productos;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * Construye una biblioteca vacía.
     * 
     * @pre true
     * @post productos != null && productos está vacía
     */
    public Biblioteca() 
    {
        productos = new ArrayList<>();
        validarInvariantes();
    }

    // -------------------------------------------------------------------------
    // Métodos básicos
    // -------------------------------------------------------------------------

    /**
     * Agrega un producto a la biblioteca.
     * 
     * @param p Producto a agregar
     * 
     * @pre p != null
     * @post El producto queda agregado a la lista
     */
    public void agregarProducto(Producto p) 
    {
        productos.add(p);
        validarInvariantes();
    }

    /**
     * Busca un producto por su código.
     * 
     * @param codigo Código del producto
     * @return Producto encontrado
     * @throws LibroNoEncontradoException Si no se encuentra el producto
     * 
     * @pre codigo != null && !codigo.equals("")
     * @post Se retorna el producto con el código dado si existe
     */
    public Producto buscarPorCodigo(String codigo) throws LibroNoEncontradoException 
    {
        for (Producto p : productos) 
        {
            if (p.getCodigo().equalsIgnoreCase(codigo)) 
            {
                return p;
            }
        }

        throw new LibroNoEncontradoException("No se encontró el producto con código: " + codigo);
    }

    // -------------------------------------------------------------------------
    // ORDENAMIENTOS (Selection Sort)
    // -------------------------------------------------------------------------

    /**
     * Ordena los productos por título usando Selection Sort.
     * 
     * @pre productos != null
     * @post Los productos quedan ordenados ascendentemente por título
     */
    public void ordenarPorTitulo() 
    {
        int n = productos.size();

        for (int i = 0; i < n - 1; i++) 
        {
            int min = i;

            for (int j = i + 1; j < n; j++) 
            {
                if (productos.get(j).getTitulo().compareTo(productos.get(min).getTitulo()) < 0)
                         
                {
                    min = j;
                }
            }

            Producto temp = productos.get(i);
            productos.set(i, productos.get(min));
            productos.set(min, temp);
        }
    }

    /**
     * Ordena los productos por precio usando Selection Sort.
     * 
     * @pre productos != null
     * @post Los productos quedan ordenados ascendentemente por precio
     */
    public void ordenarPorPrecio() 
    {
        int n = productos.size();

        for (int i = 0; i < n - 1; i++) 
        {
            int min = i;

            for (int j = i + 1; j < n; j++) 
            {
                if (productos.get(j).getPrecioFinal() < productos.get(min).getPrecioFinal()) 
                {
                    min = j;
                }
            }

            Producto temp = productos.get(i);
            productos.set(i, productos.get(min));
            productos.set(min, temp);
        }
    }

    // -------------------------------------------------------------------------
    // BÚSQUEDAS
    // -------------------------------------------------------------------------

    /**
     * Realiza una búsqueda binaria por título.
     * 
     * @param titulo Título a buscar
     * @return Producto encontrado
     * @throws LibroNoEncontradoException Si no se encuentra el producto
     * 
     * @pre productos ordenados por título
     * @post Se retorna el producto si existe
     */
    public Producto busquedaBinariaPorTitulo(String titulo) throws LibroNoEncontradoException 
    {
        int inicio = 0;
        int fin = productos.size() - 1;

        while (inicio <= fin) 
        {
            int medio = inicio + (fin - inicio) /2;

            if(productos.get(medio).getTitulo().equalsIgnoreCase(titulo)) 
            {
                return productos.get(medio);
            } 
            else if(productos.get(medio).getTitulo().compareToIgnoreCase(titulo) > 0) 
            {
                fin = medio - 1;
            } 
            else 
            {
                inicio = medio + 1;
            }
        }

        throw new LibroNoEncontradoException("No se encontró el libro con título: " + titulo);
    }

    // -------------------------------------------------------------------------
    // FILTROS
    // -------------------------------------------------------------------------

    /**
     * Filtra productos por categoría.
     * 
     * @param categoria Categoría a filtrar
     * @return Lista de productos de esa categoría
     * 
     * @pre categoria != null
     * @post Se retorna una lista con productos de la categoría indicada
     */
    public ArrayList<Producto> filtrarPorCategoria(String categoria) 
    {
        ArrayList<Producto> resultado = new ArrayList<>();

        for (Producto p : productos) 
        {
            if(p.getCategoria().equalsIgnoreCase(categoria)) 
            {
                resultado.add(p);
            }
        }

        return resultado;
    }

    /**
     * Filtra productos por autor.
     * 
     * @param autor Nombre del autor
     * @return Lista de productos del autor
     * 
     * @pre autor != null
     * @post Se retorna una lista con productos del autor indicado
     */
    public ArrayList<Producto> filtrarPorAutor(String autor) 
    {
        ArrayList<Producto> resultado = new ArrayList<>();

        for (Producto p : productos) 
        {
            if(p.getNombreAutor().equalsIgnoreCase(autor)) 
            {
                resultado.add(p);
            }
        }

        return resultado;
    }

    /**
     * Retorna los productos disponibles.
     * 
     * @return Lista de productos disponibles
     * 
     * @pre true
     * @post Se retorna una lista con productos disponibles
     */
    public ArrayList<Producto> filtrarDisponibles() 
    {
        ArrayList<Producto> resultado = new ArrayList<>();

        for(Producto p : productos) 
        {
            if (p.estaDisponible()) 
            {
                resultado.add(p);
            }
        }

        return resultado;
    }

    /**
     * Retorna los productos con descuento.
     * 
     * @return Lista de productos con descuento
     * 
     * @pre true
     * @post Se retorna una lista con productos con descuento
     */
    public ArrayList<Producto> filtrarConDescuento() 
    {
        ArrayList<Producto> resultado = new ArrayList<>();

        for(Producto p : productos) 
        {
            if (p.isTieneDescuento()) 
            {
                resultado.add(p);
            }
        }

        return resultado;
    }

    
    /**
     * Retorna la lista de productos almacenados en la biblioteca.
     * 
     * @return Lista de productos de la biblioteca
     * 
     * @pre productos != null
     * @post Se retorna la referencia a la lista interna de productos
     */
    public ArrayList<Producto> getProductos() {
		return productos;
	}


    // -------------------------------------------------------------------------
    // INVARIANTES
    // -------------------------------------------------------------------------

   
	/**
     * Verifica que la lista de productos no sea null.
     */
    private boolean productosValidos() 
    {
        return productos != null;
    }

    /**
     * Verifica que no existan productos null en la lista.
     */
    private boolean sinProductosNull() 
    {
        for(Producto p : productos) 
        {
            if (p == null) 
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica todas las invariantes de la clase.
     */
    private void validarInvariantes() 
    {
        assert productosValidos() : "La lista de productos no puede ser null";
        assert sinProductosNull() : "No puede haber productos null en la biblioteca";
    }
}