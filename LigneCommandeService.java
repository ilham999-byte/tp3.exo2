package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.LigneCommandeProduit;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;
import java.util.List;
import static javafx.scene.input.KeyCode.Q;
import org.hibernate.Query;

public class LigneCommandeService implements IDao<LigneCommandeProduit> {
    private Object query;

    @Override
    public boolean create(LigneCommandeProduit o) {
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
    public LigneCommandeProduit getById(int id) {
        Session session = null;
        LigneCommandeProduit ligneCommande = null;
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
        return ligneCommande;
    }

    @Override
    public List<LigneCommandeProduit> getAll() {
        Session session = null;
        List<LigneCommandeProduit> lignesCommande = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
         
            Query query = session.createQuery("FROM LigneCommandeProduit");
            lignesCommande = query.list();  

        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lignesCommande;
    }
}