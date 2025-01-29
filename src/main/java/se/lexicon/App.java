package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println("Size: " + size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println("Size: " + NameRepository.getSize());
        NameRepository.clear();
        System.out.println("Size: " + NameRepository.getSize());
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println("Size: " + NameRepository.getSize());

        String[] copiedArray = NameRepository.findAll();
        for (String s : copiedArray) {
            System.out.print("," + s);
        }

        System.out.println("\nFind: " + NameRepository.find("Erik Svensson"));

        NameRepository.add("Eva Folin");
        copiedArray = NameRepository.findAll();
        for (String s : copiedArray) {
            System.out.print("," + s);
        }


    }
}
