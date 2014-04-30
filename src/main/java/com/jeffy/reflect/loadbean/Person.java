package com.jeffy.reflect.loadbean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by Administrator on 14-4-18.
 */
@XStreamAlias("person")
public class Person {
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String ref;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}
