package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println("Size: " + size);

        NameRepository.setNames(new String[]{"  Erik Svensson    ", "Mehrdad Javan"});
        System.out.println("Size: " + NameRepository.getSize());

        NameRepository.clear();
        System.out.println("Size: " + NameRepository.getSize());

        String[] names = {"  Erik Svensson    ", "Mehrdad Javan"};
        NameRepository.setNames(names);
        System.out.println("Size: " + NameRepository.getSize());
        names[0] = "cccc";

        String[] copiedArray = NameRepository.findAll();
        for (String s : copiedArray) {
            System.out.print(", " + s);
        }

        System.out.println("\nFind: " + NameRepository.find("Erik Svensson"));

        NameRepository.add("Eva Folin");
        NameRepository.add("erik Javan  ");

        copiedArray = NameRepository.findAll();
        for (String s : copiedArray) {
            System.out.print(", " + s);
        }


        System.out.println("\nfindByFirstName: ");
        String[] matchingNames = NameRepository.findByFirstName("erik");;
        for (String s : matchingNames) {
            System.out.print(", " + s);
        }


        System.out.println("\nfindByLastName: ");
        matchingNames = NameRepository.findByLastName("Javan");
        for (String s : matchingNames) {
            System.out.print(", " + s);
        }

        System.out.println("\nupdate: ");
        NameRepository.update("Erik Javan", "Hameed Javan");
        copiedArray = NameRepository.findAll();
        for (String s : copiedArray) {
            System.out.print(", " + s);
        }

        System.out.println("\nremove: ");
        NameRepository.remove("Eva Folin ");
        copiedArray = NameRepository.findAll();
        for (String s : copiedArray) {
            System.out.print(", " + s);
        }



    }
}
