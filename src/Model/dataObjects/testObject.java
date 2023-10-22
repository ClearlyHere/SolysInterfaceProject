package Model.dataObjects;

public class testObject {
    public static void main(String[] args) {
        Vehicule vehicule = new Vehicule(1, "volk", "ABX", 2004, "AAVX86", 50.50f);
        System.out.println(vehicule);
        System.out.println(vehicule.getPrimaryKey());
        System.out.println(vehicule.getTableArray());
    }
}
