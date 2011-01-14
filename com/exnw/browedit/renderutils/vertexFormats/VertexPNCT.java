package com.exnw.browedit.renderutils.vertexFormats;

import java.awt.Color;
import java.nio.FloatBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GLContext;

import com.exnw.browedit.math.Vector2;
import com.exnw.browedit.math.Vector3;
import com.exnw.browedit.renderutils.Vbo;
import com.sun.opengl.util.BufferUtil;

public class VertexPNCT extends VertexPNC
{
	Vector2 textureCoord1;
	
	public VertexPNCT() {}
	
	public VertexPNCT(Vector3 position, Vector3 normal, Color color, Vector2 textureCoord1)
	{
		super(position, normal, color);
		this.textureCoord1 = textureCoord1;
	}

	@Override
	public int getSize()
	{
		return super.getSize()+2;
	}
	@Override
	public void fillBuffer(FloatBuffer buffer, int offset)
	{
		super.fillBuffer(buffer, offset);
		for(int i = 0; i < 2; i++)
			buffer.put(offset+super.getSize()+i, textureCoord1.getData()[i]);		
	}
	
	@Override
	public void setPointers(Vbo vbo)
	{
		super.setPointers(vbo);
		GL gl = GLContext.getCurrent().getGL();
		gl.glClientActiveTexture(GL.GL_TEXTURE0);
		gl.glEnableClientState(GL.GL_TEXTURE_COORD_ARRAY);
		gl.glTexCoordPointer(2, GL.GL_FLOAT, getSize()*BufferUtil.SIZEOF_FLOAT, super.getSize()*BufferUtil.SIZEOF_FLOAT);
	}	
}