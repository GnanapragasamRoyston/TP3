public class LigneDepot {
    private String numeroISBNouISSN;
    private int nbExemplaires;

    public LigneDepot(String numeroISBNouISSN, int nbExemplaires) {
        this.numeroISBNouISSN = numeroISBNouISSN;
        this.nbExemplaires = nbExemplaires;
    }

    public LigneDepot() {
    }

    public String getNumeroISBNouISSN() {
        return numeroISBNouISSN;
    }

    public void setNumeroISBNouISSN(String numeroISBNouISSN) {
        this.numeroISBNouISSN = numeroISBNouISSN;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public void setNbExemplaires(int nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }

    @Override
    public String toString() {
        return "LigneDepot{" +
                "numeroISBNouISSN='" + numeroISBNouISSN + '\'' +
                ", nbExemplaires=" + nbExemplaires +
                '}';
    }
}
