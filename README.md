# Company Utility API - README
## Description
La Company Utility API est une API REST réalisée avec Spring Boot qui permet de gérer les factures des différents clients d'une entreprise. Elle utilise Keycloak pour l'authentification et PostgreSQL comme base de données.

## Configuration requise
Avant de commencer, assurez-vous d'avoir installé les éléments suivants sur votre système :

- Java (JDK) 11 ou version ultérieure
- Docker et Docker Compose

## Installation et exécution

Suivez les étapes ci-dessous pour installer et exécuter l'API :

1) Clonez le dépôt de l'application depuis GitHub :
```bash
git clone https://github.com/GrandvauxClement/company-utility.git
cd company-utility
```
2) Assurez-vous d'avoir le fichier realm.json nécessaire pour la configuration de Keycloak dans le répertoire src/main/resources/keycloak/.

3) Lancez le projet à l'aide de Docker Compose :

```bash
docker compose up 
```
Cela démarrera les conteneurs PostgreSQL et Keycloak nécessaires pour le fonctionnement de l'API.

## Utilisation

Une fois l'API et les services liés (PostgreSQL et Keycloak) en cours d'exécution, vous pouvez commencer à l'utiliser pour gérer les factures des clients. Voici les points d'extrémité (endpoints) disponibles :

Décrivez ici les points d'extrémité de votre API :

[Accéder à l'interface swagger](http://localhost:8082/swagger-ui.html)

## Configuration
Pour utiliser Keycloak pour l'authentification, vous devrez configurer votre client et vos utilisateurs en fonction de vos besoins. Assurez-vous de consulter la documentation officielle de Keycloak pour plus de détails sur la configuration.

## Contributions
Les contributions à l'API Company Utility sont les bienvenues ! Si vous souhaitez contribuer à l'amélioration de cette application, veuillez suivre les étapes habituelles :

Fork (dupliquer) ce dépôt.
Créez une branche pour vos modifications.
Faites vos modifications et commit.
Push (poussez) vos modifications vers votre dépôt forké.
Ouvrez une demande d'extraction (pull request) vers ce dépôt principal.
Avertissement
Ce projet est fourni tel quel, sans aucune garantie. Assurez-vous de bien comprendre les implications de sécurité avant de le déployer en production.

## Développeurs

- Clément Grandvaux

[GitHub](https://github.com/GrandvauxClement) <br>
[LinkedIn](https://www.linkedin.com/in/cl%C3%A9ment-grandvaux-548ab219a/)