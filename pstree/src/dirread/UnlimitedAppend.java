package dirread;

/**
 * StringBuffer功能拓展
 */
public class UnlimitedAppend {
    /**
     * StringBuffer全部添加String
     * @param args 字符串
     */
    public static StringBuffer appendAll(String... args){
        StringBuffer stringBuffer=new StringBuffer();
        for(String str: args){
            try {
                stringBuffer.append(str);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        return stringBuffer;
    }




//    public static String appendAll2String(String... args){
//        StringBuffer stringBuffer=new StringBuffer();
//        for(String str: args){
//            stringBuffer.append(str);
//        }
//        return stringBuffer.toString();
//    }
}
