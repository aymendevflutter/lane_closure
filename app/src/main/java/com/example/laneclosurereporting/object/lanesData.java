package com.example.laneclosurereporting.object;

import com.example.laneclosurereporting.R;

import java.util.List;

public class lanesData {
    private int srcIcons = R.color.black ;
    private String namesLanes = "-";
    private  int srcIconsx = R.color.black;
    private String namesLanesx ="-" ;
    private boolean b = false;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public lanesData() {

    }

    public void setSrcIconsx(int srcIconsx) {
        this.srcIconsx = srcIconsx;
    }

    public void setNamesLanesx(String namesLanesx) {
        this.namesLanesx = namesLanesx;
    }

    public int getSrcIconsx() {
        return srcIconsx;
    }

    public String  getNamesLanesx() {
        return namesLanesx;
    }

    public int getSrcIcons() {
        return srcIcons;
    }

    public String getNamesLanes() {
        return namesLanes;
    }

    public void setSrcIcons(int srcIcons) {
        this.srcIcons = srcIcons;
    }

    public void setNamesLanes(String namesLanes) {
        this.namesLanes = namesLanes;
    }

    public void Clear(){
        setNamesLanes("-");
      setNamesLanesx("-");
        setSrcIcons(1);
       setSrcIconsx(1);
        setB(false);

    }
}
