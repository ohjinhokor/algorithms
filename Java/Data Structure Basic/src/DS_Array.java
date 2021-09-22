import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DS_Array {

    public static void main(String[] args) {
        Integer[] data_list = new Integer[10];
        data_list[0] = 1;

        System.out.println("data_list[1] = " + data_list[1]);

        Integer datalist1[] = {5,4,3,2,1};
        Integer[] datalist2 = {6,7,8,9,0};

        System.out.println("datalist1[0] = " + datalist1[0]);
        System.out.println("datalist2[0] = " + datalist2[0]);

        System.out.println("Arrays.toString(datalist2) = " + Arrays.toString(datalist2));

        List<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        System.out.println("====get====");
        System.out.println(list1.get(0));

        list1.remove(0);
        System.out.println("====get====");
        System.out.println(list1.get(0));

        Integer data_list_22[][] = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("data_list_22[1][0] = " + data_list_22[1][0]);

        Integer data_list_33[][][] = {{{1, 2, 3,}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}};

        System.out.println(data_list_33[1][0][1]);
        System.out.println(data_list_33[1][1][0]);

        String dataset[] = {
                "MBraund, Mr. Owen Harris",
                "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
                "Heikkinen, Miss. Laina",
                "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
                "Allen, Mr. William Henry",
                "Moran, Mr. James",
                "McCarthy, Mr. Timothy J",
                "Palsson, Master. Gosta Leonard",
                "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
                "Nasser, Mrs. Nicholas (Adele Achem)",
                "Sandstrom, Miss. Marguerite Rut",
                "Bonnell, Miss. Elizabeth",
                "Saundercock, Mr. William Henry",
                "Andersson, Mr. Anders Johan",
                "Vestrom, Miss. Hulda Amanda Adolfina",
                "Hewlett, Mrs. (Mary D Kingcome) ",
                "Rice, Master. Eugene",
                "Williams, Mr. Charles Eugene",
                "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
                "Masselmani, Mrs. Fatima",
                "Fynney, Mr. Joseph J",
                "Beesley, Mr. Lawrence",
                "McGowan, Miss. Anna",
                "Sloper, Mr. William Thompson",
                "Palsson, Miss. Torborg Danira",
                "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
                "Emir, Mr. Farred Chehab",
                "Fortune, Mr. Charles Alexander",
                "Dwyer, Miss. Ellen",
                "Todoroff, Mr. Lalio",
                "MkM"
        };

        Integer count =0;
        for(Integer item = 0; item < dataset.length; item++){
            if (dataset[item].indexOf("M") >= 0){
                System.out.println(dataset[item].indexOf("M"));
                count = count+1;
            }
        }

        System.out.println("count = " + count);
    }
}

