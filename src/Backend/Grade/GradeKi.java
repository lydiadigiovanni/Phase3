package Backend.Grade;

import javafx.scene.web.WebView;

public class GradeKi extends Grade {
    private String youtubeVideo;
        

    public GradeKi() {
        setIsland1Name("COUNTING\nCOVE");
        setIsland2Name("OPERATION\nISLE");
        setIsland3Name("GEOMETRY\nCOAST");
    }  

    @Override
    public String getYoutubeVideo1() {
        youtubeVideo = ("https://www.youtube.com/watch?v=bGetqbqDVaA");

        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo2() {
        youtubeVideo = ("https://www.youtube.com/watch?v=5Re3nbmqVaU");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo3() {
        youtubeVideo = ("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo4() {
        youtubeVideo = ("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo5() {
        youtubeVideo = ("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo6() {
        youtubeVideo = ("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }
    
}
