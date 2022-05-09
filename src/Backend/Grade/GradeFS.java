package Backend.Grade;

import Backend.Assessment.Assessment;
import javafx.scene.web.WebView;

public class GradeFS extends Grade{
    private String youtubeVideo;

    public GradeFS() {
        setIsland1Name("OPERATION\nBEACH");
        setIsland2Name("TIME & MONEY\nSHORE");
        setIsland3Name("MEASUREMENT\nREEF");
        setGrade("FS");
    }  

    @Override
    public String getYoutubeVideo1() {
        youtubeVideo = ("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo2() {
        youtubeVideo = ("https://www.youtube.com/watch?v=CAiuTnyhmMQ");
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

    @Override
    protected Assessment getPractice1() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Assessment getPractice2() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Assessment getPractice3() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Assessment getPractice4() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Assessment getPractice5() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Assessment getPractice6() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
