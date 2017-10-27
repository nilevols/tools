import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class A 
{
    private static String content = "";
    
    public static void main(String[] args) {
        String pathname = "C:\\Users\\17091072\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\svnupdate.bat";
        String inputCharset = "utf-8";
        String outputCharset = "GBK";
        load(pathname, inputCharset);
        output(pathname, outputCharset);
        System.out.println("DONE!");
    }
    
    private static void load(String pathname, String charset)
    {
        FileInputStream fos = null;
        try {
            fos = new FileInputStream(new File(pathname));
            byte[] cache = new byte[1024];
            while(fos.read(cache) > 0);
                content = content + new String(cache, charset);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    
    private static void output(String pathname, String charset)
    {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(pathname));
            fos.write(content.getBytes(charset));
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
