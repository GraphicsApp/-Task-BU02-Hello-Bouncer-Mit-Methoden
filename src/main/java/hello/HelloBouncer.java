package hello;

import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class HelloBouncer extends BouncerApp {

    /**
     * Diese Methode bildet den Kern des Bouncer-Programms. Beginnend bei der erste Zeile "loadMap(..." werden alle
     * hier notierten Befehl in der angegebenen Reihenfolge bearbeitet. In Abhängigkeit des jeweils vorliegenden
     * Weltzustands sowie der internen States des Programms führen dieser Befehl dann jeweils zu einer Positionsveränderung
     * von Bouncer und/oder eine Manipulation der Welt.
     */
    @Override
    public void bounce() {
        // Hier wird die Welt geladen, in der Bouncer platziert und die weiteren Befehle ausgeführt werden.
        loadMap("World"); // Welt: Bouncer steht vor einem Plateau, auf dem sich ein rotes Feld befindet
        moveToObstacle(); // Bouncer bewegt sich durch die in eine Methode ausgelagerten Befehle bis zum Hindernis
        climbObstacle(); // Bouncer bewegt sich durch die in eine Methode ausgelagerten Befehle auf das Hindernis
        bouncer.move(); // Bouncer bewegt sich einen Schritt nach vorne und betritt so das rote Feld
        // Nach der Ausführung aller Befehle und Methoden steht Bouncer auf dem roten Feld
    }

    /**
     * Durch das Ausführen dieser Methode wird Bouncer von seiner aktuellen Position bis zum nächsten
     * Hindernis in Blickrichtung bewegt.
     *
     * Pre-Condition: Bouncer befindet sich auf einem beliebigen Feld. In seiner Blickrichtung befindet sich ein Hindernis.
     * Post-Condition: Bouncer steht auf dem Feld direkt vor einem Hindernis und blickt in dessen Richtung.
     */
    public void moveToObstacle() {
        while (bouncer.canMoveForward()) {
            bouncer.move();
        }
    }

    /**
     * Durch das Ausführen dieser Methode wird Bouncer auf das erste Feld eines beliebig langen Hindernisses direkt
     * vor ihm bewegt.
     *
     * Pre-Condition: Bouncer befindet sich direkt vor dem Hindernis und blickt nach Westen.
     * Post-Condition: Bouncer befindet sich über/auf dem ersten Feld des Hindernisses.
     */
    public void climbObstacle() {
        bouncer.turnLeft();
        bouncer.move();
        turnRight();
        bouncer.move();
    }

    /**
     * Durch das Ausführen dieser Methode wird Bouncer um 90 Grad nach rechts gedreht.
     *
     * Pre-Condition: -
     * Post-Condition: Bouncer hat seine ursprüngliche Blickrichtung um 90 Grad nach rechts verändert.
     */
    public void turnRight() {
        for (int i = 0; i < 3; i++) {
            bouncer.turnLeft();
        }
    }


    /**
     * Über diese Methode wird das Boucner-Programm gestartet und dadurch auch die von Ihnen vorbereitete bouncer-Methode
     * ausgeführt. Diese main-Methode muss sich in jedem Bouncer-Programm in genau dieser Form befinden. Sie können das
     * Programm dann über einen Klick auf den grünen Pfeil links neben dem Methodennamen und der Auswahl "Run ..." starten.
     */
    public static void main(String[] args) {
        BouncerLauncher.launch();
    }
}
