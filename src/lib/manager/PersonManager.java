package lib.manager;

import lib.model.Person;

public class PersonManager {

    public void addChild(Person parent, Person children) {
        parent.getChildren().add(children);
    }

}
