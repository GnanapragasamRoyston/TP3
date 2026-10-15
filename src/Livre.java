import java.time.LocalDate;

public class Livre extends Article {
    private String isbn;
    private int nb_page;

    public Livre(String description, double prix, int nb_stock, String isbn, int nb_page) {
        super(description, prix, nb_stock);
        this.isbn = isbn;
        this.nb_page = nb_page;
    }

    public Livre() {
    }

    @Override
    public String getNumero() {
        return isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNb_page() {
        return nb_page;
    }

    public void setNb_page(int nb_page) {
        this.nb_page = nb_page;
    }

    @Override
    public double calculerPrix() {
        if (LocalDate.now().getMonthValue() == 4) {
            return getPrix() * 0.5;
        }
        return getPrix();
    }

    @Override
    public String toString() {
        return "Livre{" +
                "isbn='" + isbn + '\'' +
                ", description='" + getDescription() + '\'' +
                ", prix=" + getPrix() +
                ", nb_stock=" + getNb_stock() +
                ", nb_page=" + nb_page +
                '}';
    }
}
