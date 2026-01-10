import java.util.Random;

public class Player {

    private Integer hp;
    private String name;

    public Player(String name){
        this.hp = 100;
        this.name = name;
    }

    public Integer getHp(){
        return hp;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isAlive(){
        return hp > 0;
    }

    public void kicked (int kick){
        if ((kick<1) || (kick>9)){
            System.out.println("Введите число от 1 до 9");
            return;
        }

        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if (randomNumber <= 10 - kick){
            System.out.println("Ты попал в цель");
            this.hp -= kick * 10;
            return;
        }

        System.out.println("Ты не попал в цель");
    }
}
