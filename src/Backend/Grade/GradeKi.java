package Backend.Grade;

import Backend.Assessment.Assessment;
import Backend.Assessment.KiPractice1;
import Backend.Assessment.KiPractice2;
import Backend.Assessment.KiPractice3;
import Backend.Assessment.KiPractice4;
import Backend.Assessment.KiPractice5;
import Backend.Assessment.KiPractice6;

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
        youtubeVideo = ("https://www.youtube.com/watch?v=iQQqRD-BM4U");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo4() {
        youtubeVideo = ("https://www.youtube.com/watch?v=7J1OkxuyLD0");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo5() {
        youtubeVideo = ("https://www.youtube.com/watch?v=VAWaV1upv6E");
        return youtubeVideo;
    }

    @Override
    public String getYoutubeVideo6() {
        youtubeVideo = ("https://www.youtube.com/watch?v=guNdJ5MtX1A");
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
        return new KiPractice3();
    }

    @Override
    protected Assessment getPractice4() {
        return new KiPractice4();
    }

    @Override
    protected Assessment getPractice5() {
        return new KiPractice5();
    }

    @Override
    protected Assessment getPractice6() {
        return new KiPractice6();
    }
    
}
