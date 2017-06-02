package core.blog.control;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * test
 *
 * Created by wangjianan on 17-6-1.
 */
public class RecordLoanFeeServiceImplTest {

    public static void main(String[] arg0) {
        RecordLoanFee recordLoanFee = new RecordLoanFee();
//        Method[] methods = RecordLoanFee.class.getMethods();
//        for (Method method : methods) {
//            System.out.println("method = " + method.getName());
//        }
//
//        Field[] fields = RecordLoanFee.class.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println("field = " + field.getName());
//        }
//
//        try {
//
//
//            Field field = RecordLoanFee.class.getDeclaredField("profitRate");
//            System.out.println("field by name = " + field.getName());
//
//            Method method = RecordLoanFee.class.getDeclaredMethod("setUpdateTime", Integer.class);
//            System.out.println("method by name = " + method.getName());
//
//            String fieldName = "profitRate";
//            System.out.println("×××××××× = " + "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
//            System.out.println("×××××××× = " + fieldName.replace("Rate", "Fee"));
//
//            try {
//                method.invoke(recordLoanFee, 1234);
//
//                System.out.println("recordLoanFee by name = " + recordLoanFee);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }


        //LinkedHashMap 有序
        Map maps = new LinkedHashMap();
        maps.put("1", "张三");
        maps.put("3", "王五");
        maps.put("4", "赵六");
        maps.put("2", "李四");
        System.out.println("LinkedHashMap(有序):");
        Iterator it = maps.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry entity = (Map.Entry) it.next();
            System.out.println("[ key = " + entity.getKey() +
                    ", value = " + entity.getValue() + " ]");
        }
        //HashMap 无序
        Map map = new HashMap();
        map.put("1", "张三");
        map.put("3", "王五");
        map.put("2", "李四");
        map.put("4", "赵六");
        it = null;
        System.out.println("HashMap(无序):");
        it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry entity = (Map.Entry) it.next();
            System.out.println("[ key = " + entity.getKey() +
                    ", value = " + entity.getValue() + " ]");
        }
    }
}
