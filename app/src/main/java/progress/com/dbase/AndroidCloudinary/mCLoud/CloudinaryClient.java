package progress.com.dbase.AndroidCloudinary.mCLoud;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;

/**
 * Created by Umar Saidu Auna on 1/21/2018.
 */

public class CloudinaryClient {
    public static String getRoundCornerImage(String ImageName){
        Cloudinary cloud = new Cloudinary(Myconfiguration.getMyConfigs());
        Transformation transformation = new Transformation();
        transformation.radius(60);
        transformation.height(500);
        transformation.width(800);

        String url = cloud.url().transformation(transformation).generate(ImageName);
        return url;
    }
}
