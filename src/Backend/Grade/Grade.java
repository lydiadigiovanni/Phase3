package Backend.Grade;

import javafx.scene.web.WebView;

public abstract class Grade {
    /**
     * Island's specifc practices. KiPractice1, KiPractice2, KiPractice3, etc.
     * Each island's Tutorials
     */

    private String island1Name;

    private String island2Name;

    private String island3Name;


    public abstract WebView getYoutubeVideo1();

    public abstract WebView getYoutubeVideo2();

    public abstract WebView getYoutubeVideo3();

    public abstract WebView getYoutubeVideo4();

    public abstract WebView getYoutubeVideo5();

    public abstract WebView getYoutubeVideo6();

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
}
