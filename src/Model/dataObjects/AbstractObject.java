package Model.dataObjects;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractObject {
    public int getPrimaryKey() {
        Field[] attributs = this.getClass().getDeclaredFields();
        try {
            attributs[0].setAccessible(true);
            return (int) attributs[0].get(this);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public List<Object> getTableArray() {
        List<Object> tableList = new ArrayList<>();
        Field[] attributs = this.getClass().getDeclaredFields();
        try {
            for (Field attribut : attributs) {
                // If field is static, skip it
                if (Modifier.isStatic(attribut.getModifiers())){
                    continue;
                }
                attribut.setAccessible(true);
                Object valeur = attribut.get(this);
                tableList.add(valeur);
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return tableList;
    }

    public String toString(){
        StringBuilder string = new StringBuilder(this.getClass().getSimpleName() + "{");
        Field[] attributs = this.getClass().getDeclaredFields();
        try {
            for (Field attribut : attributs) {
                // If field is static, skip it
                if (Modifier.isStatic(attribut.getModifiers())){
                    continue;
                }
                attribut.setAccessible(true);
                Object valeur = attribut.get(this);
                string.append(attribut.getName()).append('=').append("'").append(valeur).append("', ");
            }
            string.setLength(string.length() - 2);
            string.append("}\n");
        } catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        return string.toString();
    }


}
