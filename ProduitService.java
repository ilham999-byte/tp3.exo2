package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.classes.Produit;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;
import org.hibernate.Query;

public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public Produit getById(int id) {
        Session session = null;
        Produit produit = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            produit = (Produit) session.get(Produit.class, id);  // Suppression de la transaction ici
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        Session session = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            produits = session.createQuery("FROM Produit").list();  
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produits;
    }

    // Méthode pour trouver les produits par catégorie
    public List<Produit> findProduitsByCategorie(int categorieId) {
        Session session ;
        List<Produit> produits = null;
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Produit p WHERE p.categorie.id = :categorieId"); 
                              query.setParameter("categorieId", categorieId);
                              
        
        return produits;
    }

    // Méthode pour trouver les produits commandés entre deux dates
    public List<Produit> findProduitsCommandesEntreDates(Date dateDebut, Date dateFin) {
        Session session = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
             Query query  = session.createQuery("SELECT DISTINCT p FROM Produit p JOIN p.ligneCommandeProduits lc WHERE lc.commande.date BETWEEN :dateDebut AND :dateFin");
                              query.setParameter("dateDebut", dateDebut);
                              query.setParameter("dateFin", dateFin);
                             
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produits;
    }

    // Méthode pour trouver les produits dans une commande donnée
    public List<Object[]> findProduitsByCommande(int commandeId) {
        Session session = null;
        List<Object[]> result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT p.reference, p.prix, lc.quantite FROM Produit p JOIN p.ligneCommandeProduits lc WHERE lc.commande.id = :commandeId");
                           query.setParameter("commandeId", commandeId);
                            
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    // Méthode pour trouver les produits avec un prix supérieur à un certain montant
    public List<Produit> findProduitsWithPriceGreaterThan(double prix) {
        Session session = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("Produit.findProduitsWithPriceGreaterThan");
                              query.setParameter("prix", prix);
                              
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produits;
    }
}