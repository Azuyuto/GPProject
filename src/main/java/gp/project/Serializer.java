package gp.project;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.SerializationUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
public class Serializer {


    public void serialize(Tree copy) {
        try {
            String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
            FileOutputStream fos = new FileOutputStream(fileName);
            SerializationUtils.serialize(copy, fos);
            fos.close();

        } catch (IOException ignore) {
        }
    }

    public Tree deserialize(String fileName) {
        Tree desTree = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            desTree = (Tree) SerializationUtils.deserialize(fis);
            fis.close();
        } catch (IOException ignore) {
        }
        return desTree;
    }
}
