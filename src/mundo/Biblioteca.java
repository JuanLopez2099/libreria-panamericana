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
    
    /**
     * Carga los libros iniciales en la biblioteca.
     * 
     * @pre La lista de productos debe existir
     * @post Libros agregados
     */
    public void cargarLibros()
    {
    	LibroFisico libro1 = new LibroFisico("LF005", "Cien Años de Soledad", "Gabriel García Márquez", 45000, "Novela", "img/cien_anos_de_soledad.jpg", "Esta obra maestra narra la historia de la familia Buendía a lo largo de siete generaciones en el pueblo ficticio de Macondo. Desde la fundación del pueblo por José Arcadio Buendía hasta su inevitable y profético final, la trama entrelaza lo fantástico con lo cotidiano. A través de guerras civiles, amores imposibles, soledad y eventos sobrenaturales como lluvias de flores y ascensos al cielo, la novela se convierte en una metáfora épica de la historia de América Latina y la condición humana misma.", "Sudamericana", "432", "Español", "1967-05-30", false, 0.0, 120, 10);
    	agregarProducto(libro1);

    	LibroFisico libro2 = new LibroFisico("LF006", "El Principito", "Antoine de Saint-Exupéry", 28000, "Fábula", "img/principito.png", "Tras sufrir un accidente en el desierto del Sahara, un aviador se encuentra con un pequeño príncipe que viene del asteroide B-612. El niño le relata sus viajes por otros planetas, donde ha conocido a personajes extraños que representan las obsesiones y debilidades de los adultos. A través de sus conversaciones y su relación con una rosa y un zorro, el principito enseña lecciones profundas sobre la importancia de la amistad, el amor y la capacidad de ver más allá de las apariencias, recordándonos que lo esencial es invisible a los ojos.", "Reynal & Hitchcock", "96", "Español", "1943-04-06", true, 15.0, 200, 5);
    	agregarProducto(libro2);

    	LibroFisico libro3 = new LibroFisico("LF004", "Don Quijote de la Mancha", "Miguel de Cervantes", 60000, "Clásico", "img/quijote.jpg", "Alonso Quijano es un hidalgo que, tras perder el juicio por leer demasiados libros de caballería, decide convertirse en caballero andante bajo el nombre de Don Quijote. Junto a su fiel escudero Sancho Panza, recorre España buscando aventuras, deshaciendo entuertos y protegiendo a los desvalidos en honor a su amada Dulcinea del Toboso. La novela explora el conflicto entre el idealismo y el realismo, utilizando el humor y la tragedia para cuestionar la naturaleza de la cordura y la identidad en un mundo que ya no tiene espacio para héroes antiguos.", "Francisco de Robles", "863", "Español", "1605-01-16", false, 0.0, 80, 3);
    	agregarProducto(libro3);

    	LibroDigitial libro4 = new LibroDigitial("LD002", "Clean Code", "Robert C. Martin", 35000, "Tecnología", "img/clean_code.png", "Este libro es una guía fundamental para desarrolladores que buscan elevar la calidad de su trabajo. Robert C. Martin presenta una filosofía sobre la importancia de escribir código legible y mantenible, argumentando que incluso el código que funciona puede ser un desastre si no es limpio. A través de ejemplos prácticos y principios como SOLID y la regla del Boy Scout, el autor detalla cómo nombrar variables, estructurar funciones y manejar errores, transformando el desarrollo de software en una artesanía donde la elegancia y la eficiencia van de la mano.", "Prentice Hall", "431", "Inglés", "2008-08-01", true, 20.0, 300, "PDF", 4.2);
    	agregarProducto(libro4);

    	LibroDigitial libro5 = new LibroDigitial("LD003", "El Alquimista", "Paulo Coelho", 22000, "Novela", "img/alquimista.jpg", "Santiago es un joven pastor andaluz que sueña con encontrar un tesoro escondido en las pirámides de Egipto. Motivado por este sueño, decide abandonar su vida tranquila y emprender un viaje que lo llevará a cruzar el desierto. En su camino, descubre que el verdadero tesoro no son las riquezas materiales, sino el aprendizaje de escuchar a su corazón y la capacidad de descifrar el lenguaje del universo. Es un relato inspirador sobre la perseverancia y la búsqueda de la Leyenda Personal que cada individuo debe cumplir.", "HarperCollins", "208", "Español", "1988-01-01", false, 0.0, 500, "EPUB", 1.8);
    	agregarProducto(libro5);

    	LibroDigitial libro6 = new LibroDigitial("LD001", "Sapiens", "Yuval Noah Harari", 40000, "Historia", "img/sapiens.jpg", "En este ambicioso recorrido histórico, el autor explora cómo una especie animal insignificante se convirtió en la dueña del planeta. El libro analiza tres grandes revoluciones: la cognitiva, la agrícola y la científica. Harari cuestiona nuestras creencias más arraigadas sobre el dinero, la religión y el poder, explicando cómo los mitos compartidos y las ficciones colectivas permitieron a los humanos colaborar a gran escala. Es una provocativa reflexión sobre nuestro pasado, nuestro presente y hacia dónde nos dirigimos como sociedad global.", "Harper", "443", "Español", "2011-01-01", true, 10.0, 250, "PDF", 5.1);
    	agregarProducto(libro6);
    	
    	
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