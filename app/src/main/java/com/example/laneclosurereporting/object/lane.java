package com.example.laneclosurereporting.object;

public class lane {
    private String type , state ;

    public lane(String type, String state) {
        this.type = type;
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
