/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ufarm;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

/**
 * The Sprite class represents a image or node to be displayed.
 * In a 2D game a sprite will contain a velocity for the image to
 * move across the scene area. The game loop will call the update()
 * and collide() method at every interval of a key frame. A list of
 * animations can be used during different situations in the game
 * such as rocket thrusters, walking, jumping, etc.
 * @author cdea
 */
public abstract class Sprite {

    
    abstract Circle getCollisionBounds();
    
    
    /** Animation for the node */
    public List animations = new ArrayList<>();

    /** Current display node */
    public Node node;

    /** velocity vector x direction */
    public double vX = 0;

    /** velocity vector y direction */
    public double vY = 0;

    /** dead? */
    public boolean isDead = false;

    /**
     * Updates this sprite object's velocity, or animations.
     */
    public abstract void update();
    
    public abstract void handleCollision();

    /**
     * Did this sprite collide into the other sprite?
     *
     * @param other - The other sprite.
     * @return
     */
    public boolean collide(Sprite other) {

        if (getCollisionBounds() == null || other.getCollisionBounds() == null) {
            return false;
        }

        // determine it's size
        Circle otherSphere = other.getCollisionBounds();
        Circle thisSphere = getCollisionBounds();
        Point2D otherCenter = otherSphere.localToScene(otherSphere.getCenterX(), otherSphere.getCenterY());
        Point2D thisCenter = thisSphere.localToScene(thisSphere.getCenterX(), thisSphere.getCenterY());
        double dx = otherCenter.getX() - thisCenter.getX();
        double dy = otherCenter.getY() - thisCenter.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        double minDist = otherSphere.getRadius() + thisSphere.getRadius();

        return (distance < minDist);
    }
}
