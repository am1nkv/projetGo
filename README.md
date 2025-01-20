 **Projet R304**

	
 _AYINDE ALYA NESRINE HAJJEM LEONA TRAN AMINA KARMENOVA GROUPE 208-207_

## NOTE 10

## CORRECTION
Diagramme d'architecture OK, sauf les classes Case et Pion dont une au moins est possiblement redondante (plutôt Case).

Les tests sont très insuffisants. Il faut place ceux de chaque classe C dans une class CTest dand le meme paquetage que C.

Le readme ne dit pas clairement ce qui marche, s'il y a un mode partie ou pas et comment utiliser ce mode.

J'ai essayé de faire une partie contre le bot minimax : quelques commandes marchent mais pas play ! Manque de travail évident. 

play black B2 envoie "black" dans le paramètre coord et affiche une erreur !
	
 + Toutes les fonctions demandées fonctionnent.Notre projet se connecte a GoGui.
 
 set_player pour lancer une partie fonctionnent de la manière suivante :

 set_player couler type (on a 3 type human ,randomBot,minimax)



  


+ Diagramme de dépendances : ![](DiagrammeDependances.png)


+ 6 tests unitaires passent et testMatchNul nepasse pas.


+ Le plus compliqué était de coder tout en respectant les principes SOLID, sachant que l'on les apprenait au même moment. Notre code était donc sans cesse en permanente évolution pour essayer d'appliquer au mieux les principes et les notions de patterns vus en cours.
