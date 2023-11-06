/***
 * Sandro Martínez Pérez
 * Grupo: 3°1
 * Cuenta: 475218
 */
public class Article {
    private int id;
    private String description;
    private String brand;
    private String content;
    private String category;
    private float price;
    private String state;

    public Article(int id, String description, String brand, String content, String category, float price, String state) {
        this.id = id;
        this.description = description;
        this.brand = brand;
        this.content = content;
        this.category = category;
        this.price = price;
        this.state = state;
    }

    public Article() {
        this.id = 0;
        this.description = null;
        this.brand = null;
        this.content = null;
        this.category = null;
        this.price = 0.0f;
        this.state = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getData() {
        return "Id: " + getId() + "\nDescripción: " + getDescription() +
                "\nMarca: " + getBrand() + "\nContenido: " + getContent() +
                "\nCategoría: " + getCategory() + "\nPrecio: $" + getPrice() +
                "\nEstado: " + getState();
    }
}
