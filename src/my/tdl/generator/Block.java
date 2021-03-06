package my.tdl.generator;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my.project.gop.main.Vector2F;
import my.tdl.main.Assets;

public class Block extends Rectangle{
	
	Vector2F pos = new Vector2F();
	private int BlockSize = 48;
	private BlockType blocktype;
	private BufferedImage block;
	private boolean isSolid;
	
	public Block(Vector2F pos, BlockType blocktype){
		this.pos = pos;
		this.blocktype = blocktype;
		init();
	}
	
	public Block isSolid(boolean isSolid){
		this.isSolid = isSolid;
		return this;
	}
	
	public void init(){
		switch(blocktype){
		case STONE_1:
			block = Assets.getStone_1();
			break;

		case WALL_1:
			block = Assets.getWall_1();
			break;
			
			
		}
	}
	
	
	public void tick(double deltaTime){
		setBounds((int)pos.xpos, (int)pos.ypos, BlockSize, BlockSize);
	}
	
	public void render(Graphics2D g){
		//g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, 32, 32);
		g.drawImage(block, (int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize, null);
		
		if(isSolid){
			g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize);
		}
		
	}
	
	public enum BlockType{
		STONE_1,
		WALL_1
	}

	public boolean isSolid() {
		
		return isSolid;
	}
	
	
	
	
}
