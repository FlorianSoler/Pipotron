# How to use me ?
 Juste compile the "main.java" with `javac` or using Visual Studio Code

# Sujet : Pipotron - Programme de génération de phrases
## Partie I - Pipotron

Le programme Java doit être capable de lire les fichiers de règles et de portions de phrases fournis dans l'archive du projet et les utiliser pour générer des phrases automatiquement.

Le programme doit :

- Lire les fichiers fournis
- Sélectionner une règle au hasard et l'appliquer pour générer une phrase
- Répéter l'opération jusqu'à atteindre le nombre de phrases désiré

Deux exemples de code source sont fournis : FileReaderExample.java et XmlReaderExample.java.

## Partie II - Pipotron interactif

Une fois la Partie I terminée, une étape supplémentaire est requise après la génération de chaque phrase. Cette étape permet à l'utilisateur de visualiser le résultat et de demander une réécriture partielle si nécessaire.

![interactive](https://github.com/FlorianSoler/Pipotron/blob/Dev/UML/Interraction.png)

L'utilisateur peut :

- Visualiser la phrase générée
- Demander la régénération d'une partie de la phrase en indiquant le numéro associé
- Entrer 0 pour valider la phrase et passer à la génération de la phrase suivante

Il est également possible d'ajouter une fonctionnalité permettant à l'utilisateur de réécrire directement une partie de la phrase.

## Consignes et contraintes d'implémentation

Avant l'implémentation, il est nécessaire de modéliser le programme en UML et d'appliquer le diagramme lors de l'implémentation. La correspondance entre la modélisation et l'implémentation sera vérifiée.

![UML](https://github.com/FlorianSoler/Pipotron/blob/main/UML/PipotronUML.svg)
