package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.Categorie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;

public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie o) {
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
    public Categorie getById(int id) {
        Session session = null;
        Categorie categorie = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            categorie = (Categorie) session.get(Categorie.class, id);  // Suppression de la transaction ici
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return categorie;
    }

    @Override
    public List<Categorie> getAll() {
        Session session = null;
        List<Categorie> categories = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
         Query query = session.createQuery("FROM Categorie");
         
        
        } catch (HibernateException e) {
            e.printStackTrace();  // Affichage de l'erreur pour le débogage
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return categories;
    }
}