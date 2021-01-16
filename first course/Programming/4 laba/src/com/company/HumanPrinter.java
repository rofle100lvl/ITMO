package com.company;

public class HumanPrinter {
    private final Human human;

    public HumanPrinter(Human human) {
        this.human = human;
    }

    public void printWears() {
        for (Wear wear : human.getHumanWear()) {
            System.out.printf("%s на %s\n", wear.getName(), wear.getLocation());
        }
    }

    public void printMemory() {
        for (int i = 0; i < human.getHumanBrain().getMemory().size(); i++) {
            System.out.printf("   %s знает, что  %s\n", human.getName(), human.getHumanBrain().getMemory().get(i));
        }
    }
}
