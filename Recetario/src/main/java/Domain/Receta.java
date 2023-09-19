package Domain;

public class Receta {
    private int id;
    private String nombre;
    private String ingredientes;
    private String descripcion;
    private String ingredientePrincipal;
    

    // Constructores, getters y setters
    
 
    public Receta(int id, String nombre, String ingredientes, String descripcion, String ingredientePrincipal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.descripcion = descripcion;
		this.ingredientePrincipal= ingredientePrincipal;
	}
    
    public Receta( String nombre, String ingredientes, String descripcion, String ingredientePrincipal) {
		super();
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.descripcion = descripcion;
		this.ingredientePrincipal= ingredientePrincipal;
	}
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	public String getIngredientePrincipal() {
		return ingredientePrincipal;
	}

	public void setIngredientePrincipal(String ingredientePrincipal) {
		this.ingredientePrincipal = ingredientePrincipal;
	}

	@Override
    public String toString() {
        return "Receta [id=" + id + ", nombre=" + nombre + ", ingredientes=" + ingredientes + ", descripcion=" + descripcion + "]";
}
}
