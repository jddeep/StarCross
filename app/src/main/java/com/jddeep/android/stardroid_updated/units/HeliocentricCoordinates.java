package com.jddeep.android.stardroid_updated.units;

import com.jddeep.android.stardroid_updated.util.Geometry;
import com.jddeep.android.stardroid_updated.util.MathUtil;

import java.util.Date;

public class HeliocentricCoordinates extends Vector3 {
    public float radius;  // Radius. (AU)

    // Value of the obliquity of the ecliptic for J2000
    private static final float OBLIQUITY = 23.439281f * Geometry.DEGREES_TO_RADIANS;

    public HeliocentricCoordinates(float radius, float xh, float yh, float zh) {
        super(xh, yh, zh);
        this.radius = radius;
    }

    /**
     * Subtracts the values of the given heliocentric coordinates from this
     * object.
     */
    public void Subtract(HeliocentricCoordinates other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
    }

    public HeliocentricCoordinates CalculateEquatorialCoordinates() {
        return new HeliocentricCoordinates(this.radius,
                this.x,
                this.y * MathUtil.cos(OBLIQUITY) - this.z * MathUtil.sin(OBLIQUITY),
                this.y * MathUtil.sin(OBLIQUITY) + this.z * MathUtil.cos(OBLIQUITY));
    }

    public float DistanceFrom(HeliocentricCoordinates other) {
        float dx = this.x - other.x;
        float dy = this.y - other.y;
        float dz = this.z - other.z;
        return MathUtil.sqrt(dx * dx + dy * dy + dz * dz);
    }

//    public static HeliocentricCoordinates getInstance(Planet planet, Date date) {
//        return getInstance(planet.getOrbitalElements(date));
//    }


// TODO: MAKE THE CLASS OF ORBITAL ELEMENTS AND THEN IMPLEMENT THE BELOW METHOD
//    public static HeliocentricCoordinates getInstance(OrbitalElements elem) {
//        float anomaly = elem.getAnomaly();
//        float ecc = elem.eccentricity;
//        float radius = elem.distance * (1 - ecc * ecc) / (1 + ecc * MathUtil.cos(anomaly));
//
//        // heliocentric rectangular coordinates of planet
//        float per = elem.perihelion;
//        float asc = elem.ascendingNode;
//        float inc = elem.inclination;
//        float xh = radius *
//                (MathUtil.cos(asc) * MathUtil.cos(anomaly + per - asc) -
//                        MathUtil.sin(asc) * MathUtil.sin(anomaly + per - asc) *
//                                MathUtil.cos(inc));
//        float yh = radius *
//                (MathUtil.sin(asc) * MathUtil.cos(anomaly + per - asc) +
//                        MathUtil.cos(asc) * MathUtil.sin(anomaly + per - asc) *
//                                MathUtil.cos(inc));
//        float zh = radius * (MathUtil.sin(anomaly + per - asc) * MathUtil.sin(inc));
//
//        return new HeliocentricCoordinates(radius, xh, yh, zh);
//    }

    @Override public String toString() {
        return String.format("(%f, %f, %f, %f)", x, y, z, radius);
    }

}
