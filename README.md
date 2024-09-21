
# 🎨 Jeu ASCII - Création de Formes Géométriques 🎨

Ce projet est une application console permettant de créer et d'afficher différentes **formes géométriques** (cercles, rectangles, carrés) dans un style ASCII. Les utilisateurs peuvent interagir avec les formes en les ajoutant, déplaçant et modifiant leurs couleurs via des commandes textuelles.

## 📋 Fonctionnalités

- ➕ **Ajouter des formes** : Ajoutez des cercles, rectangles ou carrés avec des commandes simples.
- 👁️ **Afficher les formes** : Représentation graphique des formes dans la console en ASCII.
- 📜 **Lister les formes** : Obtenez une liste numérotée des formes présentes dans l'illustration.
- 🔀 **Déplacer les formes** : Modifiez la position d'une forme à l'aide de coordonnées.
- 🎨 **Changer la couleur** : Modifiez la couleur d'une forme avec une commande.

## 🛠️ Prérequis

- ☕ **Java** (version 8 ou supérieure)
- Un terminal/console pour exécuter l'application

## 🎮 Commandes de Jeu

Voici quelques commandes que vous pouvez utiliser pour manipuler les formes :

- **Ajouter un cercle** :  
  ```bash
  add circle [x] [y] [rayon] [couleur]
  ```
  Exemple :  
  ```bash
  add circle 5 3 1 c
  ```
  
- **Ajouter un rectangle** :  
  ```bash
  add rectangle [x] [y] [largeur] [hauteur] [couleur]
  ```
  Exemple :  
  ```bash
  add rectangle 10 10 5 20 r
  ```

- **Afficher l'illustration** :  
  ```bash
  show
  ```

- **Afficher la liste des formes** :  
  ```bash
  list
  ```

- **Déplacer une forme** :  
  ```bash
  move [index] [dx] [dy]
  ```
  Exemple :  
  ```bash
  move 1 10 20
  ```

- **Changer la couleur d'une forme** :  
  ```bash
  color [index] [nouvelle couleur]
  ```
  Exemple :  
  ```bash
  color 0 C
  ```

## 🖼️ Exemple de Représentation

Voici à quoi pourrait ressembler une illustration contenant 4 cercles dans la console :

```
ccccccc    ccccccc
ccccccccccc   ccccccccccc
ccccccccccccc   ccccccccccccc
ccccccccccccc   ccccccccccccc
ccccccccccccccc ccccccccccccccc
ooooooooooo ooooooooooo
```

## 👩‍💻 Auteur

Ce jeu vous est proposé par **Aya**.

---

