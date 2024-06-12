import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Vente {
    private final List<Article> articlesChoisis;

    public Vente() {
        this.articlesChoisis = new ArrayList<>();
    }

    public void ajouterArticle(Article article) {
        articlesChoisis.add(article);
    }

    public double calculerSommeTotale() {
        double sommeTotale = 0;
        for (Article article : articlesChoisis) {
            sommeTotale += article.getPrix();
        }
        return sommeTotale;
    }

    public void genererFacture() {
        JOptionPane.showMessageDialog(null,"Facture :");
        for (Article article : articlesChoisis) {
            JOptionPane.showMessageDialog(null,"Article vendu "+article.getNom() + " - $" + article.getPrix());
        }
        JOptionPane.showMessageDialog(null,"Somme totale : $" + calculerSommeTotale());
    }
}
