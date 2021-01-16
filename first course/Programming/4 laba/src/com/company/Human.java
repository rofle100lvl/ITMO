package com.company;

import java.util.ArrayList;

public class Human extends Being {
    private int humanPower;
    private boolean isIll = false;

    private final Brain humanBrain = new Brain();
    private final Eyes humanEyes = new Eyes();

    private final ArrayList<Wear> humanWear = new ArrayList<>();
    private final ArrayList<Feel> humanFeels = new ArrayList<>();
    private final ArrayList<Tear> tears = new ArrayList<>();
    private final ArrayList<Human> humanFriends = new ArrayList<>();

    //Constructor
    public Human(String name, String location, int humanPower) {
        super(name, location);
        this.humanPower = humanPower;
    }

    //Overrides methods
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return this.getId() == human.getId();
    }



    //
    public void treatment() { // <--
        isIll = false;
        System.out.printf("Болезнь у %s пропадает сама собой\n", getName());
    }

    public void powerUp() {
        humanPower += 5;
        System.out.printf("Силы %s восстанавливаются\n", getName());
    }

    public void snuggleUp() {
        System.out.printf("Грудь %s прижимается к %s\n", getName(), getLocation());
        powerUp();
        treatment();
    }

    public void scaryAbout(String s) {
        this.addFeel(new Feel("Страх", Size.MEDIUM, 0));
        System.out.printf("%s боится %s\n", this.getName(), s);
    }

    void see(See action, Human... humans) {
        humanEyes.working();
        System.out.print(getName());
        System.out.print(" видит, что:\n");
        for (Human human:
                humans) {
            System.out.print("\t-");
            action.start(human);
        }
    }

    void see(Human... humans) throws FriendException{
        for (Human human:
                humans) {
            if (human.getHumanFriends().contains(this) != this.getHumanFriends().contains(human)) throw new FriendException();
        }

        humanEyes.working();
        System.out.print(getName());
        System.out.print(" смотрит на:\n");
        for (Human human:
                humans) {
            if (humanFriends.contains(human)) System.out.printf("\t-своего друга %s\n", human.getName());
            else System.out.println(human.getName());
        }
    }

    public void tryToHit(Human opponent) {
        class Hit {
            private double power;

            public Hit(double power) {
                this.power = power;
            }

            public void applyEffect(Human sufferer) {
                sufferer.humanBrain.scaryLevelUp();
                sufferer.humanBrain.stressUp();
                System.out.printf("%s ударил %s\n", getName(), sufferer.getName());
            }
        }
        Hit hit = new Hit(170);
        if (Math.random() <= 0.05) hit.applyEffect(opponent);
        else System.out.printf("%s попытался ударить %s\n", getName(), opponent.getName());
    }

    public void tryToFree(Human... humans) {
        System.out.printf("%s пытается освободиться от ", this.getName());
        for (Human human:
                humans) {
            System.out.printf("%s ", human.getName());
        }
    }

    public void step(int a) {
        if (humanBrain.stressLevel >= 5) {
            System.out.printf("%s сделал %d неувренных шагов\n", getName(), a);
            System.out.printf("%s упал на колени \n", getName());
        } else System.out.printf("%s сделал %d  шагов", toString(), a);
    }

    public void kissGround() {
        System.out.printf("%s принялся целовать Землю \n", getName());
    }

    public void free(Human a) {
        System.out.printf("%s отупускает %s\n", this.getName(), a.getName());
    }

    public void worry() {
        humanBrain.stressUp();
        System.out.printf("%s заволновался\n", this.getName());
    }

    public void laugh() {
        System.out.printf("%s засмеялся", getName());
    }

    public void helpToWalk(Human human) {
        System.out.printf("%s помогает идти %s\n", this.getName(), human.getName());
    }

    public void stopCry() {
        for (int i = 2; i >= 0; i--) {
            tears.get(i).drop(this);
            tears.remove(i);
        }
        if (tears.size() == 0) {
            System.out.printf("Слёзы %s закончились\n", getName());
        }
    }

    public void cry() {
        for (int i = 0; i < 6; i++) {
            tears.add(new Tear());

        }
        for (int i = 0; i < 3; i++) {
            tears.get(i).drop(this);
            tears.remove(0);
        }
    }

    public void getUp() {
        System.out.printf("%s встал с земли\n", getName());
    }

    public void say(String s, Volume p) {
        System.out.printf("%s сказал %s:\n\t-%s\n", getName(), p.getName(), s);
    }



    //Setters and Getters
    public Brain getHumanBrain() {
        return humanBrain;
    }

    public Eyes getHumanEyes() {
        return humanEyes;
    }

    public ArrayList<Wear> getHumanWear() {
        return humanWear;
    }

    public ArrayList<Human> getHumanFriends() {
        return new ArrayList<Human>(humanFriends);
    }

    public ArrayList<Feel> getFeels() {
        return humanFeels;
    }

    //Add and Delete
    public void addWear(Wear a) throws WearException {
        for (Wear in : humanWear) {
            if (in.getLocation() == a.getLocation()) {
                throw new WearException("Часть тела уже занята " + in.getName());
            }
        }
        humanWear.add(a);
    }

    public void addFeel(Feel a) {
        humanFeels.add(a);
        System.out.printf("%s чувство разрывает %s грудь\n", a.getSize(), getName());
    }

    public void addFriend(Human a) {
        humanFriends.add(a);
        a.humanFriends.add(this);
    }

    public void deleteWear(String s) {
        int index = 0;
        for (Wear a : humanWear) {
            if (s.equals(a.getName())) {
                break;
            }
            index++;
        }
        System.out.printf("С %s слетел элемент одежды %s, который был у него на %s\n", getName(), humanWear.get(index).getName(), humanWear.get(index).getLocation());
        humanWear.remove(index);
    }


    //Inner Classes
    class Brain {
        private final ArrayList<String> memory = new ArrayList<>();
        private int power = 0;
        private int stressLevel = 0;
        private int scaryLevel = 0;

        public void working(String a) {
            System.out.printf("Мозг %s начал работу на процессом\n", a);
            power += 5;
        }

        void stopWorking(String a) {
            System.out.printf("Мозг %s закончил работу над процессом\n", a);
            power -= 5;
        }

        void stressUp() {
            System.out.print("Уровень стресса поднялся\n");
            stressLevel += 5;

        }

        void stressDown() {
            System.out.print("Уровень стресса опустился\n");
            stressLevel -= 5;
        }

        void scaryLevelUp() {
            System.out.printf("Уровень страха %s поднялся\n", getName());
            scaryLevel += 5;
        }

        void scaryLevelDown() {
            System.out.printf("Уровень страха %s опустился\n", getName());
            scaryLevel -= 5;
        }

        public ArrayList<String> getMemory() {
            return memory;
        }
    }

    class Eyes {
        String color;

        public void working() {
            System.out.print("Глаза начали работу на процессом\n");
        }

        void stopWorking() {
            System.out.print("Глаза закончили работу над процессом\n");
        }
    }
}
