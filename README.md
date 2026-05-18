## SeeStar, c'est quoi ?
Il s'agit d'une application dont le but est d'accéder rapidement et efficacement à un réseaux de satellites.

## Comment est-elle composée ?
Une partie Base de donnée locale, qui est à téléchargée, pour l'instant purement accessible en console, et une partie Base de donnée distante, faite en graphique.

## Des choses spécifiques ?
Dans le release, télécharger le zip, il contien les éléments nécessaires au fonctionnement d el'application, c'est-à-dire la Base de donnée locale (java_sat_db), la gestion de cette Base de donnée (sqlite-jdbc-3.53.0.0) et la gestion de la base de donnée distante (mysql-connector-j-9.7.0).

Pour la partie Distante, l'utilisation de Xamp sera nécessaire pour s'authentification. Pour l'instant, il est nécessaire de créer une base de donnée "sat_db" soi-même, possédant une table "utilisateurs", avec 3 colonnes : une colonne "id" clé primaire qui s'incrémente automatiquement, une colonne "pseudo" en VARCHAR(50) et une "password" en VARCHAR(50) également.
A l'avenir, il est prévu de vérifier automatiquement si la table existe, et de la créer si nécessaire au lancement du programme.

## Qu'est-ce qui est prévu pour le futur ?
Tout d'abord, vérifier automatiquement si la base de donnée "utilisateurs" existe, et de la créer si nécessaire au lancement du programme. Ensuite, finir la Direction Artistique de la partie graphique pour les Bases de données distantes (notamment au niveau des couleurs).

## Technos
Java pour la programmation
SQLite et JDCB pour les bases de données

## Fait par
TIAYAH Roches Destain
LE STRAT Mathieu
ORDUREAU Adam
