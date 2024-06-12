public class Article {
    private final String nom;
    private double prix;

    public Article(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrixArticle(double prix) {
        this.prix = prix;
    }
}
