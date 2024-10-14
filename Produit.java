
package ma.projet.classes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "Produit.findProduitsWithPriceGreaterThan", query = "FROM Produit p WHERE p.prix > :prix")
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "prix")
    private float prix;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    
    
    @OneToMany(mappedBy = "produit")
    private List<LigneCommandeProduit> ligneCommandeProduits;
    

    public Produit() {
    }

    public Produit(int id, String reference, float prix, Categorie categorie) {
        this.id = id;
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public float getPrix() {
        return prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

   
}

