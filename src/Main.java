import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Etablissement boutique = new Etablissement("Boutique Culture");

        // ajout des articles (le tableau reste trié par ISBN / ISSN)
        boutique.ajouter("La maison vide", 25, 10, "9782707356741", 752);
        boutique.ajouter("Nouvelle grammaire du collège", 38, 31, "9782210446694", 512,
                "Français", "Collège");
        boutique.ajouter("Geo", 6.5, 20, "00208245", "mensuel", LocalDate.of(2025, 8, 1));

        System.out.println("=== Etat initial ===");
        boutique.afficher();

        // recherche et calcul du prix
        System.out.println();
        System.out.println("=== Recherche et prix ===");
        Article geo = boutique.rechercher("00208245");
        System.out.println(geo);
        System.out.println("Prix actuel : " + geo.calculerPrix());
        Article livre = boutique.rechercher("9782707356741");
        System.out.println("Prix actuel de " + livre.getDescription() + " : " + livre.calculerPrix());
        System.out.println("Recherche d'un numéro inconnu : " + boutique.rechercher("0000"));

        // gestion du stock
        System.out.println();
        System.out.println("=== Ajout / retrait d'exemplaires ===");
        System.out.println("Ajouter 5 Geo : " + boutique.ajouter("00208245", 5));
        System.out.println("Retirer 3 La maison vide : " + boutique.retirer("9782707356741", 3));
        System.out.println("Retirer 100 La maison vide : " + boutique.retirer("9782707356741", 100));
        System.out.println(boutique.rechercher("00208245"));
        System.out.println(boutique.rechercher("9782707356741"));

        // bons de dépôt
        System.out.println();
        System.out.println("=== Bons de dépôt ===");
        BonDepot bon1 = boutique.ajouter("061236547890");
        boutique.ajouterLigne(bon1, "9782210446694", 10);
        boutique.ajouterLigne(bon1, "9782707356741", 20);

        BonDepot bon2 = boutique.ajouter("0698765432");
        boutique.ajouterLigne(bon2, "00208245", 4);

        System.out.println();
        boutique.afficher();
    }
}
