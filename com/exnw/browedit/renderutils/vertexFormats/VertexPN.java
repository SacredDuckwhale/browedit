package com.exnw.browedit.renderutils.vertexFormats;

import java.nio.FloatBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GLContext;

import com.exnw.browedit.math.Vector3;
import com.exnw.browedit.renderutils.Vbo;
import com.exnw.browedit.renderutils.Vertex;
import com.sun.opengl.util.BufferUtil;

public class VertexPN implements Vertex
{
	Vector3 position;
	Vector3 normal;
	
	public VertexPN() { }

	public VertexPN(Vector3 position, Vector3 normal)
	{
		super();
		this.position = position;
		this.normal = normal;
	}

	@Override
	public int getSize()
	{
		return 3+3;
	}

	@Override
	public void fillBuffer(FloatBuffer buffer, int offset)
	{
		for(int i = 0; i < 3; i++)
			buffer.put(offset+0+i, position.getData()[i]);
		for(int i = 0; i < 3; i++)
			buffer.put(offset+3+i, normal.getData()[i]);
	}

	@Override
	public void setPointers(Vbo vbo)
	{
		GL gl = GLContext.getCurrent().getGL();
		gl.glEnableClientState(GL.GL_VERTEX_ARRAY);             // activate vertex coords array
		gl.glEnableClientState(GL.GL_NORMAL_ARRAY);             // activate vertex coords array
		gl.glVertexPointer(3, GL.GL_FLOAT, getSize()*BufferUtil.SIZEOF_FLOAT, 0);
		gl.glNormalPointer(GL.GL_FLOAT, getSize()*BufferUtil.SIZEOF_FLOAT, 3*BufferUtil.SIZEOF_FLOAT);		
	}

}