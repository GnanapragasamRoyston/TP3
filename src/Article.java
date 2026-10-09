public abstract class Article {
    private String description;
    private double prix;
    private int nb_stock;

    public Article(String description, double prix, int nb_stock) {
        this.description = description;
        this.prix = prix;
        this.nb_stock = nb_stock;
    }

    public Article() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNb_stock() {
        return nb_stock;
    }

    public void setNb_stock(int nb_stock) {
        this.nb_stock = nb_stock;
    }

    public abstract String getNumero();

    public boolean placerApres(Article autre) {
        return autre != null
                && getNumero() != null
                && autre.getNumero() != null
                && getNumero().compareTo(autre.getNumero()) > 0;
    }

    public boolean ajouter(int quantite) {
        if (quantite <= 0 || nb_stock > Integer.MAX_VALUE - quantite) {
            return false;
        }
        nb_stock += quantite;
        return true;
    }

    public boolean retirer(int quantite) {
        if (quantite <= 0 || quantite > nb_stock) {
            return false;
        }
        nb_stock -= quantite;
        return true;
    }

    public double calculerPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Article{" +
                "description='" + getDescription() + '\'' +
                ", prix=" + getPrix() +
                ", nb_stock=" + getNb_stock() +
                '}';
    }
}
