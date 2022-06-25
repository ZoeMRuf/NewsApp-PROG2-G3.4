package downloader;

import at.ac.fhcampuswien.NewAPIException;

import java.util.List;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class SequentialDownloader extends Downloader {

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) throws NewAPIException{
        int count = 0;
        for (String url : urls) {
            try {
                String fileName = saveUrl2File(url);
                if(fileName != null)
                    count++;
            } catch (NewAPIException e){
                System.err.println(e.getMessage());
                throw new NewAPIException(e.getMessage());
            } catch (Exception e){
                throw new NewAPIException("Different problem occurred in " + this.getClass().getName() + ". Message: " + e.getMessage());
            }
        }
        return count;
    }
}
