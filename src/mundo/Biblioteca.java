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
    	LibroFisico libro1 = new LibroFisico("LF005", "Cien Años de Soledad", "Gabriel Garcia Marquez", 45000, "Novela", "img/cien_anos_de_soledad.jpg", "Esta obra maestra narra la historia de la familia Buendia a lo largo de siete generaciones en el pueblo ficticio de Macondo. Desde la fundacion del pueblo por Jose Arcadio Buendia hasta su inevitable y profetico final, la trama entrelaza lo fantastico con lo cotidiano. A traves de guerras civiles, amores imposibles, soledad y eventos sobrenaturales como lluvias de flores y ascensos al cielo, la novela se convierte en una metafora epica de la historia de America Latina y la condicion humana misma.", "Sudamericana", "432", "Español", "1967-05-30", false, 0.0, 120);
        agregarProducto(libro1);

        LibroFisico libro2 = new LibroFisico("LF006", "El Principito", "Antoine de Saint-Exupery", 28000, "Fabula", "img/principito.png", "Tras sufrir un accidente en el desierto del Sahara, un aviador se encuentra con un pequeño principe que viene del asteroide B-612. El niño le relata sus viajes por otros planetas, donde ha conocido a personajes extraños que representan las obsesiones y debilidades de los adultos. A traves de sus conversaciones y su relacion con una rosa y un zorro, el principito enseña lecciones profundas sobre la importancia de la amistad, el amor y la capacidad de ver mas alla de las apariencias, recordandonos que lo esencial es invisible a los ojos.", "Reynal & Hitchcock", "96", "Español", "1943-04-06", true, 15.0, 200);
        agregarProducto(libro2);

        LibroFisico libro3 = new LibroFisico("LF004", "Don Quijote de la Mancha", "Miguel de Cervantes", 60000, "Clasico", "img/quijote.jpg", "Alonso Quijano es un hidalgo que, tras perder el juicio por leer demasiados libros de caballeria, decide convertirse en caballero andante bajo el nombre de Don Quijote. Junto a su fiel escudero Sancho Panza, recorre España buscando aventuras, deshaciendo entuertos y protegiendo a los desvalidos en honor a su amada Dulcinea del Toboso. La novela explora el conflicto entre el idealismo y el realismo, utilizando el humor y la tragedia para cuestionar la naturaleza de la cordura y la identidad en un mundo que ya no tiene espacio para heroes antiguos.", "Francisco de Robles", "863", "Español", "1605-01-16", false, 0.0, 80);
        agregarProducto(libro3);

        LibroDigitial libro4 = new LibroDigitial("LD002", "Clean Code", "Robert C. Martin", 35000, "Tecnologia", "img/clean_code.png", "Este libro es una guia fundamental para desarrolladores que buscan elevar la calidad de su trabajo. Robert C. Martin presenta una filosofia sobre la importancia de escribir codigo legible y mantenible, argumentando que incluso el codigo que funciona puede ser un desastre si no es limpio. A traves de ejemplos practicos y principios como SOLID y la regla del Boy Scout, el autor detalla como nombrar variables, estructurar funciones y manejar errores, transformando el desarrollo de software en una artesania donde la elegancia y la eficiencia van de la mano.", "Prentice Hall", "431", "Ingles", "2008-08-01", true, 20.0, "PDF", 4.2);
        agregarProducto(libro4);

        LibroDigitial libro5 = new LibroDigitial("LD003", "El Alquimista", "Paulo Coelho", 22000, "Novela", "img/alquimista.jpg", "Santiago es un joven pastor andaluz que sueña con encontrar un tesoro escondido en las piramides de Egipto. Motivado por este sueño, decide abandonar su vida tranquila y emprender un viaje que lo llevara a cruzar el desierto. En su camino, descubre que el verdadero tesoro no son las riquezas materiales, sino el aprendizaje de escuchar a su corazon y la capacidad de descifrar el lenguaje del universo. Es un relato inspirador sobre la perseverancia y la busqueda de la Leyenda Personal que cada individuo debe cumplir.", "HarperCollins", "208", "Español", "1988-01-01", false, 0.0, "EPUB", 1.8);
        agregarProducto(libro5);

        LibroDigitial libro6 = new LibroDigitial("LD001", "Sapiens", "Yuval Noah Harari", 40000, "Historia", "img/sapiens.jpg", "En este ambicioso recorrido historico, el autor explora como una especie animal insignificante se convirtio en la dueña del planeta. El libro analiza tres grandes revoluciones: la cognitiva, la agricola y la cientifica. Harari cuestiona nuestras creencias mas arraigadas sobre el dinero, la religion y el poder, explicando como los mitos compartidos y las ficciones colectivas permitieron a los humanos colaborar a gran escala. Es una provocativa reflexion sobre nuestro pasado, nuestro presente y hacia donde nos dirigimos como sociedad global.", "Harper", "443", "Español", "2011-01-01", true, 10.0, "PDF", 5.1);
        agregarProducto(libro6);

        LibroFisico libro7 = new LibroFisico("LF008", "Satanas", "Mario Mendoza", 38000, "Novela", "img/satanas.png", "Galardonada con el Premio Biblioteca Breve, esta impactante novela teje las vidas de tres personajes en la caotica y oscura Bogota: una mujer hermosa que seduce a ejecutivos para robarles, un sacerdote atormentado por sus demonios y por el peso de los secretos de confesion, y un profesor de arte veterano de guerra que se siente cada vez mas alienado de la sociedad. Sus caminos se cruzan fatalmente con la historia real de Campo Elias Delgado, un asesino que protagonizo la masacre del restaurante Pozzetto. Es un viaje psicologico profundo y perturbador a los abismos de la mente humana y la violencia urbana.", "Seix Barral", "288", "Español", "2002-02-01", false, 0.0, 45);
        agregarProducto(libro7);

        LibroDigitial libro8 = new LibroDigitial("LD009", "Virgenes y toxicomanos", "Mario Mendoza", 25000, "Cuento", "img/virgenes.jpg", "Sumergiendose de nuevo en las entrañas de la ciudad, esta obra relata la crudeza de la vida en los margenes urbanos. Con su caracteristico estilo directo y descarnado, Mendoza explora la dualidad de la inocencia perdida y la adiccion en un entorno que devora a los mas vulnerables. A traves de personajes marginados, desde jovenes soñadoras que enfrentan una realidad implacable hasta individuos atrapados en la espiral de los narcoticos, el autor pinta un fresco desgarrador y a la vez profundamente humano sobre la marginalidad, la redencion y las sombras que habitan las calles de la capital.", "Planeta", "198", "Español", "2010-05-15", true, 15.0, "EPUB", 2.5);
        agregarProducto(libro8);

        LibroFisico libro9 = new LibroFisico("LF007", "Leer es resistir", "Mario Mendoza", 42000, "Ensayo", "img/leer_resistir.jpg", "En esta obra intima y reveladora, Mario Mendoza se aleja de la ficcion pura para ofrecernos un manifiesto sobre el poder salvador de la literatura. A traves de memorias personales, anecdotas de su formacion como lector y escritor, y reflexiones sobre el acto de leer en un mundo consumido por la inmediatez y la superficialidad, el autor nos invita a ver los libros como refugios. La lectura se presenta no solo como un acto de rebeldia contra un sistema que busca estandarizarnos, sino como una herramienta vital para la resistencia intelectual, la empatia y la supervivencia del espiritu libre.", "Planeta", "224", "Español", "2022-10-01", false, 0.0, 60);
        agregarProducto(libro9);
        
        LibroFisico libro10 = new LibroFisico("LF083", "La ContraHistoria de España", "Fernando Diaz Villanueva", 45000, "Historia", "img/la_contrahistoria_de_espana.png", "Una revisión crítica y desmitificadora de la historia de España, desde sus orígenes hasta la era contemporánea. El autor desmenuza los relatos tradicionales para ofrecer una perspectiva fresca sobre los eventos que forjaron la nación, desmontando la leyenda negra y arrojando luz sobre episodios olvidados que son fundamentales para entender el presente y la herencia cultural hispana.", "Esfera de los Libros", "450", "Español", "2021-04-14", false, 0.0, 150);
        agregarProducto(libro10);
        
        LibroFisico libro11 = new LibroFisico("LF012", "Lady Masacre", "Mario Mendoza", 35000, "Novela", "img/lady_masacre.jpg", "En esta absorbente novela negra, el investigador Frank Molina se enfrenta a un caso de asesinato que expone las oscuras entrañas de la política y la corrupción en Bogotá. Con un ritmo vertiginoso, la obra explora la decadencia moral de una sociedad atrapada en la violencia, donde los verdaderos monstruos caminan con trajes elegantes y las víctimas claman por una justicia que parece inalcanzable.", "Planeta", "320", "Español", "2013-09-01", true, 10.0, 85);
        agregarProducto(libro11);

        LibroFisico libro12 = new LibroFisico("LF045", "1984", "George Orwell", 28000, "Novela", "img/1984.jpg", "Una escalofriante distopía que nos sumerge en una sociedad totalitaria gobernada por el omnipresente Gran Hermano. Winston Smith, un trabajador del Ministerio de la Verdad, comienza a cuestionar el sistema de vigilancia absoluta y la manipulación del lenguaje y la historia. Es una advertencia eterna sobre los peligros del autoritarismo, la pérdida de la privacidad y el control de la información.", "Secker & Warburg", "328", "Ingles", "1949-06-08", false, 0.0, 200);
        agregarProducto(libro12);
        
        LibroFisico libro13 = new LibroFisico("LF029", "Vida y mentira del Che Guevara", "Fernando Diaz Villanueva", 39000, "Historia", "img/vida_y_mentira_del_che_guevara.jpg", "Un análisis profundo y documentado sobre una de las figuras más polarizantes del siglo XX. El libro despoja a la figura de el che guevara de la propaganda romántica para examinar las realidades políticas, económicas y sociales de su régimen en Cuba, revelando las contradicciones entre sus discursos revolucionarios y las acciones que llevaron a la isla a décadas de aislamiento y represión.", "Luz y Guerra", "310", "Español", "2016-11-20", true, 15.0, 60);
        agregarProducto(libro13);
        
        LibroFisico libro14 = new LibroFisico("LF071", "La melancolía de los feos", "Mario Mendoza", 32000, "Novela", "img/la_melancolia_de_los_feos.jpg", "A través de la correspondencia entre un psiquiatra y su viejo amigo de la infancia que padece de malformaciones físicas, Mendoza teje una historia conmovedora sobre la marginación y la belleza oculta. La novela es un viaje a los abismos de la soledad humana, donde los rechazados por la sociedad encuentran formas alternativas de redención, amor y significado en un mundo obsesionado con las apariencias.", "Planeta", "256", "Español", "2016-04-01", false, 0.0, 95);
        agregarProducto(libro14);

        LibroFisico libro15 = new LibroFisico("LF093", "Homo Deus", "Yuval Noah Harari", 50000, "Historia", "img/homo_deus.jpg", "Tras analizar nuestro pasado, el autor proyecta su mirada hacia el futuro de la especie humana. Al haber superado en gran medida el hambre, la guerra y las plagas, la humanidad busca ahora la inmortalidad, la felicidad eterna y la divinidad mediante la inteligencia artificial y la biotecnología. El libro plantea preguntas inquietantes sobre la ética, el destino de nuestra especie y el surgimiento de nuevas religiones de datos.", "Debate", "496", "Español", "2015-09-01", true, 20.0, 110);
        agregarProducto(libro15);

        LibroFisico libro16 = new LibroFisico("LF018", "El amor en los tiempos del colera", "Gabriel Garcia Marquez", 42000, "Novela", "img/el_amor_en_los_tiempos_del_colera.png", "Florentino Ariza ha esperado más de cincuenta años, nueve meses y cuatro días para reiterar su promesa de amor eterno a Fermina Daza. Ambientada en una ciudad caribeña azotada por las plagas y las guerras, la narrativa explora el amor como una enfermedad tan devastadora y transformadora como el cólera, demostrando que los sentimientos verdaderos pueden desafiar el implacable paso del tiempo y la vejez.", "Oveja Negra", "348", "Español", "1985-12-05", false, 0.0, 180);
        agregarProducto(libro16);

        LibroFisico libro17 = new LibroFisico("LF056", "La ContraHistoria del Comunismo", "Fernando Diaz Villanueva", 41000, "Historia", "img/la_contrahistoria_del_comunismo.jpg", "Un exhaustivo repaso a la implementación del comunismo a lo largo del siglo XX en distintas naciones. Desde la Revolución Bolchevique hasta el régimen de los Jemeres Rojos y la China de Mao, la obra documenta con rigor los resultados devastadores de esta ideología política y económica, desarmando los mitos de igualdad para exponer un rastro global de totalitarismo y colapso sistémico.", "Deusto", "380", "Español", "2023-01-10", true, 10.0, 75);
        agregarProducto(libro17);

        LibroFisico libro18 = new LibroFisico("LF034", "Diario del fin del mundo", "Mario Mendoza", 36000, "Novela", "img/diario_del_fin_del_mundo.png", "En esta entrega, el autor mezcla elementos autobiográficos con ficción apocalíptica. Un escritor viaja intentando descifrar las señales de un inminente colapso global, encontrando sectas, predicadores del fin de los tiempos y una sociedad desbordada por el consumismo y la degradación ecológica. Es una advertencia literaria cruda sobre los abismos hacia los que se dirige la civilización contemporánea si no cambia su rumbo.", "Planeta", "280", "Español", "2018-03-15", false, 0.0, 90);
        agregarProducto(libro18);
        
        LibroFisico libro19 = new LibroFisico("LF088", "Ensayo sobre la ceguera", "Jose Saramago", 45000, "Novela", "img/ensayo_sobre_la_ceguera.jpg", "Una repentina epidemia de ceguera blanca azota a la población, provocando el colapso absoluto de la sociedad. Los afectados son puestos en cuarentena en condiciones inhumanas, donde la brutalidad y el egoísmo afloran rápidamente. La única persona que conserva la vista se convierte en guía y testigo de la degradación moral humana, en una profunda alegoría sobre la incapacidad de ver al otro y a nosotros mismos.", "Caminho", "336", "Español", "1995-10-01", true, 12.0, 130);
        agregarProducto(libro19);

        LibroFisico libro20 = new LibroFisico("LF009", "Breve historia del imperio español", "Fernando Diaz Villanueva", 34000, "Historia", "img/breve_historia_del_imperio_espanol.png", "Un recorrido conciso pero profundo por los siglos de expansión, hegemonía y declive de España como potencia mundial. Desde el descubrimiento de América hasta la pérdida de las últimas colonias, el autor examina las políticas administrativas, los conflictos bélicos y el vasto legado cultural y mestizo que el imperio dejó a ambos lados del Atlántico, ofreciendo un balance justo lejos de radicalismos históricos.", "Nowtilus", "290", "Español", "2018-05-10", false, 0.0, 100);
        agregarProducto(libro20);
        
        LibroFisico libro21 = new LibroFisico("LF062", "Akelarre", "Mario Mendoza", 37000, "Novela", "img/akelarre.jpg", "Continuando con la saga del detective Frank Molina, esta novela lo lleva a sumergirse en una serie de crímenes rituales que asolan Bogotá. Molina, luchando contra sus propios demonios y su alcoholismo, descubre una red de sectas y magia oscura que conecta a las altas esferas del poder con los bajos fondos, mostrando cómo la perversión humana puede alcanzar niveles verdaderamente demoníacos.", "Planeta", "304", "Espanol", "2019-10-22", true, 18.0, 70);
        agregarProducto(libro21);

        LibroFisico libro22 = new LibroFisico("LF022", "Frankenstein", "Mary Shelley", 25000, "Novela", "img/frankenstein.jpg", "Victor Frankenstein es un joven cientifico que, obsesionado por descubrir el secreto de la vida, logra dar animacion a una criatura compuesta por partes de cadaveres. Sin embargo, horrorizado por la apariencia de su creacion, la abandona a su suerte. La obra explora la soledad del monstruo, el rechazo de la sociedad y las consecuencias eticas de jugar a ser Dios, convirtiendose en una pieza fundamental de la literatura gotica y de ciencia ficcion que cuestiona la verdadera naturaleza de la humanidad.", "Lackington", "280", "Espanol", "1818-01-01", false, 0.0, 300);
        agregarProducto(libro22);

        LibroFisico libro23 = new LibroFisico("LF048", "El Che Guevara", "Fernando Diaz Villanueva", 36000, "Historia", "img/el_che_guevara.jpg", "Alejándose del ícono pop impreso en camisetas, este ensayo biográfico analiza meticulosamente la vida de Ernesto Guevara. El autor desentraña el mito para exponer al hombre detrás de la leyenda revolucionaria, detallando sus fracasos militares, su gestión económica en Cuba y su dogmatismo ideológico, ofreciendo un retrato implacable que cuestiona la idolatría ciega hacia una de las figuras más idealizadas del siglo veinte.", "La Esfera", "275", "Español", "2017-09-05", false, 0.0, 80);
        agregarProducto(libro23);
        
        LibroFisico libro24 = new LibroFisico("LF099", "Buda Blues", "Mario Mendoza", 33000, "Novela", "img/buda_blues.jpg", "Dos tramas se entrelazan en esta novela: un hombre que intenta encontrar la paz interior en medio del caos urbano adoptando preceptos orientales, y la efervescencia de los movimientos anarquistas juveniles en Bogotá. Mendoza logra una obra trepidante que reflexiona sobre el materialismo salvaje, la violencia estructural y la necesidad desesperada de los individuos modernos por encontrar un ancla espiritual frente a la desesperanza.", "Seix Barral", "240", "Espanol", "2009-04-15", true, 10.0, 65);
        agregarProducto(libro24);

        LibroFisico libro25 = new LibroFisico("LF015", "21 lecciones para el siglo XXI", "Yuval Noah Harari", 48000, "Ensayo", "img/21_lecciones_para_el_siglo_xxi.png", "A diferencia de sus obras anteriores que miraban al pasado y al futuro, aquí Harari se centra en el presente. A través de veintiún ensayos, aborda los desafíos más apremiantes de nuestra época: la disrupción tecnológica, la amenaza nuclear, las fake news, la polarización política y el cambio climático. Es una brújula intelectual indispensable para navegar las turbulentas aguas del mundo contemporáneo.", "Debate", "400", "Espanol", "2018-08-30", false, 0.0, 140);
        agregarProducto(libro25);

        LibroFisico libro26 = new LibroFisico("LF076", "Para habernos matado", "Fernando Diaz Villanueva", 40000, "Historia", "img/para_habernos_matado.jpg", "Una crónica vibrante sobre los grandes conflictos internos y las guerras civiles que han desangrado a España a lo largo de su historia. El autor reflexiona sobre el cainismo histórico, analizando cómo la incapacidad histórica para el consenso ha derivado recurrentemente en enfrentamientos armados fraticidas, dejando lecciones vitales sobre la importancia de la tolerancia y las instituciones democráticas fuertes.", "Esfera de los Libros", "360", "Español", "2020-11-12", true, 15.0, 90);
        agregarProducto(libro26);

        LibroFisico libro27 = new LibroFisico("LF038", "Cobro de sangre", "Mario Mendoza", 34000, "Novela", "img/cobro_de_sangre.jpg", "Una vertiginosa inmersión en los bajos fondos, donde los protagonistas deben enfrentarse a deudas impagables y a la crueldad de los usureros que gobiernan las calles con mano de hierro. La tensión narrativa empuja al lector por un laberinto de crímenes y venganzas, donde la supervivencia requiere abandonar cualquier rastro de moralidad en una ciudad que no perdona la debilidad.", "Planeta", "272", "Espanol", "2004-03-01", false, 0.0, 75);
        agregarProducto(libro27);

        LibroFisico libro28 = new LibroFisico("LF081", "Cronica de una muerte anunciada", "Gabriel Garcia Marquez", 31000, "Novela", "img/cronica_de_una_muerte_anunciada.jpg", "Todo el pueblo sabe que los hermanos Vicario van a matar a Santiago Nasar para vengar el honor de su hermana, pero nadie hace nada para impedirlo. Jugando magistralmente con la estructura no lineal, el autor reconstruye minuciosamente las horas previas al asesinato, creando un retrato implacable sobre la fatalidad, el honor mal entendido y la complicidad silenciosa de una comunidad entera.", "La Oveja Negra", "156", "Espanol", "1981-01-01", false, 0.0, 160);
        agregarProducto(libro28);
        
        LibroFisico libro29 = new LibroFisico("LF051", "Treinta siglos de historia", "Fernando Diaz Villanueva", 44000, "Historia", "img/treinta_siglos_de_historia.png", "Una monumental síntesis del devenir humano desde las primeras civilizaciones hasta la era moderna. En sus páginas, imperios caen y se alzan, revoluciones transforman continentes y grandes pensadores cambian el rumbo del conocimiento. Es un viaje ambicioso que busca destilar los patrones fundamentales del comportamiento histórico humano, ideal para los amantes de la divulgación histórica sin filtros académicos.", "Deusto", "500", "Español", "2019-02-20", true, 25.0, 115);
        agregarProducto(libro29);
        
        LibroFisico libro30 = new LibroFisico("LF092", "Los hombres invisibles", "Mario Mendoza", 36000, "Novela", "img/los_hombres_invisibles.jpg", "Un joven de clase alta se adentra progresivamente en el inframundo de Bogotá, descubriendo una red de mendigos, prostitutas y criminales que operan como una sociedad alternativa y secreta bajo las narices de los ciudadanos comunes. La novela es un descenso a los infiernos contemporáneos, que revela la brutal desigualdad y la resistencia de aquellos a quienes la sociedad prefiere no ver.", "Planeta", "300", "Español", "2007-06-15", false, 0.0, 80);
        agregarProducto(libro30);

        LibroFisico libro31 = new LibroFisico("LF024", "Fahrenheit 451", "Ray Bradbury", 29000, "Novela", "img/fahrenheit_451.jpg", "En un futuro sombrío, la tarea de los bomberos no es apagar incendios, sino provocarlos. Su objetivo son los libros, prohibidos por un estado que considera que el pensamiento independiente es la raíz del sufrimiento y la discordia. A través del despertar de conciencia del bombero Guy Montag, la obra defiende apasionadamente la literatura, el pensamiento crítico y la memoria cultural frente a la censura tecnológica.", "Ballantine Books", "158", "Ingles", "1953-10-19", true, 10.0, 145);
        agregarProducto(libro31);

        LibroFisico libro32 = new LibroFisico("LF067", "Contra el Pesimismo", "Fernando Diaz Villanueva", 42000, "Ensayo", "img/contra_el_pesimismo.jpg", "En este ensayo optimista y fundamentado, el autor se propone desmontar el catastrofismo imperante en la sociedad actual. A traves de datos historicos y economicos, Diaz Villanueva explica como la humanidad ha logrado reducir la pobreza extrema, aumentar la esperanza de vida y mejorar sus condiciones materiales como nunca antes. Es un manifiesto contra la idea de que cualquier tiempo pasado fue mejor, defendiendo el ingenio humano y la libertad como los motores que nos han sacado de la miseria y que seguiran resolviendo los desafios del futuro.", "Deusto", "256", "Espanol", "2020-02-18", false, 0.0, 100);
        agregarProducto(libro32);
        
        LibroFisico libro33 = new LibroFisico("LF011", "Apocalipsis", "Mario Mendoza", 38000, "Ensayo", "img/apocalipsis.jpg", "Alejándose de sus tramas criminales, el autor presenta una serie de ensayos reflexivos y urgentes sobre el colapso ecológico, la enajenación tecnológica y la crisis moral del hombre moderno. Mendoza argumenta que ya estamos viviendo los albores del fin del mundo tal y como lo conocemos, y hace un llamado angustioso a despertar la conciencia colectiva antes de cruzar el punto de no retorno.", "Planeta", "210", "Español", "2011-05-20", true, 12.0, 50);
        agregarProducto(libro33);

        LibroFisico libro34 = new LibroFisico("LF059", "El otoño del patriarca", "Gabriel Garcia Marquez", 34000, "Novela", "img/el_otono_del_patriarca.png", "Mediante una prosa laberíntica y lírica que fluye en largos y envolventes párrafos, esta novela retrata los últimos días de un tirano caribeño longevo y decadente. Es una profunda disección de la soledad del poder absoluto, explorando la paranoia, la megalomanía y la desconexión total con la realidad que sufren los dictadores a medida que envejecen aferrados a un trono marchito.", "Plaza & Janes", "296", "Español", "1975-01-01", false, 0.0, 120);
        agregarProducto(libro34);

        LibroDigitial libro35 = new LibroDigitial("LD078", "Rebelion en la granja", "George Orwell", 26000, "Novela", "img/rebelion_en_la_granja.jpg", "En esta magistral satira politica, los animales de una granja deciden rebelarse contra sus amos humanos para fundar un sistema basado en la igualdad y la justicia. Sin embargo, pronto los cerdos comienzan a tomar el control y a establecer una nueva tirania, demostrando como el poder puede corromper incluso los ideales mas nobles. La obra es una critica mordaz a los totalitarismos y una advertencia sobre la fragilidad de la libertad frente a la manipulacion del lenguaje y la propaganda.", "Secker & Warburg", "112", "Espanol", "1945-08-17", true, 20.0, "EPUB", 4.8);
        agregarProducto(libro35);

        LibroDigitial libro36 = new LibroDigitial("LD023", "Paranormal Colombia", "Mario Mendoza", 23000, "Cronica", "img/paranormal_colombia.jpg", "Una recopilación de crónicas de no ficción donde el autor actúa como reportero de lo oculto, investigando casos de clarividencia, fantasmas, curaciones milagrosas y contactos con el más allá en diversas regiones de Colombia. Mendoza abandona su escepticismo inicial para ofrecer una mirada respetuosa y asombrada a realidades que desafían la ciencia y la lógica convencional occidental.", "Planeta", "224", "Español", "2014-04-10", false, 0.0, "PDF", 4.1);
        agregarProducto(libro36);

        LibroDigitial libro37 = new LibroDigitial("LD089", "Un mundo feliz", "Aldous Huxley", 24000, "Novela", "img/un_mundo_feliz.png", "Una visión profética y aterradora de un futuro donde la humanidad es cultivada en laboratorios y genéticamente condicionada para ocupar estratos sociales inamovibles. El consumo obligatorio de una droga llamada soma asegura una felicidad superficial, eliminando el arte, la religión, la familia y cualquier pasión humana auténtica. Es un clásico imprescindible sobre los peligros de sacrificar la libertad en nombre del confort.", "Chatto & Windus", "256", "Ingles", "1932-01-01", false, 0.0, "EPUB", 4.8);
        agregarProducto(libro37);

        LibroDigitial libro38 = new LibroDigitial("LD041", "El extranjero", "Albert Camus", 21000, "Novela", "img/el_extranjero.png", "Meursault es un hombre que vive una existencia marcada por la indiferencia y la falta de vinculos emocionales. Tras la muerte de su madre y cometer un crimen de manera casi fortuita en una playa de Argel, se ve envuelto en un proceso judicial donde no se juzga tanto su acto como su incapacidad para sentir remordimiento o ajustarse a las convenciones sociales. Es una obra fundamental del existencialismo que explora lo absurdo de la condicion humana y la frialdad de una sociedad que exige sentimientos fingidos para otorgar su perdon.", "Gallimard", "150", "Espanol", "1942-06-15", true, 15.0, "PDF", 4.7);
        agregarProducto(libro38);

        LibroDigitial libro39 = new LibroDigitial("LD066", "Scorpio City", "Mario Mendoza", 22000, "Novela", "img/scorpio_city.jpg", "El primer acercamiento del autor a la novela negra. El detective Leonardo Sinisterra investiga los brutales asesinatos de varias prostitutas bajo la sombra de un culto religioso fanático que pretende limpiar la ciudad de sus supuestos pecados. Un recorrido oscuro por callejones lúgubres que revela la hipocresía de una sociedad conservadora que engendra sus propios monstruos exterminadores.", "Planeta", "208", "Español", "1998-05-15", false, 0.0, "EPUB", 3.9);
        agregarProducto(libro39);

        LibroDigitial libro40 = new LibroDigitial("LD014", "Nexus", "Yuval Noah Harari", 38000, "Historia", "img/nexus.png", "Una exploración profunda sobre cómo las redes de información han construido, sostenido y destruido sociedades a lo largo de los milenios. Harari rastrea la evolución de la verdad y el poder desde las tradiciones orales prehistóricas hasta la era de la inteligencia artificial y los algoritmos globales, planteando un debate urgente sobre quién controla la información y, por ende, el destino de la humanidad.", "Debate", "450", "Español", "2024-09-10", true, 10.0, "EPUB", 4.9);
        agregarProducto(libro40);
        
        LibroDigitial libro41 = new LibroDigitial("LD055", "El coronel no tiene quien le escriba", "Gabriel Garcia Marquez", 20000, "Novela", "img/el_coronel_no_tiene_quien_le_escriba.jpg", "Una obra maestra de la concisión narrativa que relata la historia de un veterano de guerra de la Guerra de los Mil Días. Atrapado en la pobreza extrema junto a su esposa enferma y aferrado a la ilusión de un gallo de pelea, el coronel acude cada viernes a la oficina de correos esperando una pensión gubernamental que nunca llega. Es un retrato conmovedor sobre la dignidad y la esperanza inquebrantable.", "Aguirre Editor", "92", "Español", "1961-01-01", false, 0.0, "PDF", 4.6);
        agregarProducto(libro41);

        LibroDigitial libro42 = new LibroDigitial("LD097", "Crónicas Marcianas", "Ray Bradbury", 25000, "Novela", "img/cronicas_marcianas.jpg", "Esta colección de relatos entrelazados narra la colonización de Marte por parte de una humanidad que huye de un mundo al borde de la destrucción. A través de una prosa poética y melancólica, Bradbury explora el choque entre los sueños de los colonos y la decadente civilización marciana, abordando temas como la soledad, el racismo, la censura y la naturaleza autodestructiva del ser humano. Es una obra maestra que utiliza la ciencia ficción para reflejar las ansiedades y esperanzas de nuestra propia sociedad frente a lo desconocido.", "Doubleday", "336", "Español", "1950-05-04", false, 0.0, "EPUB", 4.9);
        agregarProducto(libro42);

        LibroDigitial libro43 = new LibroDigitial("LD031", "Relato de un asesino", "Mario Mendoza", 24000, "Novela", "img/relato_de_un_asesino.jpg", "Narrada en primera persona, la novela nos sumerge en la psique perturbada de un criminal atormentado por su pasado. Desde su celda de prisión, el protagonista desmenuza los eventos traumáticos, las decepciones vitales y las fuerzas oscuras de la ciudad que lo empujaron irreversiblemente a cometer actos atroces, obligando al lector a cuestionar la delgada línea entre la víctima y el verdugo.", "Planeta", "240", "Español", "2001-02-20", true, 20.0, "PDF", 4.4);
        agregarProducto(libro43);

        LibroDigitial libro44 = new LibroDigitial("LD082", "La ciudad y los perros", "Mario Vargas Llosa", 28000, "Novela", "img/la_ciudad_y_los_perros.jpg", "Ambientada en el riguroso Colegio Militar Leoncio Prado en Lima, la historia sigue a un grupo de cadetes sometidos a una disciplina brutal que fomenta la crueldad, el engaño y la supervivencia del más fuerte. A través del robo de un examen y un asesinato encubierto, la novela expone la podredumbre moral del autoritarismo y la hipocresía de los valores marciales.", "Seix Barral", "448", "Español", "1963-10-01", false, 0.0, "EPUB", 4.7);
        agregarProducto(libro44);

        LibroDigitial libro45 = new LibroDigitial("LD008", "Contra la Revolucion Francesa", "Fernando Diaz Villanueva", 27000, "Historia", "img/contra_la_revolucion_francesa.jpg", "En este ensayo, el autor ofrece una vision critica y alejada de los mitos romanticos sobre uno de los eventos mas influyentes de la modernidad. Diaz Villanueva analiza como la revolucion paso de buscar la libertad a sumergirse en el Terror, examinando las figuras de Robespierre, Danton y Marat. El libro cuestiona si los metodos violentos y el totalitarismo incipiente de la epoca realmente trajeron el progreso prometido, o si sentaron las bases para los grandes desastres ideologicos del siglo veinte.", "La Esfera", "350", "Espanol", "2020-03-10", true, 10.0, "PDF", 4.5);
        agregarProducto(libro45);
        
        LibroDigitial libro46 = new LibroDigitial("LD047", "La locura de nuestro tiempo", "Mario Mendoza", 22000, "Ensayo", "img/la_locura_de_nuestro_tiempo.jpg", "Una potente disección psicosocial de las patologías de la era moderna: el estrés crónico, la depresión epidémica, la soledad interconectada y la cultura del simulacro en redes sociales. El autor argumenta que las exigencias del capitalismo tardío nos están enfermando mental y espiritualmente, y propone una rebelión íntima a través del arte, la lectura y la reconexión con ritmos de vida más humanos.", "Planeta", "190", "Español", "2010-08-15", false, 0.0, "EPUB", 4.5);
        agregarProducto(libro46);

        LibroDigitial libro47 = new LibroDigitial("LD063", "La hojarasca", "Gabriel Garcia Marquez", 19000, "Novela", "img/la_hojarasca.jpg", "La primera novela del Nobel colombiano que introduce por primera vez el mítico pueblo de Macondo. A través de los monólogos interiores entrelazados de tres personajes de distintas generaciones de una misma familia, la obra narra el polémico entierro de un doctor repudiado por la comunidad tras la devastación dejada por la fiebre bananera, sembrando las semillas del realismo mágico.", "Ediciones Sipa", "144", "Español", "1955-05-01", false, 0.0, "PDF", 4.2);
        agregarProducto(libro47);

        LibroDigitial libro48 = new LibroDigitial("LD026", "Capitalismo y libertad", "Milton Friedman", 30000, "Ensayo", "img/capitalismo_y_libertad.png", "Un texto fundacional del pensamiento económico liberal del siglo XX. Friedman argumenta de manera contundente que la libertad económica es un requisito absolutamente indispensable para alcanzar y mantener la libertad política. A través de políticas como la educación basada en vales y la desregulación, el autor defiende que los mercados libres resuelven los problemas sociales de manera mucho más eficiente que el intervencionismo estatal.", "University of Chicago Press", "208", "Ingles", "1962-09-15", true, 15.0, "EPUB", 4.6);
        agregarProducto(libro48);

        LibroDigitial libro49 = new LibroDigitial("LD094", "El retrato de Dorian Gray", "Oscar Wilde", 23000, "Novela", "img/el_retrato_de_dorian_gray.jpg", "Dorian Gray es un joven de extraordinaria belleza que queda impactado por un retrato suyo pintado por el artista Basil Hallward. Bajo la influencia de Lord Henry Wotton, Dorian comienza a desear que su imagen en el lienzo envejezca y sufra las consecuencias de sus actos mientras el permanece joven para siempre. A medida que se sumerge en una vida de vicio, hedonismo y crueldad, el retrato se transforma en un espejo grotesco de su alma corrupta, recordandole que ningun pecado queda impune y que la belleza externa puede ocultar la mas profunda oscuridad moral.", "Lippincotts", "250", "Espanol", "1890-06-20", false, 0.0, "PDF", 4.8);
        agregarProducto(libro49);

        LibroDigitial libro50 = new LibroDigitial("LD017", "El mensajero de Agartha", "Mario Mendoza", 21000, "Novela", "img/el_mensajero_de_agartha.jpg", "Incursionando en la literatura de aventuras y el esoterismo, Mendoza nos presenta la historia de Felipe, un joven de diez años que recibe mensajes telepáticos invitándolo a emprender un viaje físico y espiritual hacia la mítica ciudad intraterrena de Agartha. Es un relato de iniciación, misterio y fantasía que busca conectar a los lectores más jóvenes con antiguas sabidurías ancestrales.", "Planeta", "230", "Español", "2015-09-01", true, 25.0, "EPUB", 4.3);
        agregarProducto(libro50);
        
        LibroDigitial libro51 = new LibroDigitial("LD052", "La peste", "Albert Camus", 25000, "Novela", "img/la_peste.png", "Cuando una letal plaga transmitida por ratas asedia la ciudad argelina de Orán, sus habitantes son sometidos a un estricto aislamiento. A través del incansable trabajo del doctor Rieux, la novela explora la solidaridad humana ante el sufrimiento absurdo y la muerte inevitable. Es una profunda reflexión existencialista y una poderosa alegoría de la resistencia frente al fascismo y la ocupación nazi.", "Gallimard", "278", "Frances", "1947-06-10", false, 0.0, "EPUB", 4.8);
        agregarProducto(libro51);

        LibroDigitial libro52 = new LibroDigitial("LD088", "Por que fracasan los paises", "Daron Acemoglu", 32000, "Ensayo", "img/por_que_fracasan_los_paises.jpg", "Una investigación monumental sobre los orígenes del poder, la prosperidad y la pobreza mundial. Los autores concluyen, tras analizar datos históricos exhaustivos, que la riqueza de una nación no está determinada por su geografía, cultura o clima, sino exclusivamente por la naturaleza de sus instituciones políticas y económicas: las inclusivas generan prosperidad y progreso, mientras que las extractivas conducen inevitablemente al estancamiento y la miseria.", "Crown Publishers", "528", "Ingles", "2012-03-20", true, 12.0, "PDF", 4.7);
        agregarProducto(libro52);

        LibroDigitial libro53 = new LibroDigitial("LD039", "El Gran Gatsby", "F. Scott Fitzgerald", 29000, "Novela", "img/el_gran_gatsby.jpg", "Ambientada en los años veinte en Long Island, la novela sigue al joven Nick Carraway y su fascinacion por su misterioso vecino, Jay Gatsby, un millonario conocido por sus fiestas extravagantes. Gatsby vive obsesionado con recuperar el amor de Daisy Buchanan, una mujer de su pasado ahora casada con un hombre adinerado. La obra es una critica mordaz al sueño americano, explorando temas como la decadencia moral, la obsesion por la riqueza, la division de clases sociales y la imposibilidad de repetir el pasado bajo una luz tragica y brillante.", "Charles Scribners Sons", "180", "Espanol", "1925-04-10", false, 0.0, "EPUB", 4.7);
        agregarProducto(libro53);

        LibroDigitial libro54 = new LibroDigitial("LD071", "Los vagabundos de Dios", "Mario Mendoza", 23000, "Novela", "img/los_vagabundos_de_dios.png", "Un exitoso escritor y académico en crisis sufre un ataque al corazón que lo deja clínicamente muerto por unos minutos. Tras regresar a la vida, decide abandonarlo todo—riqueza, fama y comodidades—para iniciar un viaje espiritual como mendigo por distintas ciudades del mundo, buscando respuestas a las preguntas fundamentales del alma entre los desposeídos y los invisibles del sistema capitalista.", "Planeta", "280", "Espanol", "2021-08-20", true, 18.0, "PDF", 4.4);
        agregarProducto(libro54);

        LibroDigitial libro55 = new LibroDigitial("LD019", "Niebla", "Miguel de Unamuno", 18000, "Novela", "img/niebla.jpg", "Pionera de la metaficción, esta nivola presenta a Augusto Pérez, un joven intelectual que se enamora trágicamente. En un giro brillante y vanguardista, Augusto descubre que es tan solo un personaje de ficción y decide confrontar a su propio autor, Unamuno, para exigir su derecho a vivir. Una exploración filosófica magistral sobre el existencialismo, el libre albedrío, la mortalidad y la creación literaria.", "Renacimiento", "200", "Espanol", "1914-01-01", false, 0.0, "EPUB", 4.5);
        agregarProducto(libro55);

        LibroDigitial libro56 = new LibroDigitial("LD068", "La riqueza de las naciones", "Adam Smith", 28000, "Ensayo", "img/la_riqueza_de_las_naciones.jpg", "El tratado supremo que dio origen a la economía clásica moderna. Smith desglosa magistralmente cómo la división del trabajo, la acumulación de capital y el libre comercio de mercados impulsados por el interés propio generan prosperidad general a través del mecanismo regulador de la mano invisible. Un pilar fundamental para comprender los engranajes económicos que sacaron al mundo del estancamiento feudal.", "W. Strahan", "600", "Ingles", "1776-03-09", true, 10.0, "PDF", 4.7);
        agregarProducto(libro56);

        LibroDigitial libro57 = new LibroDigitial("LD022", "Metamorfosis", "Franz Kafka", 15000, "Novela", "img/metamorfosis.png", "Gregor Samsa se despierta una mañana tras un sueño intranquilo convertido en un monstruoso insecto. A partir de ese momento, la novela narra la progresiva degradación de su vida familiar y su total aislamiento del mundo exterior. A través de esta transformación física, Kafka explora temas como la alienación social, la culpa, el peso de las responsabilidades familiares y la deshumanización del individuo en una sociedad burocrática y fría que rechaza aquello que no puede comprender o utilizar para su beneficio.", "Kurt Wolff Verlag", "100", "Espanol", "1915-10-01", true, 5.0, "PDF", 4.7);
        agregarProducto(libro57);

        LibroDigitial libro58 = new LibroDigitial("LD095", "Bitacora del naufragio", "Mario Mendoza", 24000, "Ensayo", "img/bitacora_del_naufragio.jpg", "Escrito durante el aislamiento impuesto por la pandemia global, este volumen recoge las reflexiones íntimas, los miedos y las esperanzas del autor frente a una crisis sanitaria sin precedentes. Es un testimonio crudo de la fragilidad humana y una crítica a un sistema globalizado que colapsó ante un enemigo microscópico, instando a la humanidad a reevaluar su relación con la naturaleza y con los demás.", "Planeta", "180", "Espanol", "2020-12-01", true, 15.0, "PDF", 4.3);
        agregarProducto(libro58);

        LibroDigitial libro59 = new LibroDigitial("LD021", "Memoria de mis putas tristes", "Gabriel Garcia Marquez", 22000, "Novela", "img/memoria_de_mis_putas_tristes.png", "Al cumplir noventa años, un viejo periodista solterón decide regalarse una noche de amor con una adolescente virgen. Sin embargo, al ver a la joven dormida, experimenta por primera vez un sentimiento puro y abrumador que lo transforma profundamente. Una novela corta y melancólica que reflexiona sobre el ocaso de la vida, la fugacidad del deseo físico y el poder redentor del amor tardío.", "Mondadori", "112", "Espanol", "2004-10-01", false, 0.0, "EPUB", 4.0);
        agregarProducto(libro59);
        
        LibroDigitial libro60 = new LibroDigitial("LD037", "Archipiélago Gulag", "Aleksandr Solzhenitsyn", 35000, "Historia", "img/archipielago_gulag.jpg", "Esta obra monumental es un informe exhaustivo y devastador sobre el sistema de prisiones y campos de trabajos forzados en la Union Sovietica. Basado en la propia experiencia del autor y en los testimonios de cientos de supervivientes, el libro describe con detalle minucioso los arrestos arbitrarios, las torturas, los interrogatorios y las condiciones infrahumanas de vida en los campos. Mas que una cronica historica, es una diseccion profunda del totalitarismo y un testimonio imperecedero sobre la resistencia del espiritu humano frente a la opresion sistematica que intento borrar la dignidad de millones de personas.", "Harper & Row", "660", "Ruso", "1973-12-28", true, 5.0, "PDF", 4.9);
        agregarProducto(libro60);
        
        LibroFisico libro61 = new LibroFisico("LF080", "Metro 2033", "Dmitry Glukhovsky", 45000, "Novela", "img/metro_2033.png", "Tras una catastrofe nuclear que ha devastado el mundo, los supervivientes se refugian en las profundidades del metro de Moscu. Artyom, un joven que nunca ha salido de su estacion, debe emprender un viaje peligroso hacia el corazon del sistema para advertir a la humanidad sobre una nueva y terrible amenaza. Es una historia de supervivencia extrema, donde las facciones politicas y los horrores mutantes luchan por el control de los tuneles en una atmosfera claustrofobica y desesperanzadora.", "Minotauro", "544", "Ruso", "2005-10-24", false, 0.0, 80);
        agregarProducto(libro61);

        LibroFisico libro62 = new LibroFisico("LF081", "Metro 2034", "Dmitry Glukhovsky", 45000, "Novela", "img/metro_2034.jpg", "La historia se traslada a la estacion Sevastopolskaya, que resiste los ataques continuos de monstruos gracias a su suministro de electricidad. Cuando una caravana desaparece en la oscuridad de los tuneles, el destino de la estacion queda en manos de un pequeño grupo de exploradores. Esta secuela profundiza en la filosofia del mundo subterraneo, explorando la redencion y el sacrificio a traves de personajes atormentados que buscan una chispa de luz en un mundo condenado.", "Minotauro", "480", "Ruso", "2009-05-29", false, 0.0, 65);
        agregarProducto(libro62);

        LibroFisico libro63 = new LibroFisico("LF082", "Metro 2035", "Dmitry Glukhovsky", 48000, "Novela", "img/metro_2035.png", "Artyom regresa como protagonista en el cierre de la trilogia. Obsesionado con la idea de que hay supervivientes fuera del metro de Moscu, es tomado por loco por sus compañeros. Su busqueda de la verdad lo llevara a descubrir los secretos mas oscuros de los lideres del metro y la verdadera naturaleza del aislamiento que sufren. Es la entrega mas politica y cruda de la saga, donde la lucha por la verdad resulta ser mas peligrosa que cualquier mutante de la superficie.", "Minotauro", "512", "Ruso", "2015-06-12", true, 10.0, 50);
        agregarProducto(libro63);
        
        LibroFisico libro64 = new LibroFisico("LF083", "Absolute Carnage", "Donny Cates", 55000, "Comic", "img/absolute_carnage.jpg", "Cletus Kasady ha regresado y esta mas peligroso que nunca. En esta historia, el simbionte Carnage busca cazar a cada individuo que alguna vez haya vestido un simbionte para recolectar sus codices y despertar al dios oscuro Knull. Spider-Man y Venom deberan forjar una alianza incomoda para detener una masacre de proporciones epicas que amenaza con sumergir al universo Marvel en una oscuridad eterna.", "Marvel Comics", "200", "Español", "2019-08-07", true, 15.0, 40);
        agregarProducto(libro64);

        LibroFisico libro65 = new LibroFisico("LF084", "Spider-Man: Back in Black", "J. Michael Straczynski", 48000, "Comic", "img/spiderman_back_in_black.png", "Tras los eventos de Civil War, la vida de Peter Parker se desmorona cuando su identidad es revelada y la tia May es herida de gravedad. Consumido por la furia, Peter vuelve a vestir el traje negro, pero esta vez no por el simbionte, sino como señal de su luto y ferocidad. Es una de las historias mas oscuras del trepamuros, donde cruza lineas morales que nunca creyo tocar para proteger a lo que queda de su familia.", "Marvel Comics", "168", "Español", "2007-03-01", false, 0.0, 55);
        agregarProducto(libro65);

        LibroFisico libro66 = new LibroFisico("LF085", "Old Man Logan", "Mark Millar", 62000, "Comic", "img/old_man_logan.jpg", "En un futuro distopico donde los villanos han ganado y dividido los Estados Unidos, un envejecido y pacifico Logan se niega a sacar sus garras. Sin embargo, ante la necesidad de salvar a su familia de las deudas con la banda de Hulk, acepta un ultimo trabajo para cruzar el pais junto a un ciego Hawkeye. Es un western post-apocaliptico brutal que redefine al personaje de Wolverine y muestra un mundo Marvel devastado y desesperanzador.", "Marvel Comics", "224", "Español", "2008-06-01", false, 0.0, 30);
        agregarProducto(libro66);
        
        LibroDigitial libro67 = new LibroDigitial("LD102", "The Punisher: King of Killers", "Jason Aaron", 45000, "Comic", "img/the_punisher_king_of_killers.png", "Frank Castle se convierte en el Señor de los Asesinos al aceptar el liderazgo de La Mano, la secta ninja mas peligrosa del mundo. A cambio de resucitar a su esposa Maria, el Castigador accede a servir a 'La Bestia', utilizando recursos globales y un ejercito de ninjas para llevar su guerra contra el crimen a un nivel nunca antes visto. Es una historia epica que mezcla el genero negro con elementos sobrenaturales, explorando hasta donde es capaz de llegar Frank por recuperar su pasado.", "Marvel Comics", "312", "Español", "2022-03-09", false, 0.0, "EPUB", 4.8);
        agregarProducto(libro67);
        
        LibroDigitial libro68 = new LibroDigitial("LD103", "Deadpool vs. Carnage", "Cullen Bunn", 32000, "Comic", "img/deadpool_vs_carnage.jpg", "Cuando Cletus Kasady escapa de prision y comienza una nueva oleada de asesinatos al azar, Deadpool decide que el es el unico lo suficientemente loco como para predecir los movimientos de Carnage. Lo que sigue es un enfrentamiento ultraviolento y surrealista por todo el pais, donde la regeneracion extrema de ambos contendientes convierte cada batalla en una carniceria sin fin. Una historia cargada de humor negro y accion desenfrenada que pone a prueba la cordura del Mercenario Bocazas.", "Marvel Comics", "112", "Español", "2014-04-02", true, 10.0, "EPUB", 4.7);
        agregarProducto(libro68);
        
        LibroDigitial libro69 = new LibroDigitial("LD104", "Batman Metal", "Scott Snyder", 38000, "Comic", "img/batman_metal.jpg", "Tras los eventos de Metal, una de las versiones mas retorcidas del multiverso oscuro llega a la Tierra principal. Este Batman, que ha sido infectado por la toxina del Joker tras matarlo, posee la inteligencia estrategica de Bruce Wayne y la moralidad sadica del Principe Payaso del Crimen. Acompañado de sus Robins rabiosos, el Caballero que Rie pone en marcha un plan para corromper a los heroes mas brillantes y sumergir al mundo en una pesadilla eterna de la que ni siquiera el verdadero Batman esta seguro de poder escapar.", "DC Comics", "232", "Español", "2018-11-15", false, 0.0, "PDF", 4.9);
        agregarProducto(libro69);
        
        LibroDigitial libro70 = new LibroDigitial("LD105", "Marvel Zombies", "Robert Kirkman", 35000, "Comic", "img/marvel_zombies.jpg", "En un universo alterno, un destello en el cielo trae consigo una plaga interdimensional que transforma a los Vengadores y X-Men en muertos vivientes. A diferencia de los zombies tradicionales, estos mantienen sus poderes y su intelecto, lo que los convierte en una amenaza imparable que devora a la humanidad en cuestion de horas. Cuando la comida comienza a escasear en la Tierra, la llegada de Silver Surfer y Galactus ofrece a estos heroes caidos una oportunidad de llevar su hambre voraz mas alla de las estrellas.", "Marvel Comics", "136", "Español", "2005-12-07", true, 15.0, "EPUB", 4.8);
        agregarProducto(libro70);
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