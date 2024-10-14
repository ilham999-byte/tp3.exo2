package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.Commande;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;
import java.util.List;
import ma.projet.classes.LigneCommandeProduit;
import org.hibernate.Query;

public class CommandeService implements IDao<Commande> {

    @Override
    public boolean create(Commande o) {
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
    public Commande getById(int id) {
        Session session = null;
        Commande commande = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            commande = (Commande) session.get(Commande.class, id);  // Suppression de la transaction ici
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return commande;
    }

    @Override
    public List<Commande> getAll() {
        Session session = null;
        List<Commande> commandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
          List<LigneCommandeProduit> lignesCommande;
          Query query = session.createQuery("FROM LigneCommandeProduit");
          lignesCommande = query.list();  
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return commandes;
    }
}