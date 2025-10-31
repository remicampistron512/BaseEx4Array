# Exercice 4 : Les Tableaux [BaseEx4Array] & quelques collections

Cette application permet de pratiquer la manipulation de tableaux en Java.

La classe BaseEx4Array permet de récupérer la plus petite note, la plug grande et la moyenne.
La classe Teacher simule l'entrée d'élèves dans une liste par un professeur.

## Sommaire
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Fonctionnalités](#fonctionnalités)
- [Structure-du-code](#structure-du-code)

## Installation
1. Assurez-vous d’avoir **Java (JDK 8+)**.
2. Placez les deux fichiers suivants dans le **même dossier** :
   - `Teacher.java`
   - `BaseEx4Array.java` (nécessaire car `Teacher` appelle `BaseEx4Array.averageGrade(...)`)
3. Compilez :

   ```bash
   javac BaseEx4Array.java Teacher.java
    ```

4. Lancez l’application :

   ```bash
   java Teacher
   ```

## Utilisation

1. Au démarrage, le programme :

   * prépare une **liste d’élèves prédéfinie** (`fullNames`)
   * prépare une **liste de notes associées** (`gradesStr`)
   * extrait les **prénoms** et les affiche :

     * liste brute
     * liste triée A→Z
     * liste triée Z→A

2. Ensuite il affiche :

   ```text
   Voulez vous saisir un nouvel élève ou voir la liste des élèves (taper 1 ou 2)
   ```

   * tapez **1** → vous ajoutez un nouvel élève
   * tapez **2** → vous affichez la liste des élèves existants (avec leurs notes) puis le programme s’arrête

3. **Si vous tapez 1** (ajout d’élève) :

   * le programme demande le **prénom** puis le **nom**
   * puis les **notes** séparées par des espaces, par ex. :

     ```text
     15 12 18
     ```
   * il calcule la **moyenne** à partir de ces notes
   * il ajoute l’élève dans le `HashMap`

4. Si l’élève existe déjà, le programme vous le dit et vous propose :

   ```text
   L'élève est dèjà dans la liste, voulez vous consulter ses notes et sa moyenne ? Oui / Non
   ```

5. À la fin d’un ajout, le programme demande :

   ```text
   Voulez-vous rentrer les details d'un autre éleve ? Oui / Non
   ```

   * **Oui** → on recommence
   * **Non** → le programme affiche **toute la liste des élèves** et termine


## Fonctionnalités

* ✅ Chargement d’une **liste d’élèves** et de leurs **notes** au démarrage
* ✅ **Affichage des prénoms** extraits des noms complets
* ✅ **Tri alphabétique** et **tri inverse** des prénoms
* ✅ Ajout **interactif** d’un nouvel élève
* ✅ Saisie de notes **séparées par un espace**
* ✅ Détection d’un **élève déjà existant**
* ✅ Calcul de la **moyenne** d’un élève à partir d’une chaîne de notes
* ✅ Affichage final de **tous les élèves avec leurs notes**
* 🧩 Code pédagogique : tableaux, `ArrayList`, `HashMap`, `Scanner`, réutilisation d’une classe externe

## Structure du code

* **`public class Teacher`**

  * **`main(String[] args)`** : point d’entrée

    * initialise les données de départ (`fullNames`, `gradesStr`)
    * affiche les prénoms (brut, trié, trié inversé)
    * remplit le `HashMap<String, String> studentsList`
    * ouvre un `Scanner` pour dialoguer avec l’utilisateur
    * boucle principale : “1 = saisir un élève, 2 = afficher la liste”

* **Données de départ**

  * `String[] fullNames` → liste de 12 élèves
  * `String[] gradesStr` → pour chaque élève, une chaîne du type `"18 14 12"`

* **Méthodes utilitaires**

  * `extractFirstName(String[] names)`

    * prend un tableau de noms complets
    * retourne une `ArrayList<String>` de **prénoms uniquement**

  * `sortAlpha(ArrayList<String> firstNameList)`

    * trie les prénoms **par ordre alphabétique**

  * `sortReverseAlpha(ArrayList<String> firstNameList)`

    * trie les prénoms **dans l’ordre alphabétique inverse**

  * `inputFirstName(Scanner scan)` / `inputLastName(Scanner scan)` / `inputGrades(Scanner scan)`

    * gèrent les saisies utilisateur

  * `convertToIntAndAverage(String gradesString)`

    * transforme `"18 14 12"` → `int[] {18,14,12}`
    * appelle **`BaseEx4Array.averageGrade(...)`**
    * retourne la **moyenne**

* **Dépendance vers `BaseEx4Array`**

  * La méthode `convertToIntAndAverage(...)` fait :

    ```java
    averageGrade = BaseEx4Array.averageGrade(gradesIntArray);
    ```
  * → il faut donc **compiler et fournir** `BaseEx4Array.java` avec.


