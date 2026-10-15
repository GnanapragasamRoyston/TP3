import java.time.LocalDate;

public class Etablissement {
    public static final int MAX_ARTICLES = 10;
    public static final int MAX_BONS_DEPOT = 10;

    private String nomBoutique;
    private final Article[] articles;
    private final BonDepot[] bonsDepot;
    private int nbArticles;
    private int nbBonsDepot;

    public Etablissement(String nomBoutique) {
        this.nomBoutique = nomBoutique;
        this.articles = new Article[MAX_ARTICLES];
        this.bonsDepot = new BonDepot[MAX_BONS_DEPOT];
    }

    public boolean ajouterArticle(Article article) {
        if (article == null || article.getNumero() == null || nbArticles == MAX_ARTICLES) {
            return false;
        }

        for (int i = 0; i < nbArticles; i++) {
            if (articles[i].getNumero().equals(article.getNumero())) {
                return false;
            }
        }

        int position = nbArticles;
        while (position > 0 && !article.placerApres(articles[position - 1])) {
            position--;
        }

        for (int i = nbArticles; i > position; i--) {
            articles[i] = articles[i - 1];
        }

        articles[position] = article;
        nbArticles++;
        return true;
    }

    public boolean ajouter(String description, double prixInitial, int nbExemplaires,
                           String isbn, int nbPages) {
        Livre livre = new Livre(description, prixInitial, nbExemplaires, isbn, nbPages);
        return ajouterArticle(livre);
    }

    public boolean ajouter(String description, double prixInitial, int nbExemplaires,
                           String isbn, int nbPages, String matiere, String niveauScolaire) {
        Manuel manuel = new Manuel(description, prixInitial, nbExemplaires,
                isbn, nbPages, matiere, niveauScolaire);
        return ajouterArticle(manuel);
    }

    public boolean ajouter(String description, double prixInitial, int nbExemplaires,
                           String issn, String periodicite, LocalDate datePublication) {
        Magazine magazine = new Magazine(description, prixInitial, nbExemplaires,
                issn, periodicite, datePublication);
        return ajouterArticle(magazine);
    }

    public Article rechercher(String numero) {
        for (int i = 0; i < nbArticles; i++) {
            if (articles[i].getNumero().equals(numero)) {
                return articles[i];
            }
        }
        return null;
    }

    public boolean ajouter(String numero, int quantite) {
        Article article = rechercher(numero);
        if (article == null) {
            return false;
        }
        return article.ajouter(quantite);
    }

    public boolean retirer(String numero, int quantite) {
        Article article = rechercher(numero);
        if (article == null) {
            return false;
        }
        return article.retirer(quantite);
    }

    public boolean ajouterBonDepot(BonDepot bonDepot) {
        if (bonDepot == null || nbBonsDepot == MAX_BONS_DEPOT) {
            return false;
        }

        int position = nbBonsDepot;
        while (position > 0
                && bonDepot.getDateEmission().isBefore(bonsDepot[position - 1].getDateEmission())) {
            position--;
        }

        for (int i = nbBonsDepot; i > position; i--) {
            bonsDepot[i] = bonsDepot[i - 1];
        }

        bonsDepot[position] = bonDepot;
        nbBonsDepot++;
        return true;
    }

    public BonDepot ajouter(String numeroTelephone) {
        if (nbBonsDepot == MAX_BONS_DEPOT) {
            return null;
        }

        BonDepot bonDepot = new BonDepot(numeroTelephone);
        ajouterBonDepot(bonDepot);
        return bonDepot;
    }

    // ajoute une ligne au bon de dépôt et met à jour le stock de l'article déjà existant
    public boolean ajouterLigne(BonDepot bonDepot, String numero, int nbExemplaires) {
        if (bonDepot == null || rechercher(numero) == null) {
            return false;
        }
        if (!bonDepot.ajouterLigne(numero, nbExemplaires)) {
            return false;
        }
        return ajouter(numero, nbExemplaires);
    }

    public void afficher() {
        System.out.println("Établissement : " + nomBoutique);

        System.out.println("Articles disponibles :");
        for (int i = 0; i < nbArticles; i++) {
            System.out.println(articles[i]);
        }

        System.out.println("Bons de dépôt émis :");
        for (int i = 0; i < nbBonsDepot; i++) {
            System.out.println(bonsDepot[i]);
        }
    }
}
