package lib.manager;

import lib.model.Person;

/**
 * Mengatur bagaimana data class Person diubah dari sudut pandang hubungan dengan objek lain
 */
public class PersonManager {

    public void addChild(Person parent, Person children) {
        parent.getChildren().add(children);
    }

}
