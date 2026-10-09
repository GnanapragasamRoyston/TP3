import java.time.LocalDate;

public class Magazine extends Article{
    private String ISSN;
    private String periodicite;
    private LocalDate datePublication;

    public Magazine(String description, double prix, int nb_stock, String ISSN, String periodicite,
                    LocalDate datePublication) {
        super(description, prix, nb_stock);
        this.ISSN = ISSN;
        this.periodicite = periodicite;
        this.datePublication = datePublication;
    }

    public Magazine() {
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    @Override
    public String getNumero() {
        return ISSN;
    }

    @Override
    public double calculerPrix() {
        if (datePublication == null || periodicite == null) {
            return getPrix();
        }

        LocalDate aujourdHui = LocalDate.now();
        int dureeDeuxPeriodes;
        int dureeQuatrePeriodes;

        if (periodicite.equalsIgnoreCase("hebdomadaire")) {
            dureeDeuxPeriodes = 14;
            dureeQuatrePeriodes = 28;
            if (datePublication.isBefore(aujourdHui.minusDays(dureeQuatrePeriodes))) {
                return getPrix() * 0.25;
            }
            if (datePublication.isBefore(aujourdHui.minusDays(dureeDeuxPeriodes))) {
                return getPrix() * 0.5;
            }
        } else if (periodicite.equalsIgnoreCase("mensuel")) {
            if (datePublication.isBefore(aujourdHui.minusMonths(4))) {
                return getPrix() * 0.25;
            }
            if (datePublication.isBefore(aujourdHui.minusMonths(2))) {
                return getPrix() * 0.5;
            }
        } else if (periodicite.equalsIgnoreCase("trimestriel")) {
            if (datePublication.isBefore(aujourdHui.minusMonths(12))) {
                return getPrix() * 0.25;
            }
            if (datePublication.isBefore(aujourdHui.minusMonths(6))) {
                return getPrix() * 0.5;
            }
        }

        return getPrix();
    }
}
