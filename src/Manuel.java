public class Manuel extends Livre{
    private String matiere;
    private String niv_scolaire;

    public Manuel(String description, double prix, int nb_stock, String isbn, int nb_page,
                  String matiere, String niv_scolaire) {
        super(description, prix, nb_stock, isbn, nb_page);
        this.matiere = matiere;
        this.niv_scolaire = niv_scolaire;
    }

    public Manuel() {
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getNiv_scolaire() {
        return niv_scolaire;
    }

    public void setNiv_scolaire(String niv_scolaire) {
        this.niv_scolaire = niv_scolaire;
    }

    @Override
    public String toString() {
        return "Manuel{" +
                "isbn='" + getIsbn() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", prix=" + getPrix() +
                ", nb_stock=" + getNb_stock() +
                ", nb_page=" + getNb_page() +
                ", matiere='" + matiere + '\'' +
                ", niv_scolaire='" + niv_scolaire + '\'' +
                '}';
    }
}
