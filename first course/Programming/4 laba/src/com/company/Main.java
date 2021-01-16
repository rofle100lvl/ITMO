package com.company;

public class Main {


    public static void main(String[] args) {
        Human neznaika = new Human("Незнайка", "Не земля", 1);
        Human vintik = new Human("Винтик", "Не земля", 3);
        Human shpuntik = new Human("Шпунтик", "Не земля", 3);
        Human firstFriendNeznaika = new Human("Коротышка 1", "Земля", 1);
        Human secondFriendNeznaika = new Human("Коротышка 2", "Земля", 1);
        Human thirdFriendNeznaika = new Human("Коротышка 3", "Земля", 1);


        System.out.println("\n\n");


        neznaika.see(a -> a.setLocation("Земля"), vintik, shpuntik);
        neznaika.worry();
        neznaika.setLocation("Земля");
        vintik.helpToWalk(neznaika);
        shpuntik.helpToWalk(neznaika);
        vintik.scaryAbout("отпустить Незнайку");
        shpuntik.scaryAbout("отпустить Незнайку");
        neznaika.see(a -> a.addFeel(new Feel("Страх", Size.MEDIUM, 0)), vintik, shpuntik);
        neznaika.tryToFree(shpuntik, vintik);
        neznaika.tryToHit(shpuntik);
        shpuntik.free(neznaika);
        vintik.free(neznaika);
        neznaika.step(10);
        neznaika.kissGround();
        Wear hat = new Wear("Шляпа", PartOfBody.HEAD) {
        };
        Wear pants = new Wear("Штаны", PartOfBody.LEGS) {
        };
        Wear rubashka = new Wear("Рубашка", PartOfBody.BODY) {
        };
        Wear shoes = new Wear("Туфли", PartOfBody.FEET) {
        };

        try {
            neznaika.addWear(hat);
        } catch (WearException e) {
            e.printStackTrace();

        }
        try {
            neznaika.addWear(pants);
        } catch (WearException e) {
            e.printStackTrace();

        }
        try {
            neznaika.addWear(rubashka);
        } catch (WearException e) {
            e.printStackTrace();

        }
        try {
            neznaika.addWear(shoes);
        } catch (WearException e) {
            e.printStackTrace();

        }
        neznaika.deleteWear("Шляпа");
        neznaika.cry();
        neznaika.say("Земля моя, матушка! Никогда не забуду тебя!", Volume.WHISPER);
        Sun sun = new Sun(6500);
        sun.shine(neznaika);
        Wind wind = new Wind(2.6);
        wind.flowWind(neznaika);
        neznaika.addFeel(new Feel("Непонятное чувство", Size.VERYVERYHARD, 101));
        System.out.printf("Незнайка чувствовал %s\n", neznaika.getFeels().get(neznaika.getFeels().size() - 1).getDescription());
        if (neznaika.getFeels().get(neznaika.getFeels().size() - 1).getGood() == 101) {
            System.out.print("Он считал это чувство лучшим на свете\n");
        }
        neznaika.snuggleUp();
        neznaika.stopCry();
        neznaika.getUp();
        neznaika.addFriend(firstFriendNeznaika);
        neznaika.addFriend(secondFriendNeznaika);
        neznaika.addFriend(thirdFriendNeznaika);
        neznaika.see(firstFriendNeznaika, secondFriendNeznaika, thirdFriendNeznaika);
        neznaika.laugh();
    }
}
