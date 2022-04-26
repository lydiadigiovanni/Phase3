package Backend.Grade;

import javafx.scene.web.WebView;

public class GradeKi extends Grade {
    private WebView youtubeVideo;
        

    public GradeKi() {
        setIsland1Name("COUNTING\nCOVE");
        setIsland2Name("OPERATION\nISLE");
        setIsland3Name("GEOMETRY\nCOAST");
    }  

    @Override
    public WebView getYoutubeVideo1() {
        youtubeVideo.getEngine().load("https://www.youtube.com/watch?v=bGetqbqDVaA");

        return youtubeVideo;
    }

    @Override
    public WebView getYoutubeVideo2() {
        youtubeVideo.getEngine().load("https://www.youtube.com/watch?v=5Re3nbmqVaU");
        return youtubeVideo;
    }

    @Override
    public WebView getYoutubeVideo3() {
        youtubeVideo.getEngine().load("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }

    @Override
    public WebView getYoutubeVideo4() {
        youtubeVideo.getEngine().load("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }

    @Override
    public WebView getYoutubeVideo5() {
        youtubeVideo.getEngine().load("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }

    @Override
    public WebView getYoutubeVideo6() {
        youtubeVideo.getEngine().load("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }
    
}
