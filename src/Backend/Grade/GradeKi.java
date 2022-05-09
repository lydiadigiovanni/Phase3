package Backend.Grade;

import Backend.Assessment.Assessment;
import Backend.Assessment.KiPractice1;
import Backend.Assessment.KiPractice2;

public class GradeKi extends Grade {
    private String youtubeVideo;
        

    public GradeKi() {
        setIsland1Name("COUNTING\nCOVE");
        setIsland2Name("OPERATION\nISLE");
        setIsland3Name("GEOMETRY\nCOAST");
        setGrade("Ki");
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

    @Override
    protected Assessment getPractice1() {
        return new KiPractice1();
    }

    @Override
    protected Assessment getPractice2() {
        return new KiPractice2();
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
