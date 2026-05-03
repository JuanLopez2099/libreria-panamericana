package mundo;

import java.util.ArrayList;

import excepciones.LibroNoEncontradoException;

/**
 * Representa la biblioteca del sistema encargada de gestionar una colección de productos.
 *
 * Permite almacenar, buscar, ordenar y filtrar productos como libros físicos y digitales,
 * proporcionando diferentes criterios de consulta y organización.
 *
 * @author Estefania Rodriguez
 * @author Juan Camilo Lopez
 * @version 1.0
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
     * @post Se inicializa la lista de productos y queda vacía
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
     * @pre p != null
     * @post El producto es añadido a la lista de productos de la biblioteca
     *
     * @param p Producto que se desea agregar
     */
    public void agregarProducto(Producto p) 
    {
        productos.add(p);
        validarInvariantes();
    }

    /**
     * Busca un producto en la biblioteca a partir de su código identificador.
     *
     * @pre codigo != null && !codigo.equals("")
     * @post Retorna el producto cuyo código coincide con el valor dado si existe
     *
     * @param codigo Código único del producto a buscar
     * @return Producto que coincide con el código proporcionado
     * @throws LibroNoEncontradoException Si no existe un producto con el código indicado
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
     * Ordena la lista de productos en orden ascendente según el título.
     *
     * @pre productos != null
     * @post La lista de productos queda ordenada alfabéticamente por título
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
     * Ordena la lista de productos en orden ascendente según el precio final.
     *
     * @pre productos != null
     * @post La lista de productos queda ordenada de menor a mayor precio
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
     * Realiza una búsqueda binaria de un producto a partir de su título.
     *
     * @pre La lista de productos debe estar previamente ordenada por título
     * @post Retorna el producto cuyo título coincide con el valor dado si existe
     *
     * @param titulo Título del producto a buscar
     * @return Producto que coincide con el título proporcionado
     * @throws LibroNoEncontradoException Si no se encuentra un producto con el título indicado
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
     * Filtra los productos que pertenecen a una categoría específica.
     *
     * @pre categoria != null
     * @post Retorna una lista con los productos cuya categoría coincide con la indicada
     *
     * @param categoria Categoría utilizada como criterio de filtrado
     * @return Lista de productos que pertenecen a la categoría dada
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
     * Filtra los productos que pertenecen a un autor específico.
     *
     * @pre autor != null
     * @post Retorna una lista con los productos cuyo autor coincide con el indicado
     *
     * @param autor Nombre del autor utilizado como criterio de filtrado
     * @return Lista de productos del autor indicado
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
     * Filtra los productos que se encuentran disponibles.
     *
     * @pre true
     * @post Retorna una lista con los productos que están disponibles
     *
     * @return Lista de productos disponibles
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
     * Filtra los productos que tienen descuento aplicado.
     *
     * @pre true
     * @post Retorna una lista con los productos que tienen descuento
     *
     * @return Lista de productos con descuento
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
     * Obtiene la lista de productos almacenados en la biblioteca.
     *
     * @pre productos != null
     * @post Retorna la referencia a la lista interna de productos
     *
     * @return Lista de productos almacenados en la biblioteca
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Carga un conjunto inicial de libros físicos y digitales en la biblioteca.
     *
     * @pre La lista de productos debe estar inicializada
     * @post Se agregan múltiples libros a la biblioteca
     */
    public void cargarLibros()
    {
        LibroFisico libro1 = new LibroFisico("LF005", "Cien Años de Soledad", "Gabriel García Márquez", 45000, "Novela", "img/cien_anos_de_soledad.jpg", "Esta obra maestra narra la historia de la familia Buendía a lo largo de siete generaciones en el pueblo ficticio de Macondo. Desde la fundación del pueblo por José Arcadio Buendía hasta su inevitable y profético final, la trama entrelaza lo fantástico con lo cotidiano. A través de guerras civiles, amores imposibles, soledad y eventos sobrenaturales como lluvias de flores y ascensos al cielo, la novela se convierte en una metáfora épica de la historia de América Latina y la condición humana misma.", "Sudamericana", "432", "Español", "1967-05-30", false, 0.0, 120, 10);
        agregarProducto(libro1);

        LibroFisico libro2 = new LibroFisico("LF006", "El Principito", "Antoine de Saint-Exupéry", 28000, "Fabula", "img/principito.png", "Tras sufrir un accidente en el desierto del Sahara, un aviador se encuentra con un pequeño príncipe que viene del asteroide B-612. El niño le relata sus viajes por otros planetas, donde ha conocido a personajes extraños que representan las obsesiones y debilidades de los adultos. A través de sus conversaciones y su relación con una rosa y un zorro, el principito enseña lecciones profundas sobre la importancia de la amistad, el amor y la capacidad de ver más allá de las apariencias, recordándonos que lo esencial es invisible a los ojos.", "Reynal & Hitchcock", "96", "Español", "1943-04-06", true, 15.0, 200, 5);
        agregarProducto(libro2);

        LibroFisico libro3 = new LibroFisico("LF004", "Don Quijote de la Mancha", "Miguel de Cervantes", 60000, "Clasico", "img/quijote.jpg", "Alonso Quijano es un hidalgo que, tras perder el juicio por leer demasiados libros de caballería, decide convertirse en caballero andante bajo el nombre de Don Quijote. Junto a su fiel escudero Sancho Panza, recorre España buscando aventuras, deshaciendo entuertos y protegiendo a los desvalidos en honor a su amada Dulcinea del Toboso. La novela explora el conflicto entre el idealismo y el realismo, utilizando el humor y la tragedia para cuestionar la naturaleza de la cordura y la identidad en un mundo que ya no tiene espacio para héroes antiguos.", "Francisco de Robles", "863", "Español", "1605-01-16", false, 0.0, 80, 3);
        agregarProducto(libro3);

        LibroDigitial libro4 = new LibroDigitial("LD002", "Clean Code", "Robert C. Martin", 35000, "Tecnologia", "img/clean_code.png", "Este libro es una guía fundamental para desarrolladores que buscan elevar la calidad de su trabajo. Robert C. Martin presenta una filosofía sobre la importancia de escribir código legible y mantenible, argumentando que incluso el código que funciona puede ser un desastre si no es limpio. A través de ejemplos prácticos y principios como SOLID y la regla del Boy Scout, el autor detalla cómo nombrar variables, estructurar funciones y manejar errores, transformando el desarrollo de software en una artesanía donde la elegancia y la eficiencia van de la mano.", "Prentice Hall", "431", "Inglés", "2008-08-01", true, 20.0, 300, "PDF", 4.2);
        agregarProducto(libro4);

        LibroDigitial libro5 = new LibroDigitial("LD003", "El Alquimista", "Paulo Coelho", 22000, "Novela", "img/alquimista.jpg", "Santiago es un joven pastor andaluz que sueña con encontrar un tesoro escondido en las pirámides de Egipto. Motivado por este sueño, decide abandonar su vida tranquila y emprender un viaje que lo llevará a cruzar el desierto. En su camino, descubre que el verdadero tesoro no son las riquezas materiales, sino el aprendizaje de escuchar a su corazón y la capacidad de descifrar el lenguaje del universo. Es un relato inspirador sobre la perseverancia y la búsqueda de la Leyenda Personal que cada individuo debe cumplir.", "HarperCollins", "208", "Español", "1988-01-01", false, 0.0, 500, "EPUB", 1.8);
        agregarProducto(libro5);

        LibroDigitial libro6 = new LibroDigitial("LD001", "Sapiens", "Yuval Noah Harari", 40000, "Historia", "img/sapiens.jpg", "En este ambicioso recorrido histórico, el autor explora cómo una especie animal insignificante se convirtió en la dueña del planeta. El libro analiza tres grandes revoluciones: la cognitiva, la agrícola y la científica. Harari cuestiona nuestras creencias más arraigadas sobre el dinero, la religión y el poder, explicando cómo los mitos compartidos y las ficciones colectivas permitieron a los humanos colaborar a gran escala. Es una provocativa reflexión sobre nuestro pasado, nuestro presente y hacia dónde nos dirigimos como sociedad global.", "Harper", "443", "Español", "2011-01-01", true, 10.0, 250, "PDF", 5.1);
        agregarProducto(libro6);

        LibroFisico libro7 = new LibroFisico("LF008", "Satanás", "Mario Mendoza", 38000, "Novela", "img/satanas.png", "Galardonada con el Premio Biblioteca Breve, esta impactante novela teje las vidas de tres personajes en la caótica y oscura Bogotá: una mujer hermosa que seduce a ejecutivos para robarles, un sacerdote atormentado por sus demonios y por el peso de los secretos de confesión, y un profesor de arte veterano de guerra que se siente cada vez más alienado de la sociedad. Sus caminos se cruzan fatalmente con la historia real de Campo Elías Delgado, un asesino que protagonizó la masacre del restaurante Pozzetto. Es un viaje psicológico profundo y perturbador a los abismos de la mente humana y la violencia urbana.", "Seix Barral", "288", "Español", "2002-02-01", false, 0.0, 45, 5);
        agregarProducto(libro7);

        LibroDigitial libro8 = new LibroDigitial("LD009", "Vírgenes y toxicómanos", "Mario Mendoza", 25000, "Cuento", "img/virgenes.jpg", "Sumergiéndose de nuevo en las entrañas de la ciudad, esta obra relata la crudeza de la vida en los márgenes urbanos. Con su característico estilo directo y descarnado, Mendoza explora la dualidad de la inocencia perdida y la adicción en un entorno que devora a los más vulnerables. A través de personajes marginados, desde jóvenes soñadoras que enfrentan una realidad implacable hasta individuos atrapados en la espiral de los narcóticos, el autor pinta un fresco desgarrador y a la vez profundamente humano sobre la marginalidad, la redención y las sombras que habitan las calles de la capital.", "Planeta", "198", "Español", "2010-05-15", true, 15.0, 150, "EPUB", 2.5);
        agregarProducto(libro8);

        LibroFisico libro9 = new LibroFisico("LF007", "Leer es resistir", "Mario Mendoza", 42000, "Ensayo", "img/leer_resistir.jpg", "En esta obra íntima y reveladora, Mario Mendoza se aleja de la ficción pura para ofrecernos un manifiesto sobre el poder salvador de la literatura. A través de memorias personales, anécdotas de su formación como lector y escritor, y reflexiones sobre el acto de leer en un mundo consumido por la inmediatez y la superficialidad, el autor nos invita a ver los libros como refugios. La lectura se presenta no solo como un acto de rebeldía contra un sistema que busca estandarizarnos, sino como una herramienta vital para la resistencia intelectual, la empatía y la supervivencia del espíritu libre.", "Planeta", "224", "Español", "2022-10-01", false, 0.0, 60, 4);
        agregarProducto(libro9);
    }

    // -------------------------------------------------------------------------
    // INVARIANTES
    // -------------------------------------------------------------------------

    /**
     * Verifica que la lista de productos esté correctamente inicializada.
     *
     * @pre true
     * @post Retorna true si la lista de productos no es null
     *
     * @return true si la lista es válida, false en caso contrario
     */
    private boolean productosValidos() 
    {
        return productos != null;
    }

    /**
     * Verifica que no existan elementos null dentro de la lista de productos.
     *
     * @pre productos != null
     * @post Retorna true si todos los elementos de la lista son válidos
     *
     * @return true si no hay productos null, false en caso contrario
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
     * Valida las invariantes de la clase para garantizar consistencia interna.
     *
     * @pre true
     * @post Se verifica que la lista de productos exista y no contenga valores null
     */
    private void validarInvariantes() 
    {
        assert productosValidos() : "La lista de productos no puede ser null";
        assert sinProductosNull() : "No puede haber productos null en la biblioteca";
    }
}