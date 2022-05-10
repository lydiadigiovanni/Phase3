package Backend.Grade;

import Backend.Assessment.Assessment;
import Backend.Assessment.FSPractice1;
import Backend.Assessment.FSPractice2;
import Backend.Assessment.FSPractice3;
import Backend.Assessment.FSPractice4;
import Backend.Assessment.FSPractice5;
import Backend.Assessment.FSPractice6;
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
        youtubeVideo = ("https://www.youtube.com/watch?v=arWnymu02og");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo2() {
        youtubeVideo = ("https://www.youtube.com/watch?v=n05ji0Ewxmo");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo3() {
        youtubeVideo = ("https://www.youtube.com/watch?v=pJ8KwRztfF0");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo4() {
        youtubeVideo = ("https://www.youtube.com/watch?v=r2K1Py9U87I");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo5() {
        youtubeVideo = ("https://www.youtube.com/watch?v=ftB5VU64yGA");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo6() {
        youtubeVideo = ("https://www.youtube.com/watch?v=iz7Ux7kq1Ho");
        return youtubeVideo;
    }

    @Override
    protected Assessment getPractice1() {
        return new FSPractice1();
    }

    @Override
    protected Assessment getPractice2() {
        return new FSPractice2();
    }

    @Override
    protected Assessment getPractice3() {
        return new FSPractice3();
    }

    @Override
    protected Assessment getPractice4() {
        return new FSPractice4();
    }

    @Override
    protected Assessment getPractice5() {
        return new FSPractice5();
    }

    @Override
    protected Assessment getPractice6() {
        return new FSPractice6();
    }
    
}
