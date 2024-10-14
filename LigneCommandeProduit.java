
package ma.projet.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_commande_produit")
public class LigneCommandeProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;

    // Constructeur par défaut
    public LigneCommandeProduit() {
    }

    // Constructeur avec paramètres
    public LigneCommandeProduit(int quantite, Produit produit, Commande commande) {
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}