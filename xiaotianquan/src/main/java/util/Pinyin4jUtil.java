package util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;

public class Pinyin4jUtil {
    /** * 中文字符格式 */
    private static final String CHINESE_PATTERN = "[\\u4E00-\\u9FA5]";


    private static final HanyuPinyinOutputFormat FORMAT =
            new HanyuPinyinOutputFormat();

    static {
        //设置小写
        FORMAT.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //设置不带音调
        FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //设置带v字符
        FORMAT.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    //判断字符串中是否包含中文
    public static boolean containsChinese(String str){
        return str.matches(".*"+ CHINESE_PATTERN +".*");
    }

    public static String[] get(String hanyu)  {
        String[] array = new String[2];
        StringBuffer pinyin = new StringBuffer();
        StringBuffer pinyin_first = new StringBuffer();
        for(int i=0;i<hanyu.length();i++){
            try {
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(hanyu.charAt(i),FORMAT);
                if(pinyins==null || pinyins.length==0){
                    pinyin.append(hanyu.charAt(i));
                    pinyin_first.append(hanyu.charAt(i));
                }
                else{
                    pinyin.append(pinyins[0]);
                    pinyin_first.append(pinyins[0].charAt(0));
                }
            } catch (Exception e) {
                pinyin.append(hanyu.charAt(i));
                pinyin_first.append(hanyu.charAt(i));
            }
        }
        array[0]=pinyin.toString();
        array[1]=pinyin_first.toString();
        return array;

    }


    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        String[] pinyins =  get("中华人民共和as2国");
        System.out.println(Arrays.toString(pinyins));

    }
}
