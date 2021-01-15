package com.company;

import java.util.ArrayList;

public class Human extends Being  {
    private int id;
    private Brain humanBrain = new Brain();
    private Eyes humanEyes = new Eyes();
    private static int count_peoples;
    private String location;
    private ArrayList<Wear> humanWear=new ArrayList<>();
    public void getWears(){
        for (Wear a:humanWear) {
            System.out.printf("%s на %s\n",a.getName(),a.getLocation());
        }
    }
    public void addWear(Wear a)throws WearException{
        for (Wear in:humanWear) {
            if(in.getLocation()==a.getLocation()){
                throw new WearException("Часть тела уже занята " + in.getName());
            }
        }
        humanWear.add(a);
    }
    public void deleteWear(String s){
        int index=0;
        for (Wear a:humanWear) {
            if(s.equals(a.getName())) {
                break;
            }
            index++;
        }
        System.out.printf("С %s слетел элемент одежды %s, который был у него на %s\n",getName(),humanWear.get(index).getName(),humanWear.get(index).getLocation());
        humanWear.remove(index);
    }

    private ArrayList<Feel>  humanFeels=new ArrayList<>();
    public void addFeel(Feel a){
        humanFeels.add(a);
        if(a.getSize().getName().equals("Огромное-преогромное")){
            System.out.printf("Огромное-преогромное чувство разрывает %s грудь\n",getName());
        }
    }
    public ArrayList<Feel> getFeels(){
        return humanFeels;
    }

    private ArrayList<Tear> tears=new ArrayList<>();
    private ArrayList<Human> humanFriends=new ArrayList<>();
    public void addFriend(Human a){
        humanFriends.add(a);
        a.humanFriends.add(this);
    }
    public ArrayList<Human> getHumanFriends() {
        return new ArrayList<Human>(humanFriends);
    }

    private int humanPower;
    private boolean ill;


    @Override
    public String toString(){
        return name;
    }
    @Override
    public int hashCode(){
        return id;
    }
    @Override
    public boolean equals(Object o) {
        Human man = (Human) o;
        if(o!=null && this.id==man.id  )return true;
        return false;
    }
    class Brain{
        int power=0;
        int stressLevel=0;
        int scaryLevel=0;
        public ArrayList<String> memory= new ArrayList<>();

        public void working(String a) {
            System.out.printf("Мозг %s начал работу на процессом\n",a);
            power += 5;
        }
        void stopWorking(String a){
            System.out.printf("Мозг %s закончил работу над процессом\n",a);
            power-=5;
        }
        void stresUp(){
            System.out.printf("Уровень стресса поднялся\n");
            stressLevel+=5;

        }

        void stresDown(){
            System.out.printf("Уровень стресса опустился\n");
            stressLevel-=5;
        }
        void scaryLevelUp(){
            System.out.printf("Уровень страха %s поднялся\n",getName());
            scaryLevel+=5;
        }
        void scaryLeveldown(){
            System.out.printf("Уровень страха %s опустился\n",getName());
            scaryLevel-=5;
        }
    }

    class Eyes{
        String color;
        public void working() {
            System.out.print("Глаза начали работу на процессом\n");
        }
        void stopWorking(){
            System.out.print("Глаза закончили работу над процессом\n");
        }
    }
    public void seeOnFriends(Human a,Human b,Human c) throws FriendException{
        if(getHumanFriends().contains(a) != a.getHumanFriends().contains(this))throw new FriendException();
        if(getHumanFriends().contains(b) != b.getHumanFriends().contains(this))throw new FriendException();
        if(getHumanFriends().contains(c) != c.getHumanFriends().contains(this))throw new FriendException();
        if(getHumanFriends().contains(a))System.out.printf("%s смотрит на соего друга %s на %s\n",getName(),a.getName(),a.getLocation());
        if(getHumanFriends().contains(b))System.out.printf("%s смотрит на соего друга %s на %s\n",getName(),b.getName(),b.getLocation());
        if(getHumanFriends().contains(c))System.out.printf("%s смотрит на соего друга %s на %s\n",getName(),c.getName(),c.getLocation());
    }
    public String getLocation() {
        return location;
    }
    public void treatment(){
        ill=false;
        System.out.printf("Болезнь %s пропадает сама собой\n",getName());
    }
    public void powerUp(){
        humanPower+=5;
        System.out.printf("Силы %s восстанавливаются\n",getName());
    }
    public void snuggleUp(){
        System.out.printf("Грудь %s прижимается к %s\n",getName(),getLocation());
        powerUp();
        treatment();
    }

    private String name;
    void changeLocation(String loc){
        location=loc;
        System.out.printf("Местоположение %s изменено на %s\n", this.getName(),loc);
    }
    public void scary(){
        this.humanBrain.scaryLevelUp();
        Feel feel =new Feel("Страх",Size.MEDIUM,0);
        addFeel(feel);
    }
    public void scaryAbout(String s){
        scary();
        System.out.printf("%s боится %s\n",this.getName(),s);
    }
    @FunctionalInterface
    interface See{
        void start(Human a);
    }
    void see(Human a,Human b , See imp){
        humanEyes.working();
        System.out.print(getName());
        System.out.print(" видит, что:\n");
        System.out.print("     -");
        imp.start(a);
        System.out.print("     -");
        imp.start(b);
        humanEyes.stopWorking();
    }
    void enterOnTheEarth(){
        System.out.printf("%s ступил на Землю\n",getName());
        changeLocation("Земля");
    }
    public void tryToHit(Human a){
        class Hit{
            private double power;

            public Hit(double power) {
                this.power = power;
            }
            public void applyEffect(Human sufferer){
                if(Math.random()<=0.1){
                    sufferer.humanBrain.scaryLevelUp();
                    sufferer.humanBrain.stresUp();
                    System.out.printf("%s ударил %s\n",getName(),sufferer.getName());
                }
                else{
                    System.out.printf("%s пытается ударить %s\n",getName(),sufferer.getName());
                }
            }
        }
        Hit hit =new Hit(170);
        hit.applyEffect(a);

    }
    public void tryToFree(Human a,Human b){
        System.out.printf("%s пытается освободиться от %s и %s\n",this.getName(),a.getName(),b.getName());
    }
    public void step(int a){
        if(humanBrain.stressLevel>=5) {
            System.out.printf("%s сделал %d неувренных шагов\n", getName(), a);
            System.out.printf("%s упал на колени \n", getName());
        }
        else System.out.printf("%s сделал %d  шагов",toString(),a);
    }
    public void kissGround(){
        System.out.printf("%s принялся целовать Землю \n", getName());
    }
    public void free(Human a){
        System.out.printf("%s отупускает %s\n",this.getName(),a.getName());
    }
    public void worry(){
        humanBrain.stresUp();
        System.out.printf("%s заволновался\n",this.getName());
    }
    public void addMemory(String s){
        this.humanBrain.memory.add(s);
    }
    public void getMemory(){
        for (int i=0;i<this.humanBrain.memory.size();i++){
            System.out.printf("   %s знает, что  %s\n",name,humanBrain.memory.get(i));
        }
    }
    public void laugh(){
        System.out.printf("%s засмеялся",getName());
    }
    public void helpToWalk(Human a,Human b){
        System.out.printf("%s и %s помогают идти %s\n",a.getName(),b.getName(),this.getName());
    }

    public Human(String name) {
        setName(name);
        id=count_peoples;
        count_peoples+=1;
        if(name=="Незнайка")ill=true;
    }
    public void stopCry(){
        for(int i=2;i>=0;i--){
            tears.get(i).drop(this);
            tears.remove(i);
        }
        if(tears.size()==0) {
            System.out.printf("Слёзы %s закончились\n",getName());
        }
    }
    public void cry(){
        for(int i=0;i<6;i++){
            tears.add(new Tear());

        }
        for(int i=0;i<3;i++){
            tears.get(i).drop(this);
            tears.remove(0);
        }


    }
    public void getUp(){
        System.out.printf("%s встал с земли\n",getName());
    }
    public boolean isEqual(Human a){
        return a.id==this.id;
    }
    public void say(String s,Volume p){
        System.out.printf("%s сказал %s:\n\t-%s\n",getName(),p.getName(),s);
    }

}
