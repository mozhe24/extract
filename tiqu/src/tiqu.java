/**
 * Created by admin on 2017/9/13.
 */

import com.sun.istack.internal.Nullable;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.io.*;
import jxl.*;
import jxl.write.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;
public class tiqu {

    public static String readTxtFile(String filePath, String pattern) {
        StringBuffer str = new StringBuffer();
        Pattern p;
        Matcher m;
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                if (pattern != null) {
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        // System.out.println(lineTxt);
                        p = Pattern.compile(pattern);
                        m = p.matcher(lineTxt);
                        if (m.find()) {
                            str.append(m.group(1) + "\r\n");
                        }
                    }
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return str.toString();
    }

    public static void writeFile(String str, String savePath) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(savePath));
        bw.write(str);
        bw.close();
    }

    /**********************
     * public static void createXLS()//txt转换成xls
     * {
     * <p/>
     * try
     * {
     * //打开文件
     * WritableWorkbook book= Workbook.createWorkbook(new File("测试.xls"));
     * <p/>
     * //生成名为“第一页”的工作表，参数0表示这是第一页
     * WritableSheet sheet=book.createSheet("第一页",0);
     * //在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
     * //以及单元格内容为test
     * Label label=new Label(0,0,"test");
     * //将定义好的单元格添加到工作表中
     * sheet.addCell(label);
     * /*生成一个保存数字的单元格
     * //  必须使用Number的完整包路径，否则有语法歧义
     * //   单元格位置是第二列，第一行，值为789.123
     * jxl.write.Number number = new jxl.write.Number(1,0,789.123);
     * sheet.addCell(number);
     * //写入数据并关闭文件
     * book.write();
     * book.close();
     * <p/>
     * }catch(Exception e)
     * {
     * System.out.println(e);
     * }
     * <p/>
     * }
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String filePath = "E:\\问题排查9-26\\sv_2017092408-admonitor.log";//待处理文件地址
        // "res/";
        String readTxt = readTxtFile(filePath, "sid=(.*) HTTP");
        System.out.println(readTxt);
        writeFile(readTxt, "d:\\result.txt");
    }
}
        /***********************
        //提取特定长度的字段
        List<String> list= new ArrayList<>();
        String str=null;
        File src =new File("D:/result.txt");
        File dst =new File("D:/result2.txt");

        try{
            FileReader fileReader=new FileReader(src);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while((str=bufferedReader.readLine())!=null){
                list.add(str);
            }
            System.out.println(list);
            FileWriter fileWriter=new FileWriter(dst);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            for (int i=0;i<list.size();i++){
                bufferedWriter.write(list.get(i),0,50);
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
         **************/
