package gr.uoi.latexeditor.history;
/**
 * <h1>StableVersionsStrategy</h1>
 *  class responsible for holding the various Document versions on disk storage.
 *
 * @version 2.0
 * @since   2019-05-24
 *
 */

import gr.uoi.latexeditor.model.Document;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class StableVersionsStrategy implements VersionsStrategy {

    private String versionsPath;
    private ArrayList<Document> versionsHistory = new ArrayList<>();

    public StableVersionsStrategy() {
//        try {
//            URI uri = ClassLoader.getSystemResource("user.dir").toURI();
//            versionsPath = System.getProperty("user.dir");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
        versionsPath = System.getProperty("user.dir");
    }

    @Override
    public void putVersion(Document newVersion){
        try {
            Files.write(Paths.get( versionsPath + "/" + newVersion.getVersionID() + ".tex"),
                    newVersion.getContents().getBytes());
            versionsHistory.add(newVersion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getVersion(){
        if(!versionsHistory.isEmpty()) {
            String contents = null;
            try {
                contents = new String(Files.readAllBytes(Paths.get(versionsPath + "/" + (versionsHistory.size()) + ".tex")));
                versionsHistory.remove(versionsHistory.size()-1);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return contents;
        }
        return null;
    }

    @Override
    public void setEntireHistory(ArrayList<Document> versionsHistory){
        this.versionsHistory = versionsHistory;
        Iterator<Document> iterator = versionsHistory.iterator();
        while (iterator.hasNext()) {
            try {
                Document temp = iterator.next();
                Files.write(Paths.get(versionsPath + "/" + temp.getVersionID()+".tex"), temp.getContents().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Document> getEntireHistory(){
        return versionsHistory;
    }
}
