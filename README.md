# Projet Kafka avec Docker Compose
##LE FICHIER DOCKER-COMPOSE.YML
Le fichier compose.yml simplifie le déploiement et la gestion des applications conteneurisées en définissant leurs configurations et dépendances dans un seul fichier,
facilitant ainsi l'automatisation, la portabilité et la réduction des erreurs
![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/41777e37-607a-415c-ba9f-415a77433d02)

## DÉMARRER ZOOKEEPER ET KAFKA-BROKER

![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/ffca1388-3c6d-45d7-a51b-f97607f6e2c3)

##TESTER PRODUCER ET COMSUMER

On a un topics nommée topics-name

Le producer envoie un message “Bonjour”
![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/41687c9c-9489-49af-b7aa-3b9df0efffaf)
Et le consumer le reçoit grâce au topic
![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/1238e9a1-3c84-4938-856b-50ff99bcb47f)

## CRÉER UN SERVICE PRODUCER KAFKA VIA UN REST CONTROLER
![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/5947529a-e6b4-4d77-b3ae-b059a55daeec)
![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/ab01ed13-f29d-42ae-b2f3-4693b8cf89bd)



##Application WeB
PageEventControler 
![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/9d5ff94f-51b1-4678-a06d-082b7651cce5)
Index.html
![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/3d7a2369-2f0c-423e-8c66-7f425663e76c)
Resultat 
J’ai eu un erreur de: Failed to load resource: the server responded with a
status of 404 () Voici ce que j’ai comme résultat :

![image](https://github.com/2002marie03/EVENT-DRIVEN-ARCHITECTURE/assets/95045123/20d1c558-001c-45a3-a2bc-bbb5271c8b49)

Commande Docker : 
docker-compose up -d zookeeper kafka
