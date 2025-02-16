package se.lexicon;


import java.util.Arrays;

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

//        //clone(0) method did not return a shallow copy of the array, but a deep copy.
//        System.out.println("copiedArray: using findAll()");
//        String[] copiedArray = NameRepository.findAll();
//        String[] copiedArray2 = copiedArray.clone();
//
//        for (int i = 0; i < copiedArray.length; i++) {
//            copiedArray[i] += " (modified)";
//        }
//        System.out.println(Arrays.toString(copiedArray));
//        System.out.println(Arrays.toString(copiedArray2));


        System.out.println("\nOriginal array: ");
        System.out.println(Arrays.toString(NameRepository.findAll()));

        System.out.println();

        System.out.println("\nFind: " + NameRepository.find("Erik Svensson"));

        NameRepository.add("Eva Folin");
        NameRepository.add("erik Javan  ");

        System.out.println(Arrays.toString(NameRepository.findAll()));


        System.out.println("\nfindByFirstName: ");
        System.out.println(Arrays.toString(NameRepository.findByFirstName("erik")));


        System.out.println("\nfindByLastName: ");
        System.out.println(Arrays.toString(NameRepository.findByLastName(" Javan   ")));

        System.out.println("\nupdate: ");
        NameRepository.update("Erik Javan", "Hameed Javan");
        System.out.println(Arrays.toString(NameRepository.findAll()));

        System.out.println("\nremove: ");
        NameRepository.remove("Eva Folin ");
        System.out.println(Arrays.toString(NameRepository.findAll()));



    }
}
