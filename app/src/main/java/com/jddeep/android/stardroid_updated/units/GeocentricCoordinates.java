package com.jddeep.android.stardroid_updated.units;

import com.jddeep.android.stardroid_updated.util.Geometry;
import com.jddeep.android.stardroid_updated.util.MathUtil;

public class GeocentricCoordinates extends Vector3{
    public GeocentricCoordinates(float x, float y, float z) {
        super(x, y, z);
    }

    /** Recomputes the x, y, and z variables in this class based on the specified
     * {@link RaDec}.
     */
    public void updateFromRaDec(RaDec raDec) {
        updateFromRaDec(raDec.ra, raDec.dec);
    }


    /**
     * Updates these coordinates with the given ra and dec in degrees.
     */
    private void updateFromRaDec(float ra, float dec) {
        float raRadians = ra * Geometry.DEGREES_TO_RADIANS;
        float decRadians = dec * Geometry.DEGREES_TO_RADIANS;

        this.x = MathUtil.cos(raRadians) * MathUtil.cos(decRadians);
        this.y = MathUtil.sin(raRadians) * MathUtil.cos(decRadians);
        this.z = MathUtil.sin(decRadians);
    }

    /** Returns the RA in degrees */
    public float getRa() {
        // Assumes unit sphere.
        return Geometry.RADIANS_TO_DEGREES * MathUtil.atan2(y, x);
    }

    /** Returns the declination in degrees */
    public float getDec() {
        // Assumes unit sphere.
        return Geometry.RADIANS_TO_DEGREES * MathUtil.asin(z);
    }

    /**
     * Convert ra and dec to x,y,z where the point is place on the unit sphere.
     */
    public static GeocentricCoordinates getInstance(RaDec raDec) {
        return getInstance(raDec.ra, raDec.dec);
    }

    public static GeocentricCoordinates getInstance(float ra, float dec) {
        GeocentricCoordinates coords = new GeocentricCoordinates(0.0f, 0.0f, 0.0f);
        coords.updateFromRaDec(ra, dec);
        return coords;
    }

    /**
     * Convert ra and dec to x,y,z where the point is place on the unit sphere.
     */
    public static GeocentricCoordinates getInstanceFromFloatArray(float[] xyz) {
        return new GeocentricCoordinates(xyz[0], xyz[1], xyz[2]);
    }

    @Override
    public float[] toFloatArray() {
        return new float[] {x, y, z};
    }

    /**
     * Assumes it's an array of length 3.
     * @param xyz
     */
    public void updateFromFloatArray(float[] xyz) {
        this.x = xyz[0];
        this.y = xyz[1];
        this.z = xyz[2];
    }

    public void updateFromVector3(Vector3 v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    @Override
    public GeocentricCoordinates copy() {
        return new GeocentricCoordinates(x, y, z);
    }

    public static GeocentricCoordinates getInstanceFromVector3(Vector3 v) {
        return new GeocentricCoordinates(v.x, v.y, v.z);
    }
}
