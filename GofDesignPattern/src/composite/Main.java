package composite;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Making root entries ...");
            Directory rootDir = new Directory("root");
            Directory binDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");

            rootDir.add(binDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);

            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));

            System.out.println("");
            System.out.println("Making user entries");
            Directory kim = new Directory("Kim");
            Directory Lee = new Directory("Lee");
            Directory park = new Directory("Park");

            usrDir.add(kim);
            usrDir.add(Lee);
            usrDir.add(park);

            kim.add(new File("diary.html", 100));
            kim.add(new File("Composite.java", 200));

            Lee.add(new File("memo.text", 300));
            park.add(new File("game.doc", 400));
            park.add(new File("junk.mail", 500));

            rootDir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}

/*
결과

Making root entries ...

Making user entries
/root (31500)
/root/bin (30000)
/root/bin/vi (10000)
/root/bin/latex (20000)
/root/tmp (0)
/root/usr (1500)
/root/usr/Kim (300)
/root/usr/Kim/diary.html (100)
/root/usr/Kim/Composite.java (200)
/root/usr/Lee (300)
/root/usr/Lee/memo.text (300)
/root/usr/Park (900)
/root/usr/Park/game.doc (400)
/root/usr/Park/junk.mail (500)

 */