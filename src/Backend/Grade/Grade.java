package Backend.Grade;

import Backend.Assessment.Assessment;

public abstract class Grade {
    /**
     * Island's specifc practices. KiPractice1, KiPractice2, KiPractice3, etc.
     * Each island's Tutorials
     */

    private String island1Name;

    private String island2Name;

    private String island3Name;


    public abstract String getYoutubeVideo1();

    public abstract String getYoutubeVideo2();

    public abstract String getYoutubeVideo3();

    public abstract String getYoutubeVideo4();

    public abstract String getYoutubeVideo5();

    public abstract String getYoutubeVideo6();

    public String getIsland1Name() {
        return island1Name;
    }

    public String getIsland2Name() {
        return island2Name;
    }

    public String getIsland3Name() {
        return island3Name;
    }

    public void setIsland1Name(String island1Name) {
        this.island1Name = island1Name;
    }

    public void setIsland2Name(String island2Name) {
        this.island2Name = island2Name;
    }

    public void setIsland3Name(String island3Name) {
        this.island3Name = island3Name;
    }

    public Assessment getPractice(String string) {
        switch (string) {
            case "1":
                return getPractice1();
            case "2":
                return getPractice2();
            case "3":
                return getPractice3();
            case "4":
                return getPractice4();
            case "5":   
                return getPractice5();
            case "6":
                return getPractice6();
            default:
                return getPractice1();
        }
    }

    protected abstract Assessment getPractice1();
    protected abstract Assessment getPractice2();
    protected abstract Assessment getPractice3();
    protected abstract Assessment getPractice4();
    protected abstract Assessment getPractice5();
    protected abstract Assessment getPractice6();

}
