import java.time.LocalDate;

public class BonDepot {
    public static final int MAX_LIGNES = 10;

    private static int prochainNumero = 1;

    private final int numeroBon;
    private String numeroTelephone;
    private LocalDate dateEmission;
    private int nbLignes;
    private final LigneDepot[] lignesDepot;

    public BonDepot(String numeroTelephone) {
        this(numeroTelephone, LocalDate.now());
    }

    public BonDepot(String numeroTelephone, LocalDate dateEmission) {
        this.numeroBon = prochainNumero++;
        this.numeroTelephone = numeroTelephone;
        this.dateEmission = dateEmission == null ? LocalDate.now() : dateEmission;
        this.lignesDepot = new LigneDepot[MAX_LIGNES];
    }

    public BonDepot() {
        this(null);
    }

    public int getNumeroBon() {
        return numeroBon;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public int getNbArticles() {
        int total = 0;
        for (int i = 0; i < nbLignes; i++) {
            total += lignesDepot[i].getNbExemplaires();
        }
        return total;
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public LigneDepot[] getLignesDepot() {
        LigneDepot[] copie = new LigneDepot[MAX_LIGNES];
        for (int i = 0; i < nbLignes; i++) {
            copie[i] = new LigneDepot(
                    lignesDepot[i].getNumeroISBNouISSN(),
                    lignesDepot[i].getNbExemplaires()
            );
        }
        return copie;
    }

    public boolean ajouterLigne(String numeroISBNouISSN, int nbExemplaires) {
        if (numeroISBNouISSN == null || nbExemplaires <= 0 || nbLignes == MAX_LIGNES) {
            return false;
        }

        lignesDepot[nbLignes] = new LigneDepot(numeroISBNouISSN, nbExemplaires);
        nbLignes++;
        return true;
    }

    public boolean ajouterLigneDepot(LigneDepot ligneDepot) {
        if (ligneDepot == null) {
            return false;
        }
        return ajouterLigne(ligneDepot.getNumeroISBNouISSN(), ligneDepot.getNbExemplaires());
    }

    @Override
    public String toString() {
        return "BonDepot{" +
                "numeroBon=" + numeroBon +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", dateEmission=" + dateEmission +
                ", nbArticles=" + getNbArticles() +
                ", nbLignes=" + nbLignes +
                '}';
    }
}
