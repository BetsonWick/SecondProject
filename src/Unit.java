import org.newdawn.slick.GameContainer;
import  org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Базовый класс юнитов
public abstract class Unit
{

    private Vector2f Speed;//скорость
    private float mJumpSpeed;//скорость прыжка
    private int health;
    private boolean jump=false;//был ли совершен прыжок или нет
    private float mWalkSpeed;//Скорость ходьбы
    private Map<String,Vector2f>  ListForce;//Набор всех векторов сил действующих на тело
    private boolean OnEarth=false;//находится на земле или нет
    private  Rectangle Location ;//Месторасположение юнита
    private  int damage;
    public boolean isOnEarth() {
        return OnEarth;
    }

    public void setOnEarth(boolean onEarth) {
        OnEarth = onEarth;
    }




    public Map<String, Vector2f> getListForce() {
        return ListForce;
    }

    public void setListForce(Map<String, Vector2f> listForce) {
        ListForce = listForce;
    }

    public abstract  void attack();//функция атаки

    public Unit(int health, float mWalkSpeed, Rectangle location, int damage)
    {
        this.Speed=new Vector2f();
        this.ListForce=new HashMap<>();
        this.health = health;
        this.mWalkSpeed = mWalkSpeed;
        Location = location;
        this.damage = damage;

    }


    public  void move()
    {
        Location.setLocation(Location.getX()+Speed.getX(),Location.getY()+Speed.getY());
    };
    public  void move(float x,float y)
    {
        Location.setLocation(Location.getX()+x,Location.getY()+y);
    };

    public int getHealth() {
        return health;
    }

    public float getmJumpSpeed() {
        return mJumpSpeed;
    }

    public void setmJumpSpeed(float mJumpSpeed) {
        this.mJumpSpeed = mJumpSpeed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getmWalkSpeed() {
        return mWalkSpeed;
    }

    public void setmWalkSpeed(float mWalkSpeed) {
        this.mWalkSpeed = mWalkSpeed;
    }

    public Rectangle getLocation() {
        return Location;
    }

    public Vector2f getSpeed() {
        return Speed;
    }

    public void setSpeed(Vector2f speed) {
        Speed = speed;
    }
    public void setSpeed( float x,float y)
    {
        Speed.x += x;
        Speed.y+=y;
    }

//Функция выполняющася каждый кадр
    public void update(GameContainer gc, int delta)
    {
        ///Если юнит в воздухе - сила тяжести  действует
        if (!isOnEarth())
        {

          if (ListForce.containsKey("Gravity"))  setSpeed(ListForce.get("Gravity").getX()*delta/1000, ListForce.get("Gravity").getY()*delta/1000);
        }
        // иначе (когда юнит на земле)устанавливаем флаг состояния прыжка в false
        else jump=false;

    }
    public void setLocation(Rectangle location) {
        Location = location;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}