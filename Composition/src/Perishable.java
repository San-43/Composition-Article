/***
 * Sandro Martínez Pérez
 * Grupo: 3°1
 * Cuenta: 475218
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Perishable extends Article{
    LocalDate elaborationDate;
    LocalDate expiryDate;

    public Perishable(int id, String description, String brand, String content, String category, float price, String state, LocalDate elaborationDate, LocalDate expiryDate) {
        super(id, description, brand, content, category, price, state);
        this.elaborationDate = elaborationDate;
        this.expiryDate = expiryDate;
    }

    public Perishable() {
        super();
        this.elaborationDate = null;
        this.expiryDate = null;
    }

    public LocalDate getElaborationDate() {
        return elaborationDate;
    }

    public void setElaborationDate(LocalDate elaborationDate) {
        this.elaborationDate = elaborationDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String getData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.getData() + "\nFecha de Elaboración: " + getElaborationDate().format(formatter) +
                "\nFecha de Caducidad: " + getExpiryDate().format(formatter);
    }
}
