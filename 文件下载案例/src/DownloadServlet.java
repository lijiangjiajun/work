import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*获取文件名称*/
        String filename = req.getParameter("filename");

        ServletContext context = req.getServletContext();
        String  path = context.getRealPath("/image/"+filename);
        FileInputStream fis = new FileInputStream(path);

        //设置响应类型
        String mimeType = context.getMimeType(filename);
        resp.setHeader("content-type",mimeType);

        //设置响应打开方式
        resp.setHeader("content-disposition","attachment;filename="+filename);



        ServletOutputStream sos =  resp.getOutputStream();
        byte[] buffer = new byte[1024*8];
        int len = 0;
        while((len=fis.read(buffer))!=-1){
            sos.write(buffer,0,len);
        }
        fis.close();

    }
}
