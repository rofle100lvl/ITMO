package com.company;

public class Main {

    public static void main(String[] args) {
        Human neznaika = new Human("Незнайка");
        Human vintik = new Human("Винтик");
        Human shpuntik = new Human("Шпунтик");
        Human firstFriendNeznaika = new Human("Коротышка 1");
        Human secondFriendNeznaika = new Human("Коротышка 2");
        Human thirdFriendNeznaika = new Human("Коротышка 3");
        firstFriendNeznaika.changeLocation("Земля");
        secondFriendNeznaika.changeLocation("Земля");
        thirdFriendNeznaika.changeLocation("Земля");
        System.out.println("\n\n");
        neznaika.see(vintik, shpuntik, Human::enterOnTheEarth);
        neznaika.worry();
        neznaika.changeLocation("Земля");
        neznaika.helpToWalk(vintik, shpuntik);
        vintik.scaryAbout("отпустить Незнайку");
        shpuntik.scaryAbout("отпустить Незнайку");
        neznaika.see(vintik, shpuntik, Human::scary);
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
        neznaika.seeOnFriends(firstFriendNeznaika, secondFriendNeznaika, thirdFriendNeznaika);
        neznaika.laugh();

    }
}
