import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;


abstract class GameCreature extends GameObject
{
	protected int XSPE=10,YSPE=10;
	protected int xspe,yspe,xadd,yadd=3;
	protected List<GameObject> objs=null;
	
	public boolean draw = false;
	
	GameCreature(int x,int y,GameClient gc)
	{
		super(x,y,gc);
	}
	
	public void draw(Graphics g)
	{
		setObjs(gc.obj_map.objs);
		super.draw(g);
//		setAvailable();
//		getHasrun();
//		touchWithHero(gc.player1);
//		move();
//		action();
	}

	/**
	 * 设置物体还是否有效（是否绘制，是否检测碰撞）
	 */
	protected void checkAvailable()
	{
		if(available==false) return;
		if(getRectangle().intersects(new Rectangle(0,0,GameClient.F_W,GameClient.F_H)))
		{
			this.draw=true;
		}
		else if(x<=-GameClient.F_W/2)
		{
			draw=false;
			available=false;
		}
	}
	
	public void move()
	{
		super.move();
	}
	
	protected void xMove()
	{
		
	}
	
	protected void yMove()
	{
		
	}
	
	protected void disappear()
	{
		if(draw==true)
		{
			draw=false;
			available=false;
		}
		else return;
		
	}
	
	public void touchWithHero(Hero hero)
	{
		super.touchWithHero(hero);
	}
	
	protected void action()
	{
		super.action();
	}
	
	public void setObjs(List<GameObject> objs) {
		this.objs = objs;
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle(x,y,all_w,all_h);
	}
	public Rectangle getARectangle(int x,int y,int w,int h)
	{
		return new Rectangle(x,y,w,h);
	}
	public Rectangle getNextRectangle()
	{
		return new Rectangle(x+xspe,y+yspe,all_w,all_h);
	}
}
