# tp3.exo2
# Application de Gestion de Stock

Ce projet est une application de gestion de stock pour un magasin de vente de produits informatiques. L'application permet de gérer les produits, les catégories, les commandes, et les lignes de commande avec Hibernate et MySQL.

## Structure du projet

### A. Couche Persistance

1. **Classes Entités :**  
   Les classes entités sont développées dans le package `ma.projet.classes`.

2. **Configuration Hibernate :**  
   Le fichier de configuration `hibernate.cfg.xml` est créé dans le package `ma.projet.config`.

3. **Utilitaire Hibernate :**  
   La classe `HibernateUtil` est développée dans le package `ma.projet.util`.

### B. Couche Service

1. **Interface Générique IDao :**  
   L'interface générique `IDao` est créée dans le package `ma.projet.dao`.

2. **Classes de Service :**  
   - `ProduitService`
   - `CategorieService`
   - `CommandeService`
   - `LigneCommandeService`  
   
   Ces classes implémentent l'interface `IDao` dans le package `ma.projet.service`.

3. **Méthodes spécifiques :**
   - Afficher la liste des produits par catégorie dans `ProduitService`.
   - Afficher la liste des produits commandés entre deux dates dans `ProduitService`.
   - Afficher les produits dans une commande donnée (ex. commande n°4).
   - Afficher la liste des produits dont le prix est supérieur à 100 DH à l'aide d'une requête nommée dans `ProduitService`.

### C. Tests

Des programmes de tests sont créés pour valider les fonctionnalités suivantes :
- Affichage des produits par catégorie.
- Affichage des produits commandés entre deux dates.
- Affichage des produits dans une commande donnée.
- Affichage des produits dont le prix dépasse 100 DH.
