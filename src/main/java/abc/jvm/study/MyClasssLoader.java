package abc.jvm.study;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class MyClasssLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try{
            byte [] result = getClassFromCustomPath(name);
            return defineClass( name ,result , 0 ,result.length) ;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  null ;
    }

    private byte[] getClassFromCustomPath(String name) throws IOException {
        name = name.replace('.','\\');
        String fileName = "E:\\github\\jvm\\target\\classes\\" + name +".class";
        File file = new File(fileName) ;
        FileInputStream inputStream = new FileInputStream(file);
        byte bytes[] = new byte[(int) file.length()];
        inputStream.read(bytes) ;
        inputStream.close();;
        return bytes ;
    }

    public static void main(String[] args) {
        MyClasssLoader myClasssLoader = new MyClasssLoader();
        try{
            Class<?> clazz = myClasssLoader.findClass("abc.jvm.study.ClassOne");;
            Object obj = clazz.newInstance() ;
            Method method = clazz.getMethod("setName", String.class);
            method.invoke(obj,"zhangsan");
            System.out.println(obj.toString());
            System.out.println(obj.getClass().toString());
            System.out.println(obj.getClass().getClassLoader().toString());
            System.out.println(obj.getClass().getClassLoader().getParent().toString());
            System.out.println(obj.getClass().getClassLoader().getParent().getParent().toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
