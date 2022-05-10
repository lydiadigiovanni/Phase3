package Backend.Grade;

import Backend.Assessment.Assessment;
import Backend.Assessment.TFPractice1;
import Backend.Assessment.TFPractice2;
import Backend.Assessment.TFPractice3;
import Backend.Assessment.TFPractice4;
import Backend.Assessment.TFPractice5;
import Backend.Assessment.TFPractice6;
import javafx.scene.web.WebView;

public class GradeTF extends Grade{
    private String youtubeVideo;

    public GradeTF() {
        setIsland1Name("OPERATION\nCOVE");
        setIsland2Name("FRACTION\nLAGOON");
        setIsland3Name("ALGEBRA\nATOLL");
        setGrade("TF");
    }  

    @Override
    public String getYoutubeVideo1() {
        youtubeVideo = ("https://www.youtube.com/watch?v=Q6YjynxH3r8");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo2() {
        youtubeVideo = ("https://www.youtube.com/watch?v=GiiuZ8sfw00");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo3() {
        youtubeVideo = ("https://www.youtube.com/watch?v=ZF5Viuwo1bw");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo4() {
        youtubeVideo = ("https://www.youtube.com/watch?v=p33BYf1NDAE");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo5() {
        youtubeVideo = ("https://www.youtube.com/watch?v=l3XzepN03KQ");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo6() {
        youtubeVideo = ("https://www.youtube.com/watch?v=Qyd_v3DGzTM");
        return youtubeVideo;
    }

    @Override
    protected Assessment getPractice1() {
        return new TFPractice1();
    }

    @Override
    protected Assessment getPractice2() {
        return new TFPractice2();
    }

    @Override
    protected Assessment getPractice3() {
        return new TFPractice3();
    }

    @Override
    protected Assessment getPractice4() {
        return new TFPractice4();
    }

    @Override
    protected Assessment getPractice5() {
        return new TFPractice5();
    }

    @Override
    protected Assessment getPractice6() {
        return new TFPractice6();
    }
    
}
