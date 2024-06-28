package SilenceSages;

public class Main {
    /*
    Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
    Вилки лежат на столе между каждой парой ближайших философов.
    Каждый философ может либо есть, либо размышлять.
    Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
    Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
    Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза

     */
    public static void main(String[] args) {
        Boolean[] spoons = {true, true, true, true, true};
        Sage s1 = new Sage("Ivan", 0, spoons);
        Sage s2 = new Sage("Petr", 1, spoons);
        Sage s3 = new Sage("Sidor", 2, spoons);
        Sage s4 = new Sage("Andrey", 3, spoons);
        Sage s5 = new Sage("Slava", 4, spoons);

        s1.start();
        s2.start();
        s4.start();
        s5.start();
        s3.start();

    }


}
