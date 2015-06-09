package edu.miamioh.simple_test;

/**
 * Container class for representing coordinates on the field.
 *
 * @author Naoki Mizuno
 */
public class Coordinates {
    public int x, y;

    public Coordinates() {
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Coordinates)) {
            return false;
        }

        Coordinates other = (Coordinates)obj;

        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
