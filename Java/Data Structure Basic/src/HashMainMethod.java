import java.util.HashMap;

public class HashMainMethod {

    public static void main(String[] args) {

        DS_Hash1 mainObject = new DS_Hash1(20);

        mainObject.saveData("DaveLee", "030290");
        mainObject.saveData("asaskl", "23425");

        System.out.println(mainObject.getData("Dave"));


        DS_Hash2_Chaining mainObject2 = new DS_Hash2_Chaining(20);

        mainObject2.saveData("DaveLee", "0302901234");
        mainObject2.saveData("asaskl", "23425");
        mainObject2.saveData("DAve", "32423");

        System.out.println("mainObject2.getData(\"DaveLee\") = " + mainObject2.getData("DaveLee"));
        System.out.println(mainObject2.getData("Dave"));

        DS_Hash3_LinearProbing mainObject3 = new DS_Hash3_LinearProbing(20);

        mainObject3.saveData("hihi", "4545");
        mainObject3.saveData("hihihihihi", "980923789");
        mainObject3.saveData(("elloooo"), "767676");
        System.out.println("mainObject3.getData(\"hihihihihi\") = " + mainObject3.getData("hihihihihi"));

        HashMap<String, String> hash1 = new HashMap<String, String>();
        HashMap<Integer, String> hash2 = new HashMap<>();

        hash1.put("hihello", "hoy");
        hash2.put(2, "jinyoung");
        System.out.println("hash2.get(2) = " + hash2.get(2));
        System.out.println("hash1.get(\"hihello\") = " + hash1.get("hihello"));


    }
}
