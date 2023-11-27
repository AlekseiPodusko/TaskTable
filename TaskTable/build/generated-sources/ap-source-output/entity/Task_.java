package entity;

import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-11-27T08:26:00")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, User> User;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile SingularAttribute<Task, Long> id;
    public static volatile SingularAttribute<Task, Boolean> completed;

}