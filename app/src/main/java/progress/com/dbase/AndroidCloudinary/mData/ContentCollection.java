package progress.com.dbase.AndroidCloudinary.mData;

import java.util.ArrayList;

/**
 * Created by Umar Saidu Auna on 1/21/2018.
 */

public class ContentCollection {
    public static ArrayList<Contents>getContents(){
        ArrayList<Contents> contentsArrayList = new ArrayList<>();

        Contents dataContents = new Contents();

        dataContents.setName("Wallpaper 1");
        dataContents.setUrl("mbuntu-14_pfbihf.png");
        contentsArrayList.add(dataContents);

        dataContents = new Contents();
        dataContents.setName("Wallpaper 2");
        dataContents.setUrl("mbuntu-4_s7xeda.jpg");
        contentsArrayList.add(dataContents);

        dataContents = new Contents();
        dataContents.setName("Wallpaper 3");
        dataContents.setUrl("mbuntu-11_fm1a0g.jpg");
        contentsArrayList.add(dataContents);

        dataContents = new Contents();
        dataContents.setName("Wallpaper 4");
        dataContents.setUrl("mbuntu-1_xof1md.jpg");
        contentsArrayList.add(dataContents);

        dataContents = new Contents();
        dataContents.setName("Wallpaper 5");
        dataContents.setUrl("mbuntu-1_xof1md.jpg");
        contentsArrayList.add(dataContents);

        return contentsArrayList;
    }
}
