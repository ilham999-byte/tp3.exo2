
package ma.projet.test;

import ma.projet.classes.Produit;
import ma.projet.service.ProduitService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        ProduitService produitService = new ProduitService();

        // Test 1: Afficher les produits par catégorie
        System.out.println("Produits dans la catégorie 1:");
        List<Produit> produitsParCategorie = produitService.findProduitsByCategorie(1);
        if (produitsParCategorie != null) {
            produitsParCategorie.forEach(System.out::println);
        } else {
            System.out.println("Aucun produit trouvé dans la catégorie 1.");
        }

        // Test 2: Afficher les produits commandés entre deux dates
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut = sdf.parse("2023-01-01");
            Date dateFin = sdf.parse("2023-12-31");
            System.out.println("Produits commandés entre deux dates:");
            List<Produit> produitsEntreDates = produitService.findProduitsCommandesEntreDates(dateDebut, dateFin);
            if (produitsEntreDates != null) {
                produitsEntreDates.forEach(System.out::println);
            } else {
                System.out.println("Aucun produit commandé trouvé entre ces dates.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test 3: Afficher les produits d'une commande donnée
        System.out.println("Produits de la commande 4:");
        List<Object[]> produitsCommande = produitService.findProduitsByCommande(4);
        if (produitsCommande != null) {
            for (Object[] row : produitsCommande) {
                System.out.println("Référence: " + row[0] + ", Prix: " + row[1] + ", Quantité: " + row[2]);
            }
        } else {
            System.out.println("Aucun produit trouvé pour la commande 4.");
        }

        // Test 4: Afficher les produits avec un prix supérieur à 100 DH
        System.out.println("Produits avec un prix supérieur à 100 DH:");
        List<Produit> produitsPrixSup100 = produitService.findProduitsWithPriceGreaterThan(100);
        if (produitsPrixSup100 != null) {
            produitsPrixSup100.forEach(System.out::println);
        } else {
            System.out.println("Aucun produit trouvé avec un prix supérieur à 100 DH.");
        }
    }
}
