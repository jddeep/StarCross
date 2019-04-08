package com.jddeep.android.stardroid_updated.renderer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Represents a reference to an OpenGL texture.  You may bind the texture to
 * set it active, or delete it.  Normal Java garbage collection will not
 * reclaim this, so you must delete it when you are done with it.  Note that
 * when the OpenGL surface is re-created, any existing texture references are
 * automatically invalidated and should not be bound or deleted.
 */
public interface TextureReference {
    /**
     * Sets this as the active texture on the OpenGL context.
     * @param gl The OpenGL context
     */
    void bind(GL10 gl);

    /**
     * Deletes the texture resource.  This should not be called multiple times.
     * Note that when the OpenGL surface is being re-created, all resources
     * are automatically freed, so you should not delete the textures in that
     * case.
     * @param gl
     */
    void delete(GL10 gl);
}

