package action;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;
import service.PostsService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by shihan on 12/20/15.
 */
public class UpdateImgAction implements Action {
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private String savePath;
    private String text;
    private PostsService postsService;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() throws Exception{
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    @Override
    public String execute() throws Exception {
        String abstractSavePath = createFile();
        postsService.updateImgPost(text, abstractSavePath, 1);
        return SUCCESS;
    }

    String createFile() throws Exception{
        //get current date and make new directory such as "/savePath/YEAR/MONTH/DATE"
        Calendar c = Calendar.getInstance();
        String dirPath = getSavePath() + "/" + c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DATE);
        File dir = new File(dirPath);
        if (!dir.exists())
            dir.mkdirs();

        //generate unique filename to save file
        StringBuffer fileNameBuffer = new StringBuffer(getUploadFileName());
        fileNameBuffer.replace(0, fileNameBuffer.lastIndexOf("."), java.util.UUID.randomUUID().toString());
        String filePath = dirPath + "/" + fileNameBuffer.toString();
        File file = new File(filePath);
        if (!file.exists())
            file.createNewFile();

        try {
            FileOutputStream fos = new FileOutputStream(file);
            FileInputStream fis = new FileInputStream(getUpload());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fis.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            file.delete();
        }

        //return abstract savepath to save into database
        StringBuffer abstractSavePath = new StringBuffer(savePath);
        abstractSavePath.append("/").append(c.get(Calendar.YEAR)).append("/").append(c.get(Calendar.MONTH)).append("/").append(c.get(Calendar.DATE)).append("/")
            .append(fileNameBuffer.toString());
        return abstractSavePath.toString();
    }
}
